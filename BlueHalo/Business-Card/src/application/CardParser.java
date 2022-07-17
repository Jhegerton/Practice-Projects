package application;

import java.util.regex.*;

import static application.Census.checkNames;

public class CardParser implements BusinessCardParser{

    private final Contact contact;

    /**
     * Default Constructor
     */
    public CardParser(){
        super();
        this.contact = new Contact();
    }

    /**
     * Alternate Contructor
     * @param contact
     */
    public CardParser(Contact contact){
        super();
        this.contact = new Contact(contact);
    }

    /**
     * Copy Constructor
     * @param parser
     */
    public CardParser(CardParser parser){
        super();
        this.contact = new Contact(parser.contact);
    }

    /**
     * This is the primary method for extracting the information from
     * the data. Data is verified line by line using regular expressions.
     * Regular expressions are defined in the Regex Enumeration class.
     * See {@link Regex#getRegex() GetRegex}.
     *
     * The name is verified separately. See {@link #surname(String) Surname}
     * @param document
     * @return Contact
     * @throws CardException
     */
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

    /**
     * Name is verified as well by checking the possible last name.
     * See {@link Census#checkNames(String) CheckNames}
     * @param fullName
     * @return boolean
     */
    private boolean surname(String fullName) {
        String[] names = fullName.split(" ");
        return checkNames(names[names.length-1]);
    }
}
