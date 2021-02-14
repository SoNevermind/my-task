package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.Map;

public class CalculateInterestService implements JavaDelegate {
    public void execute(DelegateExecution delegate) throws Exception{
        System.out.println("Spring Bean invoked");

        Fields fields = new Fields();
        ManagerFields managerFields = new ManagerFields();

/*       delegate.setVariable("Surname", Surname);
        delegate.setVariable("Name", Name);
        delegate.setVariable("Middle", Middle);
        delegate.setVariable("Address", Address);
        delegate.setVariable("Age", Age);
        delegate.setVariable("Tariff", selected_tariff);*/

        Map<String, Object> variables = delegate.getVariables();

        fields.setSurname((String) variables.get("Surname"));
        fields.setName((String) variables.get("Name"));
        fields.setMiddle((String) variables.get("Middle"));
        fields.setAddress((String) variables.get("Address"));
        fields.setAge((Long) variables.get("Age"));
        //fields.setSelected_tariff((Tariff) variables.get("Selected_staff"));

        managerFields.setClient((String) variables.get("Client"));
        managerFields.setClient_Age((Long) variables.get("Client_Age"));
        managerFields.setSelected_Tariff_Of_Client((String) variables.get("Selected_Tariff_Of_Client"));
        managerFields.setNumber_Of_Application((Long) variables.get("Number_Of_Application"));

        System.out.println(variables.get("Selected_tariff"));

        System.out.println(fields.toString());
    }

}
