import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void oldStyleToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.collect(Collectors.toList());
    }

    @Test
    public void newStyleToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
    }
}
