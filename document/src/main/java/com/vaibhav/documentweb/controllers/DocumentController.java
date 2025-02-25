package com.vaibhav.documentweb.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.vaibhav.documentweb.entities.Document;
import com.vaibhav.documentweb.repos.DocumentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DocumentController {

	@Autowired
	DocumentRepository documentRepository;

	@RequestMapping("/showUpload")
	public String showUpload(ModelMap modelMap) {
		List<Document> documents = documentRepository.findAll();
		modelMap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile, @RequestParam("id") long id,
			ModelMap modelMap) {
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		try {
			document.setData(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		documentRepository.save(document);
		List<Document> documents = documentRepository.findAll();
		modelMap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@RequestMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response) {
		Optional<Document> doc = documentRepository.findById(id);
		Document document = doc.get();
		byte[] data = document.getData();
		response.setHeader("content-Disposition", "attachment;filename=downloaded" + document.getId()+".png");
		return outputStream -> {
			outputStream.write(data);
		};
	}
}
