package com.web.bl.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

	
	@RequestMapping(value = "/download_pod_sample_file", method = RequestMethod.GET)
	public void downl1oad(HttpServletResponse response, @RequestParam String fileName) {
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		String ticketFolderName = null;
		/*Tomcat Rootpath*/
		String rootPath = System.getProperty("catalina.home");
		/*JBoss RootPath*/
		//String rootPath="/u03/jboss/apps";
		//String rootPath = System.getProperty("jboss.server.base.dir");
		//System.out.println(fileName);
		try {
			ticketFolderName = "";//httpSession.getAttribute("ticketNumberToCreateFolder").toString();
			file = new File(rootPath + File.separator + "POD_Sample_File" + File.separator + ticketFolderName
					+ File.separator + fileName);
			is = new FileInputStream(file);

			// MIME type of the file
			response.setContentType("application/octet-stream");
			// Response header
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			// Read from the file and write into the response
			os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			
		} catch (Exception e) {

		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (os != null) {
					is.close();
				}
			} catch (IOException io) {
				// Log that failed to close filestreams
			}
		}
	}
}
