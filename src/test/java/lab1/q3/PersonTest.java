package lab1.q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void decrementPerson() throws Throwable {
        Person p = new Person("Thiago","Fialho");
        Person p2 = new Person("Mac","Tai", Person.Gender.M, 123);
        Person p3 = new Person("Anne","Kate", Person.Gender.F, 234);
        assertEquals(3,Person.getCOUNT());
        p.finalize();
        p2.finalize();
        assertEquals(1,Person.getCOUNT());
        p3.finalize();
        assertEquals(0, Person.getCOUNT());
    }

}