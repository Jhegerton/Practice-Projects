package application;

public class CardParser implements BusinessCardParser{

    private Contact contact;

    public CardParser(){
        super();
        this.contact = new Contact();
    }

    @Override
    public ContactInfo getContactInfo(String document) {
        System.out.print(document);
        return null;
    }
}
