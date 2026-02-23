package probleme5;

public class Contact {
    protected String emailAddress;
    protected String faxNumber;
    protected String name;
    protected String primaryContactMethod;

    public Contact(String name, String emailAddress, String faxNumber, String primaryContactMethod) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.faxNumber = faxNumber;
        this.primaryContactMethod = primaryContactMethod;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryContactMethod() {
        return primaryContactMethod;
    }

    public void setPrimaryContactMethod(String primaryContactMethod) {
        this.primaryContactMethod = primaryContactMethod;
    }

    public String getEmailDomain() {
        if (emailAddress != null && emailAddress.contains("@")) {
            return emailAddress.substring(emailAddress.indexOf("@") + 1);
        }
        return "";
    }

    public String getContactSummary() {
        return "Name: " + name + ", Email: " + emailAddress + ", Fax: " + faxNumber + ", Primary Method: "
                + primaryContactMethod;
    }
}
