package com.zy.code.repository;

import com.zy.code.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("select s from Student s where s.classInSchoolId =:classInSchoolId")
    List<Student> findStudentByClassInSchoolId(@Param("classInSchoolId") Long classInSchoolId);

    List<Student> findByClassInSchoolId(Long id);
}
