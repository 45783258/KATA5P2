package kata5p2.model;


public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    public String getDomain(){
        String [] parts= mail.split("@");
        String sub1= parts[0];
        String sub2= parts[1];
        return sub2;
        
    }
}
