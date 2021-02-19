package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.logging.Logger;

@Component("Reject")
@Named("logger")
public class LoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info(
                "\n\n ... LoggerDelegate invoked by "
                + "ProcessDefinitionId=" + delegateExecution.getProcessDefinitionId()
                + ", ActivityId= " + delegateExecution.getCurrentActivityId()
                + ", ActivityName= " + delegateExecution.getCurrentActivityId()
                + ", ProcessInstanceId=" + delegateExecution.getProcessInstanceId()
                + ", BusinessKey=" + delegateExecution.getBusinessKey()
                + ", BusinessKey=" + delegateExecution.getBusinessKey()
                + ", executionId=" + delegateExecution.getId()
                + "\n\n");
        if( delegateExecution.getCurrentActivityId().equals("Activity_0buqxfj")){
            delegateExecution.setVariable("Reject" , true);
        }
        if(delegateExecution.getCurrentActivityId().equals("Activity_0kjrn82")){
            delegateExecution.setVariable("Reject", false);
        }
    }
}
