/**  
 * @Title: UploadService.java
 * @Package cn.dafa.upload.service
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-2-21 下午4:27:37
 * @version V1.0  
 */
package cn.dafa.upload.service;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.dafa.common.util.TimeUtil;

/**
 * @ClassName: UploadService
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-2-21 下午4:27:37
 * @version 【V1.0】
 * @Description: TODO
 */
public class UploadService {
	private Logger logger = Logger.getLogger(UploadService.class);

	/**
	 * @param path项目的绝对路径
	 * @Title: save
	 * @Description: 保存图片
	 * @datetime 2013-2-21 下午4:38:56
	 * @param
	 * @return
	 * @throws
	 */
	public String save(String path, CommonsMultipartFile file) {
		logger.info("save");
		String result = "保存成功";
		path += path + "//upload//";
		File f = new File(path, TimeUtil.getTimeStamp() + ".jpg");
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			result = "保存失败" + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			result = "保存失败" + e.getMessage();
		}
		return result;
	}

}
