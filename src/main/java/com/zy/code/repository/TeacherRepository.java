package com.zy.code.repository;

import com.zy.code.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findByTeacherName(String teacherName);

}
