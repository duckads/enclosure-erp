package kr.co.shield.service.impl.ext;

import jakarta.annotation.PostConstruct;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.service.inf.ext.MessageService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
	
	private final JavaMailSender javaMailSender;
	
	@Value("${spring.mail.sender:}")
	private String mailSender;
	@Value("${spring.mail.username}")
	private String mailUsername;
	
	@Value("${spring.telegram.domain:}")
	private String telegramDomain;
	@Value("${spring.telegram.token:}")
	private String telegramToken;
	@Value("${spring.telegram.chat-id:0}")
	private Long telegramChatId;
	
	@PostConstruct
	private void init() {
		if (this.mailSender.isBlank()) {
			this.mailSender = this.mailUsername;
		}
	}
	
	/**
	 * [0] recipients
	 * [1]~ cc
	 */
	@Override
	public String sendMail(String subject, String contents, Map<Integer, Object> inlineMap, List<String> fileList, String ... recipients) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		try {
			List<InternetAddress> addressList = new ArrayList<>();
			List<InternetAddress> ccList = new ArrayList<>();
			String cc = "";
			for (int inx = 0; inx < recipients.length; inx++) {
				for (String r : recipients[inx].split(",")) {
					r = r.trim();
					if (r.length() > 0) {
						if (inx == 0) {
							addressList.add(new InternetAddress(r)); // 수신자로 설정
						} else {
							ccList.add(new InternetAddress(r)); // 참조로 설정
							cc += " " + "r";
						}
					}
				}
			}
			
			final MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings("unchecked")
				public void prepare(MimeMessage mimeMessage) throws Exception {
					final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom(mailSender);
					helper.setTo(addressList.toArray(new InternetAddress[addressList.size()]));
					if (ccList != null && ccList.size() > 0) {
						helper.setCc(ccList.toArray(new InternetAddress[ccList.size()]));
					}
					helper.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
					helper.setText(contents, true);
					
					if (inlineMap != null && inlineMap.size() > 0) {
						String inlinePath = StringUtils.getString(inlineMap.get(INLINE_PATH));
						List<String> inlineFiles = (List<String>)inlineMap.get(INLINE_FILE);
						for (String inlineFile : inlineFiles) {
							File imageFile = new File(inlinePath + File.separator + inlineFile);
							if (imageFile.exists()) {
								FileSystemResource imageResource = new FileSystemResource(imageFile);
								helper.addInline(inlineFile.substring(0, inlineFile.lastIndexOf(".")), imageResource);
							}
						}
					}
					
					if (fileList != null && fileList.size() > 0) {
						for (String fileNm : fileList) {
							File file = new File(fileNm);
							helper.addAttachment(file.getName(), new FileSystemResource(file));
						}
					}
				}
			};
			
			this.javaMailSender.send(preparator);
			
			rtnMsg += "Send " + fileList + " to " + recipients + (cc.isBlank() ? "" : " (cc. " + cc.substring(1) + ")");
		} catch (Exception e) {
			rtnMsg = ShieldProperty.RK_MSG_FAILURE + e.getMessage();
			e.printStackTrace();
		}
		
		return rtnMsg;
	}
	
	@Override
	public String sendTelegram(String message) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		if (this.telegramChatId == 0L) {
			rtnMsg = ShieldProperty.RK_MSG_FAILURE + "No telegram chat id";
			log.error("MSG# {}", rtnMsg);
		} else {
			try {
				StringBuilder sb = new StringBuilder(this.telegramDomain);
				sb.append(this.telegramToken);
				sb.append("/sendmessage?chat_id=");
				sb.append(this.telegramChatId);
				sb.append("&text=");
				sb.append(URLEncoder.encode(message, "UTF-8"));
				// https://api.telegram.org/bot762781963:AAHVZ8jNV7VhVCdM53J2rOo36AjljYjgLNI/getUpdates
				// https://api.telegram.org/bot762781963:AAHVZ8jNV7VhVCdM53J2rOo36AjljYjgLNI/sendmessage?chat_id=-1001478505402&text=test_message
				
				URL url = new URL(sb.toString());
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				
				String _msg = null;
				while ((_msg = in.readLine()) != null) {
					rtnMsg += _msg;
					break;
				}
				in.close();
			} catch (Exception e) {
				e.getMessage();
				rtnMsg = ShieldProperty.RK_MSG_FAILURE + e.getMessage();
			}
		}
		
		return rtnMsg;
	}
	
}
