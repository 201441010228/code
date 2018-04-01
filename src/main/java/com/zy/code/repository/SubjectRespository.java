package com.zy.code.repository;

import com.zy.code.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRespository extends JpaRepository<Subject,Long> {
}
