package cn.tedu.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.function.Predicate;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ImgAction extends AbstractAction {
	private InputStream img;
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200, 60, BufferedImage.TYPE_3BYTE_BGR);
		Random r = new Random();
		for(int i=0; i<100; i++){
			int x = r.nextInt(img.getWidth());
			int y = r.nextInt(img.getHeight());
			int rgb=r.nextInt(0xffffff);
			img.setRGB(x, y, rgb);
		}
		ByteArrayOutputStream out = 
			new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		return out.toByteArray();
	}
	
	
	public String execute() throws IOException{
		
		byte[] png=createPng();
		img = new ByteArrayInputStream(png);
		
		return SUCCESS;
	}
	
}













