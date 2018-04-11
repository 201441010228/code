package com.zy.code.repository;


import com.zy.code.entity.ClassInSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClassInSchoolRespository extends JpaRepository<ClassInSchool, Long> {

    List<ClassInSchool> findBySchoolId(Long schoolId);
}
