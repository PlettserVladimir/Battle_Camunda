package com.example.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EvaluateBattle implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(EvaluateBattle.class);

    @Override
    public void execute(DelegateExecution delegateExecution){
        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) delegateExecution.getVariable("enemyWarriors");
        boolean isWin = false;
        String battleStatus;

        if (warriors > enemyWarriors){
            isWin = true;
            battleStatus = "Victory";
            delegateExecution.setVariable("isWin",isWin);
            delegateExecution.setVariable("battleStatus",battleStatus);
            LOG.info("Status battle {}",battleStatus);
        }else {
            battleStatus = "Defeat";
            delegateExecution.setVariable("isWin",isWin);
            delegateExecution.setVariable("battleStatus",battleStatus);
        }
    }
}
