package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
public class FlatFileLoader implements RecordLoader {
    private Path source;

    public List<List<String>> loadRecords() {
        return null;
    }
}
