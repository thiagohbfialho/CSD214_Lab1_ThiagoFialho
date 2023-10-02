package lab1.q3;

import java.sql.SQLOutput;
import java.util.Objects;

/**
 * @author thiagofialho
 * Date: 09-28-23
 * Description: This is a class for Person
 **/

public class Person {

    //Variable to choose gender
    public static enum Gender{
        M,
        F
    };

    //Attributes of a person
    //Defined as instance variables
    private String firstname;
    private String lastname;
    private Gender gender;
    private int SIN;

    //Defined as class variable
    private static int COUNT;

    /**
     * Constuctor of Person class with those parameters below
     * @param firstname
     * @param lastname
     * @param gender
     * @param SIN
     */
    public Person(String firstname, String lastname, Person.Gender gender, int SIN) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.SIN = SIN;
        COUNT++;
    }

    /**
     * Constuctor of Person class with those parameters below
     * @param firstname
     * @param lastname
     * @param SIN
     */
    public Person(String firstname, String lastname, int SIN) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.SIN = SIN;
        COUNT++;
    }

    /**
     * Constuctor of Person class with those parameters below
     * @param firstname
     * @param lastname
     */
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        COUNT++;
    }

    /**
     * Method that put all instance variable in a String
     * @return a string with all instance variable
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", SIN=" + SIN +
                '}';
    }

    /**
     * Method to return First Name
     * @return First name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Method toedit the First Name
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Method to return Last Name
     * @return Last Name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Method to edit the Last Name
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Method to return Gender
     * @return Gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method to edit gender
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Method to return SIN
     * @return SIN
     */
    public int getSIN() {
        return SIN;
    }

    /**
     * Method to edit SIN
     * @param SIN
     */
    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    /**
     * Method to return how many Persons were created
     * @return COUNT
     */
    public static int getCOUNT() {
        return COUNT;
    }

    /**
     * Method to edit how many Person were created
     * @param COUNT
     */
    public static void setCOUNT(int COUNT) {
        Person.COUNT = COUNT;
    }

    /**
     * Method to know if two persons are the same
     * @param o
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getSIN() == person.getSIN() && Objects.equals(getFirstname(), person.getFirstname()) && Objects.equals(getLastname(), person.getLastname()) && getGender() == person.getGender();
    }

    /**
     *
     * @return
     */
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
//        Person p1 =new Person("First", "Last", Person.Gender.M, 1234);
//        Person p2 =new Person("First", "Last", Person.Gender.M, 1234);
//
//        if(p1==p2){
//            System.out.println("equal");
//        }else {
//            System.out.println("not equal");
//        }
    }

}
