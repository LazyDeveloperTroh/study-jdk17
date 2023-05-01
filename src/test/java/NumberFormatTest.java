import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
    @Test
    public void shortFormat() {
        NumberFormat fmt1 = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        Assertions.assertEquals("1K", fmt1.format(1000));
        Assertions.assertEquals("10K", fmt1.format(10000));
        Assertions.assertEquals("1M", fmt1.format(1000000));

        NumberFormat fmt2 = NumberFormat.getCompactNumberInstance(Locale.KOREA, NumberFormat.Style.SHORT);
        Assertions.assertEquals("1천", fmt2.format(1000));
        Assertions.assertEquals("1만", fmt2.format(10000));
        Assertions.assertEquals("100만", fmt2.format(1000000));
    }

    @Test
    public void longFormat() {
        NumberFormat fmt1 = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        Assertions.assertEquals("1 thousand", fmt1.format(1000));
        Assertions.assertEquals("10 thousand", fmt1.format(10000));
        Assertions.assertEquals("1 million", fmt1.format(1000000));

        NumberFormat fmt2 = NumberFormat.getCompactNumberInstance(Locale.KOREA, NumberFormat.Style.LONG);
        Assertions.assertEquals("1천", fmt2.format(1000));
        Assertions.assertEquals("1만", fmt2.format(10000));
        Assertions.assertEquals("100만", fmt2.format(1000000));
    }
}
