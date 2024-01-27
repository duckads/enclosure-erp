package kr.co.shield.utility;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	
	private static final int COMPRESSION_LEVEL = 8;
	private static final int BUFFER_SIZE = 1024 * 2;
	
	/**
	 * 지정된 폴더를 Zip 파일로 압축한다.
	 * @param sourcePath - 압축 대상 디렉토리
	 * @param output - 저장 zip 파일 이름
	 * @throws Exception
	 */
	public static void zip(String sourcePath, String output) throws Exception {
		// 압축 대상(sourcePath)이 디렉토리나 파일이 아니면 리턴한다.
		File sourceFile = new File(sourcePath);
		if(!sourceFile.isFile() && !sourceFile.isDirectory()) {
			throw new Exception("압축 대상의 파일을 찾을 수가 없습니다.");
		} else if(sourceFile.isFile()) {
			sourcePath = sourceFile.getParent();
		}
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ZipOutputStream zos = null;
		
		try {
			fos = new FileOutputStream(output);
			bos = new BufferedOutputStream(fos);
			zos = new ZipOutputStream(bos);
			zos.setLevel(COMPRESSION_LEVEL); // 압축 레벨 - 최대 압축률은 9, 디폴트 8
			zipEntry(sourceFile, sourcePath, zos); // Zip 파일 생성
			zos.finish();
			new File(output).setReadable(true, false);
		} finally {
			if(zos != null) { zos.close(); }
			if(bos != null) { bos.close(); }
			if(fos != null) { fos.close(); }
		}
	}
	
	/**
	 * 압축
	 * @param sourceFile
	 * @param sourcePath
	 * @param zos
	 * @throws Exception
	 */
	private static void zipEntry(File sourceFile, String sourcePath, ZipOutputStream zos) throws Exception {
		// sourceFile 이 디렉토리인 경우 하위 파일 리스트 가져와 재귀호출
		if(sourceFile.isDirectory()) {
			if(sourceFile.getName().equalsIgnoreCase(".metadata")) { // .metadata 디렉토리 return
				return;
			}
			File[] fileArr = sourceFile.listFiles(); // sourceFile 의 하위 파일 리스트
			for(File file : fileArr) {
				zipEntry(file, sourcePath, zos); // 재귀 호출
			}
		} else { // sourcehFile 이 디렉토리가 아닌 경우
			BufferedInputStream bis = null;
			try {
				String sFilePath = sourceFile.getPath();
				String zipEntryName = sFilePath.substring(sourcePath.length() + 1, sFilePath.length());
				
				bis = new BufferedInputStream(new FileInputStream(sourceFile));
				ZipEntry zentry = new ZipEntry(zipEntryName);
				zentry.setTime(sourceFile.lastModified());
				zos.putNextEntry(zentry);
				
				byte[] buffer = new byte[BUFFER_SIZE];
				int cnt = 0;
				while((cnt = bis.read(buffer, 0, BUFFER_SIZE)) != -1) {
					zos.write(buffer, 0, cnt);
				}
				zos.closeEntry();
			} finally {
				if(bis != null) { bis.close(); }
			}
		}
	}

	/**
	 * Zip 파일을 지정된 폴더에 압축 해제한다.
	 * @param targetPath - 압축 해제 디렉토리
	 * @param input - 해제 zip 파일 이름
	 * @throws Exception
	 */
	public static void unzip(String targetPath, String input) throws Exception {
		// 압축 대상(sourcePath)이 디렉토리나 파일이 아니면 리턴한다.
		File targetDir = new File(targetPath);
		if(!targetDir.exists() && !targetDir.mkdir()) {
			throw new Exception("압축 해제 폴더를 생성할 수가 없습니다.");
		}
		
		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry entry = null;
		
		try {
			fis = new FileInputStream(input);
			zis = new ZipInputStream(fis);
			
			while((entry = zis.getNextEntry()) != null) {
				String fileName = entry.getName().toLowerCase();
				
				File targetFile = new File(targetPath, fileName);
				if(entry.isDirectory()) {
					targetFile.mkdir();
				} else {
					unzipEntry(targetFile, zis);
				}
			}
		} finally {
			if(zis != null) { zis.close(); }
			if(fis != null) { fis.close(); }
		}
	}
	
	/**
	 * 압축 해제
	 * @param targetFile
	 * @param zis
	 * @throws Exception
	 */
	private static void unzipEntry(File targetFile, ZipInputStream zis) throws Exception {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(targetFile);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while((len = zis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} finally {
			if(fos != null) { fos.close(); }
		}
	}
	
	public static void ungzip(String targetPath, String input) throws Exception {
		byte[] buffer = new byte[1024];
		
		try {
			File file = new File(input);
			String filename = file.getName().replaceAll("\\.gz", "");
			
			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(input));
			FileOutputStream out = new FileOutputStream(targetPath + filename);
			
			int len;
			while ((len = gzis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			
			gzis.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
