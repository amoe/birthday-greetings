package net.solasistim.birthdaygreetings;

import java.util.List;

public interface RecordLoader {
    // The method can't take the param as an argument, because it'll differ based on the particular concrete
    // implementation.
    public List<List<String>> loadRecords();
}
