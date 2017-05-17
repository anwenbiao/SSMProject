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
	 * ʹ�����ķ�ʽ�ϴ��ļ�
	 * @param file
	 * @param request
	 */
	@RequestMapping("/upload")
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		logger.info("�ļ������·��:"+path);
		
		String fileName = file.getOriginalFilename();
		logger.info("�ļ������֣�"+fileName);
		
		String fileType=file.getContentType();
		logger.info("�ļ����ͣ�"+fileType);
		
		path+=File.separator+"fileUpload";
		
		InputStream input=null;
		FileOutputStream output = null;
		
		try{
			//����Ŀ¼
			File dir=new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}
			//�����ļ�
			File filePath=new File((path+fileName));
			if(!filePath.exists()){
					filePath.createNewFile();
			}
			
			//��ȡ�ļ�
			input = file.getInputStream();
			output=new FileOutputStream(filePath);
			
			int num=0;
			while((num=input.read())!=-1){
				output.write(num);
			}
			
	
		}catch (Exception e) {
			logger.debug("�ļ�����ʧ��:"+e);
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
	 * ʹ��mvc�ķ�ʽ�����ϴ�
	 * @param file
	 * @param request
	 */
	@RequestMapping("/mvcUpload")
	public void mvcUpload(@RequestParam("mvcfile") CommonsMultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		logger.info("�ļ������·��:"+path);
		
		String fileName = file.getOriginalFilename();
		logger.info("�ļ������֣�"+fileName);
		
		File filePath=new File(path,fileName);
		try{
			
		if(!filePath.exists()){
			filePath.createNewFile();
		}
		file.transferTo(filePath);
		}catch (Exception e) {
			logger.debug("�ļ�ʧ��"+e);
		}
	}
	
	
	
	
	
	
	
	
	

}
