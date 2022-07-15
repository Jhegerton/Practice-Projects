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
