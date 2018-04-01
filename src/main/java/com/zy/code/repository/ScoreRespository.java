package com.zy.code.repository;

import com.zy.code.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRespository extends JpaRepository<Score,Long>{
}
