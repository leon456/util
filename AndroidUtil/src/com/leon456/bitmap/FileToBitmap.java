package com.leon456.bitmap;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FileToBitmap {
	
	static public Bitmap get(File file){
		BufferedInputStream bis = null;
		try {
			final FileInputStream fis = new FileInputStream(file);
			if(fis.available()>0)
				bis = new BufferedInputStream(fis, fis.available());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		BitmapFactory.Options opt = new BitmapFactory.Options();  
		opt.inPreferredConfig = Bitmap.Config.ARGB_8888;   
		opt.inPurgeable = true;  
		opt.inInputShareable = true; 
        Bitmap bitmap = BitmapFactory.decodeStream(bis,null,opt);
        file.delete();
        return bitmap;
	}
	
	public static String randomFile() {
        return ((Long)Math.round(Math.random() * 1000)).toString() + ".png";
    }
}
