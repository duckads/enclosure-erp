package kr.co.shield.utility;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FileUtils {
	
	public static String findCharset(String filePath) {
		String charset = "UTF-8";
		
		try (FileInputStream fis = new FileInputStream(filePath)) {
			byte[] buf = new byte[4096];
			
			UniversalDetector detector = new UniversalDetector(null);
			
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			detector.dataEnd();
			
			charset = StringUtils.getString(detector.getDetectedCharset(), charset);
			
			detector.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return charset;
	}
	
	public static String escapeFileName(String fileName) {
		String rtnStr = fileName;
		for (String c : List.of(" ","\\","/",":","*","%","?","\"","<",">","|",",","\n","\r","\t")) {
			String replacement = "_";
			if (c.equals("%")) {
				replacement = "퍼센트";
			}
			rtnStr = rtnStr.replaceAll("\\" + c, replacement);
		}
		return rtnStr;
	}
	
}
