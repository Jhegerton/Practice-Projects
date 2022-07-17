package application;

public class Contact implements ContactInfo{

    private String name;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Default Constructor
     */
    public Contact(){
        super();
        name = "";
        phoneNumber = "";
        emailAddress = "";
    }

    /**
     * Alternate Constructor
     * @param name
     * @param phoneNumber
     * @param emailAddress
     */
    public Contact(String name, String phoneNumber, String emailAddress){
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Copy Constructor
     * @param contact
     */
    public Contact(Contact contact){
        this.name = contact.name;
        this.phoneNumber = contact.phoneNumber;
        this.emailAddress = contact.emailAddress;
    }

    /**
     * Method for comparing Contact equality
     * @param cont
     * @return boolean
     */
    @Override
    public boolean equals(Contact cont){
        return this.name.equals(cont.name) &&
               this.phoneNumber.equals(cont.phoneNumber) &&
               this.emailAddress.equals(cont.emailAddress);
    }

    /**
     * Method for developing Contact has codes
     * @return int
     */
    @Override
    public int hashCode(){
        int hash = 11;
        if(name != null){
            hash = 41 * hash + name.hashCode();
        }
        if(phoneNumber != null){
            hash = 41 * hash + phoneNumber.hashCode();
        }
        if(emailAddress != null){
            hash = 41 * hash + emailAddress.hashCode();
        }
        return hash;
    }

    /**
     * Sets user name attribute
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets user phoneNumber attribute
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.replaceAll("\\D", "");
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets user emailAddress attribute
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**
     * Returns user name
     * @return String
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Returns user phoneNumber
     * @return String
     */

    @Override
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * Returns user emailAddress
     * @return String
     */

    @Override
    public String getEmailAddress(){
        return this.emailAddress;
    }

    /**
     * ToString method for Contact objects
     * @return String
     */
    @Override
    public String toString() {
        return "Name : " + this.name + "\nPhone: " + this.phoneNumber + "\nEmail: " + this.emailAddress;
    }
}
