package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Score;
import com.reto3.reto3.repository.crud.ScoreCrudRepositoryInterface;


@Repository
public class ScoreRepository {

    @Autowired
    public ScoreCrudRepositoryInterface scoreCrudRepositoryInterface;

    public List<Score> getScoreFull() {
        return (List<Score>) scoreCrudRepositoryInterface.findAll();
    }

    public Optional<Score> getScoreId(int IdScore) {
        return scoreCrudRepositoryInterface.findById(IdScore);
    }

    public Score saveScore(Score score){
        return scoreCrudRepositoryInterface.save(score);
    }
}
