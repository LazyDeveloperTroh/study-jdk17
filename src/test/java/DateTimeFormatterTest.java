import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    @Test
    public void patternB() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");

        Assertions.assertEquals("오전", dtf.format(LocalTime.of(8, 0)));
        Assertions.assertEquals("오후", dtf.format(LocalTime.of(13, 0)));
        Assertions.assertEquals("저녁", dtf.format(LocalTime.of(20, 0)));
        Assertions.assertEquals("밤", dtf.format(LocalTime.of(23, 0)));
        Assertions.assertEquals("자정", dtf.format(LocalTime.of(0, 0)));
    }
}
