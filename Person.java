import java.io.*;
public class Person implements Serializable {
    //Person info variables
    private String Name;
    private String Surname;
    private String DateOfBirth;
    private int MobileNo;
//Constructor for person information
    public Person(String name, String surname, String dateOfBirth, int mobileNo) {
        Name = name;
        Surname = surname;
        DateOfBirth = dateOfBirth;
        MobileNo = mobileNo;
    }
    //Getters and setters for person info
    private static final long serialVersionUID=1L;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }
}



