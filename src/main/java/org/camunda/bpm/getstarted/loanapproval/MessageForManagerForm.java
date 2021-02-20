package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;

public class MessageForManagerForm implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        /*String message = (String) delegateExecution.getVariable("message");

        delegateExecution.getProcessEngineServices().getRuntimeService().createMessageCorrelation("Wait").setVariable("message", message).correlate();*/

        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();

        MessageCorrelationResultWithVariables result = (MessageCorrelationResultWithVariables) runtimeService.createMessageCorrelation("Wait").correlateStartMessage();

    }
}
