package application;

import java.util.regex.*;

import static application.Census.checkNames;

public class CardParser implements BusinessCardParser{

    private final Contact contact;

    public CardParser(){
        super();
        this.contact = new Contact();
    }
    public CardParser(Contact contact){
        super();
        this.contact = new Contact(contact);
    }

    public CardParser(CardParser parser){
        super();
        this.contact = new Contact(parser.contact);
    }

    @Override
    public Contact getContactInfo(String document) throws CardException {
        String[] lines = document.split("&");

        Pattern isEmail  = Pattern.compile(Regex.IS_EMAIL.getRegex());
        Pattern isPhone = Pattern.compile(Regex.IS_PHONE.getRegex());
        Pattern isName = Pattern.compile(Regex.IS_NAME.getRegex());

        for(String line : lines){

            Matcher emailMatcher = isEmail.matcher(line);
            Matcher phoneMatcher = isPhone.matcher(line);
            Matcher nameMatcher = isName.matcher(line);

            if(emailMatcher.find()){
                this.contact.setEmailAddress(line);

            }
            if(phoneMatcher.find()){
                this.contact.setPhoneNumber(line);

            }
            if(nameMatcher.find() && surname(line)){
                this.contact.setName(line);
            }
        }

        return this.contact;
    }
    private boolean surname(String fullName) {
        String[] names = fullName.split(" ");
        return checkNames(names[names.length-1]);
    }
}
