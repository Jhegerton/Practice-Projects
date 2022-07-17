package application;

public class Contact implements ContactInfo{

    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(){
        super();
        name = "";
        phoneNumber = "";
        emailAddress = "";
    }
    public Contact(String name, String phoneNumber, String emailAddress){
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public Contact(Contact contact){
        this.name = contact.name;
        this.phoneNumber = contact.phoneNumber;
        this.emailAddress = contact.emailAddress;
    }
    @Override
    public boolean equals(Contact cont){
        return this.name.equals(cont.name) &&
               this.phoneNumber.equals(cont.phoneNumber) &&
               this.emailAddress.equals(cont.emailAddress);
    }
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
    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.replaceAll("\\D", "");
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String getEmailAddress(){
        return this.emailAddress;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + "\nPhone: " + this.phoneNumber + "\nEmail: " + this.emailAddress;
    }
}
