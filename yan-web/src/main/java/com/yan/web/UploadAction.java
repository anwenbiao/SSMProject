package com.yan.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/uploadAction")
public class UploadAction {
	
	private static final Log logger=LogFactory.getLog(UploadAction.class);
	/**
	 * 使用流的方式上传文件
	 * @param file
	 * @param request
	 */
	@RequestMapping("/upload")
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		logger.info("文件保存的路径:"+path);
		
		String fileName = file.getOriginalFilename();
		logger.info("文件的名字："+fileName);
		
		String fileType=file.getContentType();
		logger.info("文件类型："+fileType);
		
		path+=File.separator+"fileUpload";
		
		InputStream input=null;
		FileOutputStream output = null;
		
		try{
			//创建目录
			File dir=new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}
			//创建文件
			File filePath=new File((path+fileName));
			if(!filePath.exists()){
					filePath.createNewFile();
			}
			
			//读取文件
			input = file.getInputStream();
			output=new FileOutputStream(filePath);
			
			int num=0;
			while((num=input.read())!=-1){
				output.write(num);
			}
			
	
		}catch (Exception e) {
			logger.debug("文件创建失败:"+e);
		}finally{
			try {
				if(output != null){
					output.flush();
					output.close();
				}
				if(input != null){
					input.close();
				}
			} catch (IOException e1) {
				logger.error(e1, e1);
			}
		}
		
		
		
	}
	
	
	/**
	 * 使用mvc的方式进行上传
	 * @param file
	 * @param request
	 */
	@RequestMapping("/mvcUpload")
	public void mvcUpload(@RequestParam("mvcfile") CommonsMultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		logger.info("文件保存的路径:"+path);
		
		String fileName = file.getOriginalFilename();
		logger.info("文件的名字："+fileName);
		
		File filePath=new File(path,fileName);
		try{
			
		if(!filePath.exists()){
			filePath.createNewFile();
		}
		file.transferTo(filePath);
		}catch (Exception e) {
			logger.debug("文件失败"+e);
		}
	}
	
	
	
	
	
	
	
	
	

}
