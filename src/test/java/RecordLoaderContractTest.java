import net.solasistim.birthdaygreetings.RecordLoader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class RecordLoaderContractTest {
    // contract tests should match collaboration tests
    // we stub the meth to return this list<list<string>>
//Arrays.asList("Leela", "Turanga", "1975-07-29", "leela@planet-express.com")
    @Test
    public void returnsRecords() {

        List<List<String>> expected = Arrays.asList(Arrays.asList("Leela", "Turanga", "1975-07-29", "leela@planet-express.com"));
        RecordLoader rl = getRecordLoader(expected);

        assertEquals(expected, rl.loadRecords());
    }

    // getRecordLoader will construct a situation necessary to retrieve ambientData
    public abstract RecordLoader getRecordLoader(List<List<String>> ambientData);
}
