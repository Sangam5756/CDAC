package com.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.BookCreateRequest;
import com.lms.dto.BookIssueRequest;
import com.lms.services.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
	private final BookService bookService;

	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody @Valid BookCreateRequest bookRequest) {
		return ResponseEntity.ok(bookService.addBook(bookRequest));
	}

	@PostMapping("/issuebook")
	public ResponseEntity<?> issueBookToMember(@RequestBody @Valid BookIssueRequest bookIssue) {
		return ResponseEntity.ok(bookService.issueBook(bookIssue));
	}

	@PatchMapping("/{bookId}/return")
	public ResponseEntity<?> returnBook(@PathVariable Long bookId) {

		return ResponseEntity.ok(bookService.returnBook(bookId));
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<?> getBooksByCategory(@PathVariable String category){
		
		return ResponseEntity.ok(bookService.getByCategory(category));
	}
}
