package com.pad.base.common;

import com.pad.base.common.systemreturn.ReturnCode;
import com.pad.base.common.systemreturn.ReturnValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunDosCommand {
	private static Logger logger = LogManager.getLogger(RunDosCommand.class);

	@SuppressWarnings("rawtypes")
	public static ReturnValue run(String oldpath, String newvideopath, String newpicturepath, String type) {
		ReturnValue ret = new ReturnValue();
		// String FormatChange = "ffmpeg -y -framerate 12 -i "+oldpath+" -vcodec
		// copy "+newvideopath+" ";
//		String FormatChange = "cmd.exe /c d: & cd / & cd D:/ffmpeg/bin & ffmpeg -y -i "
//				+ oldpath + " -vcodec copy " + newvideopath;
//		String InterceptionPicture = "cmd.exe /c d: & cd / & cd D:/ffmpeg/bin & ffmpeg -i " + newvideopath
//				+ " -y -f image2  -ss 00:00:01 -vframes 1 " + newpicturepath;
		String FormatChange = "ffmpeg -y -i " + oldpath + " -vcodec copy -strict -2 " + newvideopath;
		String InterceptionPicture = "ffmpeg -i " + newvideopath + " -y -f image2  -ss 00:00:01 -vframes 1 " + newpicturepath;

		try {
			String Command = "";
			if (type.equals("1")) {
				Command = FormatChange;
			} else if (type.equals("2")) {
				Command = InterceptionPicture;
			}
			logger.info("Command:"+Command);
			Process process = Runtime.getRuntime().exec(Command);
			int exitValue = process.waitFor();
			System.out.println("返回值：" + exitValue);
			ret.setRetCode(ReturnCode.SUCCESS);

		} catch (Exception e) {
			logger.info("命令执行失败：" + e.toString());
			ret.setRetCode(ReturnCode.FAIL);
		}
		return ret;
	}
}
