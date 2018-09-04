package com.fenbi.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class DownLoadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 下载页面通过servlet来响应，下载即读取文件，输出到响应消息中，一次io操作
		 * 在接收到请求之后，设置一些响应头信息，正确下载， 文件类型、下载方式  
		 */
		
		//1.获取要下载文件的服务器路径,文件名
		String realPath = getServletContext().getRealPath("/WEB-INF/setup_student_2.0.0.1154.exe");
		System.out.println(realPath);
		String filename = "粉笔pc客户端.exe";
		
		//当文件名有中文时，需要进行url编码(火狐的编码方式不一样，所以需要对访问浏览器进行判断，通过请求头信息字段User-Agent
		String userAgent = request.getHeader("User-Agent");
		
		if(userAgent.contains("Firefox")) {//重新编码再解码
			
			filename = new String(filename.getBytes("gbk"),"iso8859-1");
			
		}else {//其他浏览器通过URL编码
			filename = URLEncoder.encode(filename, "utf-8");
		}
			
		//2.封装IO流
		FileInputStream in = new FileInputStream(realPath);
		ServletOutputStream out = response.getOutputStream();
		
		//3.设置头消息
		String mimeType = getServletContext().getMimeType(realPath);
		response.setContentType(mimeType);
		
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		//4.传送文件IO操作
		IOUtils.copy(in, out);
		out.close();
		in.close();
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}