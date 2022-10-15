package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Score;
import com.reto3.reto3.repository.ScoreRepository;


@Service
public class ScoreService {


    @Autowired
    private ScoreRepository scoreRepository; 

    public List<Score> getScoreFull() {
        return scoreRepository.getScoreFull();

    }

    public Optional<Score> getScoreId(Integer idScore) {
        return scoreRepository.getScoreId(idScore);
    }

    public Score saveScore(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.saveScore(score);
            
        }else{
            Optional<Score> scoreAux = scoreRepository.getScoreId(score.getIdScore());
            if (scoreAux.isEmpty()) {
                return scoreRepository.saveScore(score);
                
            }else{
                return score;
            }
        }
    }

}
