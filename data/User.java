package diary.data;

public abstract class User {
private String firstName;
private String lastname;
private String birthday;
private String patron;
private char gender;

    public User(String firstName, String lastname, String birthday, String patron, char gender) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthday = birthday;
        this.patron = patron;
        this.gender = gender;
    }

    public User(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    protected User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", patron='" + patron + '\'' +
                ", gender=" + gender +
                '}';
    }
}
