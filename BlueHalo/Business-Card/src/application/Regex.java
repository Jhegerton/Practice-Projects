package application;

public enum Regex {

    IS_EMAIL, IS_PHONE, IS_NAME;

    public String getRegex() throws CardException {
        switch(this){
            case IS_EMAIL -> {
                return "^.*[@].*$";
            }
            case IS_PHONE -> {
                return "^[^fF].*[+]?[0-9]*[-]?[(]?[0-9]{3}[)]?[-]?[0-9a-zA-Z]{3}[-]?[0-9a-zA-Z]{4}$";
            }
            case IS_NAME -> {
                return "^(Name)?[:]?.?([A-Z][a-z]*[ ]?){2,}";
            }
            default -> {
                throw new CardException("Regex is not selected");
            }
        }
    }
}
