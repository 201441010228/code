package com.zy.code.repository;

import com.zy.code.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SubjectRespository extends JpaRepository<Subject,Long> {

    @Modifying
    @Transactional
    @Query("select s from Subject s where s.schoolId =:schoolId")
    List<Subject> findBySchoolId(@Param("schoolId")Long schoolId);

}
