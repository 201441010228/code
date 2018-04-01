package com.zy.code.repository;

import com.zy.code.entity.TeacherAndSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TeacherAndSubjectRepository extends JpaRepository<TeacherAndSubject,Long> {
}
