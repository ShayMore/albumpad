package com.pad.base.common.tools;//package com.photolink.base.tools;

import com.pad.base.common.RunDosCommand;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* 上传图片分解
* @author YF
*
*/
public class ResourceUtil {

	private static Logger logger = Logger.getLogger(ResourceUtil.class);

	/**
	 * 图片分解
	 * @param picname
	 * @param pic
	 * @param picpath
	 * @return
	 */
	public static String picResolve(String picname, String pic,String picpath) {
		String name = "";
		try {
			if ((StringHelper.isNotNull(picname))|| (StringHelper.isNotNull(pic))) {
				byte[] photoimg = new BASE64Decoder().decodeBuffer(pic);
				for (int i = 0; i < photoimg.length; i++) {
					if (photoimg[i] < 0) {
						int tmp49_47 = i;
						byte[] tmp49_45 = photoimg;
						tmp49_45[tmp49_47] = ((byte) (tmp49_45[tmp49_47] + 256));
					}
				}
				logger.info("图片的大小：" + photoimg.length);

				File logoSaveFile = new File(picpath);
				if (!logoSaveFile.exists()) {
					logoSaveFile.mkdirs();
				}
				String _suffix = "";
				if(StringHelper.isNotNull(picname)){
					_suffix = picname.substring(picname.lastIndexOf("."));
				}else{
					_suffix = ".jpg";
				}

				name = System.currentTimeMillis() + Randnum.getRandomNumber(3)
						+ _suffix;
				if (StringHelper.isNotNull(name)) {
					String fileName = picpath + File.separator + name;
					File file = new File(fileName);
					try {
						FileOutputStream out = new FileOutputStream(file);
						out.write(photoimg);
						out.flush();
						out.close();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			logger.info("图片分解成功 名称：" + name);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("图片分解异常："+e.toString());
			return "";
		}
		return name;
	}

	/**
	 * 视频解码
	 * @param suffix
	 * @param v
	 * @param logoRealPathDir
	 * @return
	 */
	public static String videoResolve(String suffix, String v,String logoRealPathDir) {
		String videoname = "";
		String thumbnail = "";
		String newvideoname = "";
		try {
			if ((StringHelper.isNotNull(logoRealPathDir)) && (StringHelper.isNotNull(v))) {
				byte[] video = new BASE64Decoder().decodeBuffer(v);
				for (int i = 0; i < video.length; i++) {
					if (video[i] < 0) {
						int tmp49_47 = i;
						byte[] tmp49_45 = video;
						tmp49_45[tmp49_47] = ((byte) (tmp49_45[tmp49_47] + 256));
					}
				}
				logger.info("视频的大小：" + video.length);

				File logoSaveFile = new File(logoRealPathDir);
				if (!logoSaveFile.exists()) {
					logoSaveFile.mkdirs();
				}
				if (!StringHelper.isNotNull(suffix)) {
					logger.info("[发送视频]无后缀名形式");
					suffix = ".mp4";
				}
				newvideoname = System.currentTimeMillis() + Randnum.getRandomNumber(3) + ".mp4";
				videoname = System.currentTimeMillis() + Randnum.getRandomNumber(3) + suffix;
				thumbnail = System.currentTimeMillis() + Randnum.getRandomNumber(3) + ".jpg";

				if (StringHelper.isNotNull(videoname)) {
					String fileName = logoRealPathDir + videoname;
					String newfileName = logoRealPathDir+ newvideoname;
					String picName = logoRealPathDir + thumbnail;

					File file = new File(fileName);
					try {
						FileOutputStream out = new FileOutputStream(file);
						out.write(video);
						out.flush();
						out.close();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					//视频转码
					RunDosCommand.run(fileName, newfileName, picName, "1");
					logger.info("[发送视频]视频转码成功");
					//删除原视频
//					FileUtils.delFile(fileName);
//					logger.info("[发送视频]删除原视频成功");
					//生成视频缩略图
					RunDosCommand.run(fileName, newfileName, picName, "2");
					logger.info("[发送视频]生成缩略图成功");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("视频解码异常："+e.toString());
			return "";
		}
		return newvideoname+","+thumbnail;
	}
}
