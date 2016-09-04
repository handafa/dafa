/**  
 * @Title: UploadController.java
 * @Package cn.dafa.upload.controller
 * @Description: TODO
 * @author 韩大发  
 * @datetime 2013-2-21 下午4:19:02
 * @version V1.0  
 */
package cn.dafa.upload.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.dafa.upload.service.UploadService;

/**
 * @ClassName: UploadController
 * @author 韩大发
 * @email handafa@126.com
 * @datetime 2013-2-21 下午4:19:02
 * @version 【V1.0】
 * @Description: TODO
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	private Logger logger = Logger.getLogger(UploadController.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Object upload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("upload");
		String path = "";
		String result = "";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		path = request.getSession().getServletContext().getRealPath("/");
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile("file");
		
		UploadService mUploadService = new UploadService();
		result = mUploadService.save(path,file);
		response.getWriter().write(result);
		return null;
	}
}
