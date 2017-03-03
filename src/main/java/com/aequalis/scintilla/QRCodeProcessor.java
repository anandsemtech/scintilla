/**
 * 
 */
package com.aequalis.scintilla;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;


/**
 * @author leoanbarasanm
 *
 */
public class QRCodeProcessor {

	public static final String PATH = "";
	public static byte[] generateQRCode(String bcAddress) {
		ByteArrayOutputStream out = QRCode.from(bcAddress).to(ImageType.PNG).withSize(250, 250).stream();
		
		return out.toByteArray();
	}
	
	public static void main(String[] args) {
		System.out.println(QRCodeProcessor.generateQRCode("LeoAnbarasanM"));
	}
	
}
