package lab1.q4;

import lab1.q3.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testEqualsCarPerson(){
        Person p1 =new Person("First", "Last", Person.Gender.M, 1234);
        Person p2 =new Person("First", "Last", Person.Gender.M, 1234);
        Person p3 =new Person("First", "Last", Person.Gender.M, 12345);
        Person p4=p1;

        Car c1 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
        Car c2 = new Car("Chevrolet", "Camaro", 2012, 1234, p1);
        Car c3 = new Car("Chevrolet", "Camaro", 2012, 12345, p1);
        Car c4 = c1;

        assertFalse(!p1.equals(p2));
        assertFalse(!p4.equals(p1));
        assertFalse(p1.equals(p3));

        assertFalse(!c1.equals(c2));
        assertFalse(!c4.equals(c1));
        assertFalse(c1.equals(c3));

    }

}