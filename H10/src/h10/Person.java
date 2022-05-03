// Person class
package h10;

// template class
public class Person implements Comparable<Person> {

    // attributes
    private String firstname;
    private String lastname;
    private String bday;
    private String phone;

    // default constructor
    public Person() {
        firstname = "";
        lastname = "";
        bday = "";
        phone = "";
    }

    // parameterized constructor
    public Person(String w, String x, String y, String z) {
        firstname = w;
        lastname = x;
        bday = y;
        phone = z;
    }

    // gets & sets
    
    /**
     * @return the name
     */
    /**
     * @return the bday
     */
    public String getBday() {
        return bday;
    }

    /**
     * @param bday the bday to set
     */
    public void setBday(String bday) {
        this.bday = bday;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the first name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the last name to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // compare by last name, used for sorting
    @Override
    public int compareTo(Person x) {
        if (this.lastname.compareToIgnoreCase(x.lastname) > 0) {
            return 1;
        }
        if (this.lastname.compareToIgnoreCase(x.lastname) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    // print all attributes for person
    public void writeOutput() {

        System.out.println(firstname + " " + lastname);
        System.out.println(bday);
        System.out.println(phone);
    }

    // print person
    @Override
    public String toString() {
        return firstname + " " + lastname + "\n" + bday + "\n" + phone + "\n";
    }

}
