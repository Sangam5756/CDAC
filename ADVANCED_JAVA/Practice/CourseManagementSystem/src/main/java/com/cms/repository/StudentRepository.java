package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.entities.Course;
import com.cms.entities.Student;


@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>{

}
