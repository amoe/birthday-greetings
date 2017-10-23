import net.solasistim.birthdaygreetings.FlatFileLoader;
import net.solasistim.birthdaygreetings.RecordLoader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// NB: this is an integration test (not an integrated test!), this is "ring" code in Rainsberger's terminology.
// Example of the contract test pattern for the ring: given some example data that my class is expected to return,
// construct a situation by which it will return this.
// It's like an inversion of the traditional integration test pattern that results in the same outcome.
public class FlatFileLoaderTest extends RecordLoaderContractTest {
    @Override
    public RecordLoader getRecordLoader(List<List<String>> ambientData) {
        try {
            File tempFile = File.createTempFile("prefix-", "-suffix");
            tempFile.deleteOnExit();

            try (PrintWriter out = new PrintWriter(tempFile)) {
                for (List<String> row : ambientData) {
                    out.println(String.join(", ", row));
                }
            }

            return new FlatFileLoader(tempFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
