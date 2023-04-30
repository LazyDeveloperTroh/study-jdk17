import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordTest {
    @Test
    public void record_constructor() {
        RecordPerson person1 = new RecordPerson("jack", "seoul");
        RecordPerson person2 = new RecordPerson("terry", "busan");

        Assertions.assertEquals("jack", person1.name());
        Assertions.assertEquals("seoul", person1.address());

        Assertions.assertEquals("terry", person2.name());
        Assertions.assertEquals("busan", person2.address());
    }

    @Test
    public void record_equals() {
        RecordPerson person1 = new RecordPerson("jack", "seoul");
        RecordPerson person2 = new RecordPerson("jack", "seoul");
        RecordPerson person3 = new RecordPerson("terry", "busan");

        Assertions.assertTrue(person1.equals(person2));
        Assertions.assertFalse(person2.equals(person3));
    }

    @Test
    public void record_hashcode() {
        RecordPerson person1 = new RecordPerson("jack", "seoul");
        RecordPerson person2 = new RecordPerson("jack", "seoul");
        RecordPerson person3 = new RecordPerson("terry", "busan");

        Assertions.assertEquals(person1.hashCode(), person2.hashCode());
        Assertions.assertNotEquals(person2.hashCode(), person3.hashCode());
    }

    @Test
    public void record_static() {
        Assertions.assertEquals("Unknown", RecordPerson.UNKNOWN_ADDRESS);

        RecordPerson unnamedPerson = RecordPerson.unnamed("seoul");
        Assertions.assertEquals("Unnamed", unnamedPerson.name());
        Assertions.assertEquals("seoul", unnamedPerson.address());
    }
}
