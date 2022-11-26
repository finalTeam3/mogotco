package com.mogotco.frame;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf, String reviewdir) {
		byte[] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo2 = new FileOutputStream(reviewdir + imgname);
			fo2.write(data);
			fo2.close();
		} catch (Exception e) {

		}

	}
	
	// 멘토 등록 페이지 파일용 메서드
	public static void saveMentorFile(MultipartFile mf1, MultipartFile mf2, String admindir, String userdir) {
		byte[] data1;
		byte[] data2;
		
		String mpimgname = mf1.getOriginalFilename();
		String mcimgname = mf2.getOriginalFilename();
		
		try {
			// 멘토 프로필 이미지 파일 저장
			data1 = mf1.getBytes();
			FileOutputStream fo11 = new FileOutputStream(admindir + mpimgname);
			fo11.write(data1);
			fo11.close();
			FileOutputStream fo12 = new FileOutputStream(userdir + mpimgname);
			fo12.write(data1);
			fo12.close();
			
			// 멘토 명함 파일 저장
			data2 = mf2.getBytes();
			FileOutputStream fo21 = new FileOutputStream(admindir + mcimgname);
			fo21.write(data2);
			fo21.close();
			FileOutputStream fo22 = new FileOutputStream(userdir + mcimgname);
			fo22.write(data2);
			fo22.close();
		} catch (Exception e) {

		}

	}
	
	// 멘토 카드 저장
	public static void saveMcFile(MultipartFile mf1, String admindir, String userdir) {
		byte[] data1;
		
		String mpimgname = mf1.getOriginalFilename();
		
		try {
			// 멘토 프로필 이미지 파일 저장
			data1 = mf1.getBytes();
			FileOutputStream fo11 = new FileOutputStream(admindir + mpimgname);
			fo11.write(data1);
			fo11.close();
			FileOutputStream fo12 = new FileOutputStream(userdir + mpimgname);
			fo12.write(data1);
			fo12.close();
			
		} catch (Exception e) {
			
		}
		
	}
	
	
}
