package kr.co.shield.service.inf.ext;

import java.util.List;
import java.util.Map;

public interface MessageService {
	
	public final int INLINE_PATH = 0;
	public final int INLINE_FILE = 1;
	
	public String sendMail(String subject, String contents, Map<Integer, Object> inlineMap, List<String> fileList, String ... recipients);
	
	public String sendTelegram(String message);
	
}
