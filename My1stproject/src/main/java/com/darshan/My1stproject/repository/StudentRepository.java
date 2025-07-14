package com.darshan.My1stproject.repository;

import com.darshan.My1stproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // no need to write any code, all CRUD is auto-generated!
}

