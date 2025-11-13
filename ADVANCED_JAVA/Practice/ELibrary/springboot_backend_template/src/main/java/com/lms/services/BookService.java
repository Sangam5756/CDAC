package com.lms.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lms.dto.BookCreateRequest;
import com.lms.dto.BookIssueRequest;
import com.lms.dto.BookResponseDTO;
import com.lms.entity.Book;
import com.lms.entity.Category;
import com.lms.entity.Member;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookService {
	private final BookRepository bookRepo;
	private final MemberRepository memberRepo;
	private final ModelMapper mapper;

	public Book addBook(BookCreateRequest bookRequest) {
		Book saved = mapper.map(bookRequest, Book.class);
		return bookRepo.save(saved);
	}

	public String issueBook(@Valid BookIssueRequest bookIssue) {
		Book getBook = bookRepo.findById(bookIssue.getBookId())
				.orElseThrow(() -> new RuntimeException("Book Not Found"));
		Member getMember = memberRepo.findById(bookIssue.getMemberId())
				.orElseThrow(() -> new RuntimeException("Member not exit"));

		if (getBook.getIssuedTo() != null) {
			throw new RuntimeException("Book is already issued");
		}

		getBook.setIssuedTo(getMember);
		bookRepo.save(getBook);

		return "Book issued successfully!";
	}

	public String returnBook(Long bookId) {

		Book getBook = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book Not Found"));

		if (getBook.getIssuedTo() != null) {
			getBook.setIssuedTo(null);
			bookRepo.save(getBook);
		} else {
			throw new RuntimeException("Book Available to issued");
		}

		return "Book Return Successfull";

	}

	public List<Book> getByCategory(String category) {
		
			
				List<BookResponseDTO> byCategory = bookRepo.findByCategory(Category.valueOf(category.toUpperCase()))
						.stream()
			            .map(book -> new BookResponseDTO(
			                    book.,
			                    book.getTitle(),
			                    book.getAuthor(),
			                    book.getCategory().name(),
			                    book.getPublisher(),
			                    book.getPrice())).toList();
			
	}

}
