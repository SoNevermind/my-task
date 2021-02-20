package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("ageStatus")
public class Gateway implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {

        if((Long) delegateExecution.getVariable("Age") >= 18){
            delegateExecution.setVariable("ageStatus", true);
        }else{
            delegateExecution.setVariable("ageStatus", false);
        }
    }
}
