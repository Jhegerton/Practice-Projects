package application;

public enum Errors {
    ONLY_ONE_ARG;

    public String getError(){
        switch(this){
            case ONLY_ONE_ARG -> {
                return "This program takes only one argument";
            }
            default -> {
                return "No error selected";
            }
        }
    }
}
