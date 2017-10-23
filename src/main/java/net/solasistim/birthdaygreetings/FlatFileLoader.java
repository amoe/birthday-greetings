package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class FlatFileLoader implements RecordLoader {
    private Path source;

    public List<List<String>> loadRecords() {
        List<List<String>> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(source.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] thisLine = line.split(", ");
                result.add(Arrays.asList(thisLine));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
