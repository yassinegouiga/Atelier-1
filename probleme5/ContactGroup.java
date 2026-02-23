package probleme5;

public class ContactGroup {
    protected String name;
    private Contact[] contacts;
    private int contactCount;

    public ContactGroup(String name) {
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

    public void addContact(Contact c) {
        if (c != null) {
            if (contactCount == contacts.length) {
                Contact[] temp = new Contact[contacts.length * 2];
                for (int i = 0; i < contacts.length; i++) {
                    temp[i] = contacts[i];
                }
                contacts = temp;
            }
            contacts[contactCount] = c;
            contactCount++;
        }
    }

    public String buildGroupReport() {
        String report = "Group Report for: " + name + "\n";
        report += "--------------------------------------------------\n";
        for (int i = 0; i < contactCount; i++) {
            report += contacts[i].getContactSummary() + "\n";
        }
        return report;
    }
}
