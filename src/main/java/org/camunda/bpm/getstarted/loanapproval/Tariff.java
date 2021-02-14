package org.camunda.bpm.getstarted.loanapproval;

public enum Tariff {
    STANDARD("STANDARD"), FULL("FULL"), NOT_FULL("NOT_FULL");

    public String value;

    private Tariff(String value){
        this.value = value;
    }

    Tariff() { }

    public static Tariff fromString(String value){
        System.out.println(value);

        if(value != null){
            for(Tariff tariff : Tariff.values()){
                System.out.println(tariff);

                if(value.equalsIgnoreCase(tariff.value)){
                    return tariff;
                }
            }
        }

        throw new IllegalArgumentException("No such value");
    }
}
