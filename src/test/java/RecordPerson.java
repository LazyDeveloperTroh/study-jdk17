import java.util.Objects;

public record RecordPerson(String name, String address) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    public static RecordPerson unnamed(String address) {
        return new RecordPerson("Unnamed", address);
    }

    public RecordPerson {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }

    public RecordPerson(String name) {
        this(name, "unknown");
    }
}
