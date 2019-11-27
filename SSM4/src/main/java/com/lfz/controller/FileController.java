package com.lfz.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("upload");

		String fileName = file.getOriginalFilename();
		System.out.println(path);
		System.out.println(fileName);
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		file.transferTo(dir);
		return "success";
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
		// 指定要下载的文件所在路径
		String path = request.getSession().getServletContext().getRealPath("upload");
		// 创建该文件对象
		File file = new File(path + File.separator + filename);
		// 对文件名编码，防止中文文件乱码
		filename = this.getFilename(request, filename);
		// 设置响应头
		HttpHeaders headers = new HttpHeaders();
		// 通知浏览器以下载的方式打开文件
		headers.setContentDispositionFormData("attachment", filename);
		// 定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * 根据浏览器的不同进行编码设置，返回编码后的文件名
	 */
	public String getFilename(HttpServletRequest request, String filename) throws Exception {
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWords) {
			if (userAgent.contains(keyWord)) {
				// IE内核浏览器，统一为UTF-8编码显示
				return URLEncoder.encode(filename, "UTF-8");
			}
		}
		// 火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	}
}
