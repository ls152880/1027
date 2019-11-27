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
		// ָ��Ҫ���ص��ļ�����·��
		String path = request.getSession().getServletContext().getRealPath("upload");
		// �������ļ�����
		File file = new File(path + File.separator + filename);
		// ���ļ������룬��ֹ�����ļ�����
		filename = this.getFilename(request, filename);
		// ������Ӧͷ
		HttpHeaders headers = new HttpHeaders();
		// ֪ͨ����������صķ�ʽ���ļ�
		headers.setContentDispositionFormData("attachment", filename);
		// ������������ʽ���ط����ļ�����
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// ʹ��Sring MVC��ܵ�ResponseEntity�����װ������������
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * ����������Ĳ�ͬ���б������ã����ر������ļ���
	 */
	public String getFilename(HttpServletRequest request, String filename) throws Exception {
		// IE��ͬ�汾User-Agent�г��ֵĹؼ���
		String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
		// ��ȡ����ͷ������Ϣ
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWords) {
			if (userAgent.contains(keyWord)) {
				// IE�ں��������ͳһΪUTF-8������ʾ
				return URLEncoder.encode(filename, "UTF-8");
			}
		}
		// ��������������ͳһΪISO-8859-1������ʾ
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	}
}
