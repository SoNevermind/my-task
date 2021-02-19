package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("Reject")
public class Reject implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        if(delegateExecution.getCurrentActivityId().equals("Event_1h16q9j")){
            delegateExecution.setVariable("Reject", true);
        } else{
            delegateExecution.setVariable("Reject", false);
        }
    }
}
