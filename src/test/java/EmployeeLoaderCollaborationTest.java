import net.solasistim.birthdaygreetings.Employee;
import net.solasistim.birthdaygreetings.EmployeeLoader;
import net.solasistim.birthdaygreetings.RecordLoader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeLoaderCollaborationTest {
    @Test
    public void requestsDataFromRecordLoader() {
        RecordLoader mockLoader = mock(RecordLoader.class);
        EmployeeLoader employeeLoader = new EmployeeLoader(mockLoader);
        verify(mockLoader).loadRecords();
    }

    // 0, 1, many, lots, oops

    @Test
    public void canLoadZeroEmployees() {
        RecordLoader mockLoader = mock(RecordLoader.class);

        List<List<String>> zeroResults = new ArrayList<>();

        when(mockLoader.loadRecords()).thenReturn(zeroResults);

        EmployeeLoader employeeLoader = new EmployeeLoader(mockLoader);

        List<Employee> concreteResult = employeeLoader.loadEmployees();

        assertEquals(zeroResults, concreteResult);
    }

    public void canLoadOneEmployee() {

    }

    public void canLoadManyEmployees() {

    }

    public void canLoadLargeNumbersOfEmployees() {

    }

    public void handlesErrors() {

    }
}
