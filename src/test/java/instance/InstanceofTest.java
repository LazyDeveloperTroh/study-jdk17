package instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstanceofTest {
    @Test
    public void oldStyleInstanceof() {
        Object o = new Person("troh", 33);
        if(o instanceof Person) {
            Person p = (Person) o;
            Assertions.assertEquals("troh", p.getName());
            Assertions.assertEquals(33, p.getAge());
        }
    }

    @Test
    public void newStyleInstanceof() {
        Object o = new Person("troh", 33);
        if(o instanceof Person p) {
            Assertions.assertEquals("troh", p.getName());
            Assertions.assertEquals(33, p.getAge());
        }
    }
}
