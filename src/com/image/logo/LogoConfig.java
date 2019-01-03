package com.image.logo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class LogoConfig {

	public static final String QRCODE_DEFAULT_CHARSET = "UTF-8";

	public static final int QRCODE_DEFAULT_HEIGHT = 450;

	public static final int QRCODE_DEFAULT_WIDTH = 450;

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private static final int QRCOLOR = 0xFF6EB4FF; // 默认是黑色
	private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色

	public static void main(String[] args) throws IOException,
			NotFoundException {
		String data = "http://www.baidu.com";
		// logo图片路径(这是相对路径)
		File logoFile = new File("E:/Camera/01.jpg");
		BufferedImage image = LogoConfig.createQRCodeWithLogo(data, logoFile);
		// 生成图片 不需要的话注释即可
		ImageIO.write(image, "png", new File("E:/test.png"));
		// 转换成base64字符串
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(image, "png", os);
		Base64 base64 = new Base64();
		String base64Img = new String(base64.encode(os.toByteArray()));
		System.err.println(base64Img);
	}

	/**
	 * Create qrcode with default settings
	 * 
	 * @author stefli
	 * @param data
	 * @return
	 */
	public static BufferedImage createQRCode(String data) {
		return createQRCode(data, QRCODE_DEFAULT_WIDTH, QRCODE_DEFAULT_HEIGHT);
	}

	/**
	 * Create qrcode with default charset
	 * 
	 * @author stefli
	 * @param data
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage createQRCode(String data, int width, int height) {
		return createQRCode(data, QRCODE_DEFAULT_CHARSET, width, height);
	}

	/**
	 * Create qrcode with specified charset
	 * 
	 * @author stefli
	 * @param data
	 * @param charset
	 * @param width
	 * @param height
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BufferedImage createQRCode(String data, String charset,
			int width, int height) {
		Map hint = new HashMap();
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hint.put(EncodeHintType.CHARACTER_SET, charset);

		return createQRCode(data, charset, hint, width, height);
	}

	/**
	 * Create qrcode with specified hint
	 * 
	 * @author stefli
	 * @param data
	 * @param charset
	 * @param hint
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage createQRCode(String data, String charset,
			Map<EncodeHintType, ?> hint, int width, int height) {
		BitMatrix matrix;
		try {
			matrix = new MultiFormatWriter().encode(
					new String(data.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, width, height, hint);
			return toBufferedImage(matrix);
		} catch (WriterException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	/**
	 * Create qrcode with default settings and logo
	 * 
	 * @author stefli
	 * @param data
	 * @param logoFile
	 * @return
	 */
	public static BufferedImage createQRCodeWithLogo(String data, File logoFile) {
		return createQRCodeWithLogo(data, QRCODE_DEFAULT_WIDTH,
				QRCODE_DEFAULT_HEIGHT, logoFile);
	}

	/**
	 * Create qrcode with default charset and logo
	 * 
	 * @author stefli
	 * @param data
	 * @param width
	 * @param height
	 * @param logoFile
	 * @return
	 */
	public static BufferedImage createQRCodeWithLogo(String data, int width,
			int height, File logoFile) {
		return createQRCodeWithLogo(data, QRCODE_DEFAULT_CHARSET, width,
				height, logoFile);
	}

	/**
	 * Create qrcode with specified charset and logo
	 * 
	 * @author stefli
	 * @param data
	 * @param charset
	 * @param width
	 * @param height
	 * @param logoFile
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BufferedImage createQRCodeWithLogo(String data,
			String charset, int width, int height, File logoFile) {
		Map hint = new HashMap();
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hint.put(EncodeHintType.CHARACTER_SET, charset);

		return createQRCodeWithLogo(data, charset, hint, width, height,
				logoFile);
	}

	/**
	 * Create qrcode with specified hint and logo
	 * 
	 * @author stefli
	 * @param data
	 * @param charset
	 * @param hint
	 * @param width
	 * @param height
	 * @param logoFile
	 * @return
	 */
	public static BufferedImage createQRCodeWithLogo(String data,
			String charset, Map<EncodeHintType, ?> hint, int width, int height,
			File logoFile) {
		try {
			BufferedImage qrcode = createQRCode(data, charset, hint, width,
					height);
			BufferedImage logo = ImageIO.read(logoFile);
			int deltaHeight = height - logo.getHeight();
			int deltaWidth = width - logo.getWidth();

			BufferedImage combined = new BufferedImage(height, width,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) combined.getGraphics();
			g.drawImage(qrcode, 0, 0, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					1f));
			g.drawImage(logo, (int) Math.round(deltaWidth / 2),
					(int) Math.round(deltaHeight / 2), null);

			return combined;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Return base64 for image
	 * 
	 * @author stefli
	 * @param image
	 * @return
	 */
	public static String getImageBase64String(BufferedImage image) {
		String result = null;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			OutputStream b64 = new Base64OutputStream(os);
			ImageIO.write(image, "png", b64);
			result = os.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Decode the base64Image data to image
	 * 
	 * @author stefli
	 * @param base64ImageString
	 * @param file
	 */
	public static void convertBase64StringToImage(String base64ImageString,
			File file) {
		FileOutputStream os;
		try {
			Base64 d = new Base64();
			byte[] bs = d.decode(base64ImageString);
			os = new FileOutputStream(file.getAbsolutePath());
			os.write(bs);
			os.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	// 用于设置QR二维码参数
	private static HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
		private static final long serialVersionUID = 1L;
		{
			put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
			put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码方式
			put(EncodeHintType.MARGIN, 0);
		}
	};

	// 生成带logo的二维码图片
	public static void drawLogoQRCode(File logoFile, File codeFile,
			String qrUrl, String note) {
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			// 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
			BitMatrix bm = multiFormatWriter.encode(qrUrl,
					BarcodeFormat.QR_CODE, QRCODE_DEFAULT_WIDTH,
					QRCODE_DEFAULT_HEIGHT, hints);
			BufferedImage image = new BufferedImage(QRCODE_DEFAULT_WIDTH,
					QRCODE_DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
			// 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
			for (int x = 0; x < QRCODE_DEFAULT_WIDTH; x++) {
				for (int y = 0; y < QRCODE_DEFAULT_HEIGHT; y++) {
					image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
				}
			}
			int width = image.getWidth();
			int height = image.getHeight();
			if (Objects.nonNull(logoFile) && logoFile.exists()) {
				// 构建绘图对象
				Graphics2D g = image.createGraphics();
				// 读取Logo图片
				BufferedImage logo = ImageIO.read(logoFile);
				// 开始绘制logo图片
				g.drawImage(logo, width * 2 / 5, height * 2 / 5,
						width * 2 / 10, height * 2 / 10, null);
				g.dispose();
				logo.flush();
			} // 自定义文本描述
			if (note != null) {
				// 新的图片，把带logo的二维码下面加上文字
				BufferedImage outImage = new BufferedImage(QRCODE_DEFAULT_WIDTH, QRCODE_DEFAULT_HEIGHT,
						BufferedImage.TYPE_4BYTE_ABGR);
				Graphics2D outg = outImage.createGraphics();
				// 画二维码到新的面板
				outg.drawImage(image, 0, 0, image.getWidth(),
						image.getHeight(), null);
				// 画文字到新的面板//字体颜色
				outg.setColor(Color.blue);
				outg.setFont(new Font("楷体", Font.BOLD, 20));
				// 字体、字型、字号
				int strWidth = outg.getFontMetrics().stringWidth(note);
				if (strWidth > 399) {
					//长度过长就截取前面部分
					// 长度过长就换行
					String note1 = note.substring(0, note.length() / 2);
					String note2 = note.substring(note.length() / 2,
							note.length());
					int strWidth1 = outg.getFontMetrics().stringWidth(note1);
					int strWidth2 = outg.getFontMetrics().stringWidth(note2);
					outg.drawString(note1, 200 - strWidth1 / 2, height
							+ (outImage.getHeight() - height) / 2 + 12);
					BufferedImage outImage2 = new BufferedImage(200, 200,
							BufferedImage.TYPE_4BYTE_ABGR);
					Graphics2D outg2 = outImage2.createGraphics();
					outg2.drawImage(outImage, 0, 0, outImage.getWidth(),
							outImage.getHeight(), null);
					outg2.setColor(Color.BLACK);
					outg2.setFont(new Font("宋体", Font.BOLD, 30));
					// 字体、字型、字号
					outg2.drawString(
							note2,
							200 - strWidth2 / 2,
							outImage.getHeight()
									+ (outImage2.getHeight() - outImage
											.getHeight()) / 2 + 5);
					outg2.dispose();
					outImage2.flush();
					outImage = outImage2;
				} else {
					//文字位置
					outg.drawString(note, 170, 300);
					// 画文字
				}
				outg.dispose();
				outImage.flush();
				image = outImage;
			}
			image.flush();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", outputStream);
			/*BASE64Encoder encoder = new BASE64Encoder();
			//生成base64码
			String base64Img = encoder.encode(outputStream.toByteArray());*/
			String base64Img = new String(java.util.Base64.getEncoder().encode(outputStream.toByteArray()),"utf-8");
			System.out.println(base64Img);
			ImageIO.write(image, "png", codeFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() throws WriterException {	        
		File logoFile = new File("E:/2234.jpg");	        
		File QrCodeFile = new File("E:/test.png");	        
		String url = "https://www.baidu.com/";	        
		String note = "你倒是出来啊";	        
		drawLogoQRCode(logoFile, QrCodeFile, url, note);	    
		}



}
