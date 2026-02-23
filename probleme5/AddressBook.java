package probleme5;

public class AddressBook {
    protected String name;
    private Contact[] contacts;
    private int contactCount;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new Contact[10];
        this.contactCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // From UML
    public Contact getContact() {
        if (contactCount > 0) {
            return contacts[0];
        }
        return null;
    }

    // From UML and spec
    public Contact[] getContacts() {
        Contact[] currentContacts = new Contact[contactCount];
        for (int i = 0; i < contactCount; i++) {
            currentContacts[i] = contacts[i];
        }
        return currentContacts;
    }

    // From UML
    public void insertContact(Contact contact) {
        if (contact != null) {
            if (contactCount == contacts.length) {
                Contact[] temp = new Contact[contacts.length * 2];
                for (int i = 0; i < contacts.length; i++) {
                    temp[i] = contacts[i];
                }
                contacts = temp;
            }
            contacts[contactCount] = contact;
            contactCount++;
        }
    }

    // From spec
    public void addContact(Contact c) {
        insertContact(c);
    }

    // From spec
    public String getSummary() {
        String summary = "Address Book: " + name + "\n";
        summary += "Total Contacts: " + contactCount + "\n";
        return summary;
    }

    // From spec
    public Contact findByEmail(String email) {
        for (int i = 0; i < contactCount; i++) {
            Contact c = contacts[i];
            if (c.getEmailAddress() != null && c.getEmailAddress().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }
}
