package lab1.q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void decrementPerson() throws Throwable {
        Person p = new Person("Thiago","Fialho");
        Person p2 = new Person("Thiago","Fialho");
        Person p3 = new Person("Thiago","Fialho");
        assertEquals(3,Person.getCOUNT());
        p.finalize();
        p2.finalize();
        assertEquals(1,Person.getCOUNT());
    }

}