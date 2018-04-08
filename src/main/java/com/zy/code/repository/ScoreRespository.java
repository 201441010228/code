package com.zy.code.repository;

import com.zy.code.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ScoreRespository extends JpaRepository<Score,Long> {

    @Modifying
    @Transactional
    @Query("select score from Score score where score.studentId =:studentId and score.year =:year and score.midOrEnd=:midOrEnd")
    List<Score> findScoreByStudentIdAndYear(@Param("studentId") Long studentId, @Param("year") Integer year, @Param("midOrEnd") Integer midOrEnd);


    @Modifying
    @Transactional
    @Query("select score from Score score where score.studentId =:studentId and score.subjectId =:subjectId")
    List<Score> findScoreByStudentIdAndSubjectId(@Param("studentId") Long studentId, @Param("subjectId") Long subjectId);

}
