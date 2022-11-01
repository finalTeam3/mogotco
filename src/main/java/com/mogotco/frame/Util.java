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

}
