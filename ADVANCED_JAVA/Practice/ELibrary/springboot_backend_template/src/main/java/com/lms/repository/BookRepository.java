package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Book;
import com.lms.entity.Category;
import com.lms.entity.Member;


public interface BookRepository extends JpaRepository<Book, Long>  {

	public boolean existsByIssuedTo(Member m);		
	public List<Book> findByCategory(Category category);
}
