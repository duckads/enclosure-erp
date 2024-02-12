package kr.co.shield.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import kr.co.shield.common.ShieldProperty;
import kr.co.shield.utility.FormatUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {

    public static String uploadMultipartFile(String path, MultipartFile uploadFile) {
        String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;

        try {
            String fileNmOrg = uploadFile.getOriginalFilename();
            String extension = fileNmOrg.substring(fileNmOrg.lastIndexOf("."));

            String fileNmNew = UUID.randomUUID().toString() + extension;

            File photoFile = new File(path + File.separator + fileNmNew);
            uploadFile.transferTo(photoFile);

            String unit = "KB";
            double size = photoFile.length() / 1024D;
            if (size > 1024D) {
                size = size / 1024D;
                unit = "MB";
            }

            rtnMsg += fileNmNew;

            log.info("extractMultipartFiles:: original#{} saved#{} size#{}", fileNmOrg, fileNmNew, (FormatUtils.getFormatString(size, "#,###.0") + unit));
        } catch (Exception e) {
            rtnMsg = ShieldProperty.RK_MSG_FAILURE + e.getMessage();
        }

        return rtnMsg;
    }

}
