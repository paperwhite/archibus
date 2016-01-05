package com.hello.springmvc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDownloadController {
	

	@RequestMapping(value={"/","/welcome"}, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "welcome";
	}

	/*
	 * Download a file from 
	 *   - inside project, located in resources folder.
	 *   - outside project, located in File system somewhere. 
	 */
	@RequestMapping(value="/download", method = RequestMethod.POST)
	public String downloadFile(HttpServletResponse response, @RequestParam("file") MultipartFile file) throws IOException {
	
		//File file = null;
		
		
			//file = new File(EXTERNAL_FILE_PATH);
		
		if(file.isEmpty()){
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return "redirect:";
		}
		
		String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimetype : "+mimeType);
		
        response.setContentType(mimeType);
        
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));

        
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile(); 
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        
        fos.close(); 
        response.setContentLength((int)convFile.length());
        
        
        InputStream inputStream = new BufferedInputStream(new FileInputStream(convFile));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        return "redirect:";
	}

}
