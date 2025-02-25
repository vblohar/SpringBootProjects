package com.vaibhav.documentweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.documentweb.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	
}
