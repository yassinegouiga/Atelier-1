package probleme5;

public class Account {
    protected String emailAddress;
    protected String name;
    private AddressBook[] addressBooks;
    private int addressBookCount;

    public Account(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.addressBooks = new AddressBook[10];
        this.addressBookCount = 0;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // From spec
    public String getFullName() {
        return name != null ? name.trim() : "";
    }

    // From spec
    public AddressBook[] getAddressBooks() {
        AddressBook[] currentBooks = new AddressBook[addressBookCount];
        for (int i = 0; i < addressBookCount; i++) {
            currentBooks[i] = addressBooks[i];
        }
        return currentBooks;
    }

    // From spec
    public void addAddressBook(AddressBook book) {
        if (book != null) {
            if (addressBookCount == addressBooks.length) {
                AddressBook[] temp = new AddressBook[addressBooks.length * 2];
                for (int i = 0; i < addressBooks.length; i++) {
                    temp[i] = addressBooks[i];
                }
                addressBooks = temp;
            }
            addressBooks[addressBookCount] = book;
            addressBookCount++;
        }
    }

    // From spec
    public void printAllContactDomains() {
        String[] domains = new String[10];
        int domainCount = 0;

        for (int i = 0; i < addressBookCount; i++) {
            AddressBook book = addressBooks[i];
            Contact[] contacts = book.getContacts();

            for (int j = 0; j < contacts.length; j++) {
                Contact c = contacts[j];
                String domain = c.getEmailDomain();

                if (domain != null && !domain.isEmpty()) {
                    // Check if domain is already in the array (HashSet equivalent)
                    boolean exists = false;
                    for (int k = 0; k < domainCount; k++) {
                        if (domains[k].equals(domain)) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        // Expand domain array if needed
                        if (domainCount == domains.length) {
                            String[] tempDomains = new String[domains.length * 2];
                            for (int k = 0; k < domains.length; k++) {
                                tempDomains[k] = domains[k];
                            }
                            domains = tempDomains;
                        }
                        domains[domainCount] = domain;
                        domainCount++;
                    }
                }
            }
        }

        System.out.println("Contact Domains for Account " + getFullName() + ":");
        for (int i = 0; i < domainCount; i++) {
            System.out.println("- " + domains[i]);
        }
    }
}
