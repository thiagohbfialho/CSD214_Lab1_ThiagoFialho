package lab1.q3;

import java.util.Objects;

/**
 * @author thiagofialho
 * Date: 09-28-23
 * Description: This is a class for Person
 **/

public class Person {

    enum gend {
        M,
        F
    }


    //Attributes of a person
    //Defined as instance variables
    private String firstname;
    private String lastname;
    private gend gender;
    private int SIN;

    //Defined as class variable
    private static int COUNT;

    public Person(String firstname, String lastname, Person.gend gender, int SIN) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.SIN = SIN;
        COUNT++;
    }

    public Person(String firstname, String lastname, int SIN) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.SIN = SIN;
        COUNT++;
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        COUNT++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", SIN=" + SIN +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public gend getGender() {
        return gender;
    }

    public void setGender(gend gender) {
        this.gender = gender;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public static void setCOUNT(int COUNT) {
        Person.COUNT = COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getSIN() == person.getSIN() && Objects.equals(getFirstname(), person.getFirstname()) && Objects.equals(getLastname(), person.getLastname()) && getGender() == person.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getGender(), getSIN());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        COUNT--;
    }

    public static void main(String[] args) {
        Person p = new Person("Thiago","Fialho", Person.gend.F, 123);
    }

}
