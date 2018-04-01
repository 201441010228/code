package com.zy.code.repository;


import com.zy.code.entity.ClassInSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClassInSchoolRespository extends JpaRepository<ClassInSchool, Long> {
}
