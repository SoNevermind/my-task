package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("Reject")
public class RejectChoice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if(delegateExecution.getCurrentActivityId().equals("Activity_0kwqtnk")){
            delegateExecution.setVariable("Reject", true);
        } else{
            delegateExecution.setVariable("Reject", false);
        }
    }
}
