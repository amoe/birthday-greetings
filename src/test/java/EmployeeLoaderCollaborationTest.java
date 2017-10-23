import net.solasistim.birthdaygreetings.Employee;
import net.solasistim.birthdaygreetings.EmployeeLoader;
import net.solasistim.birthdaygreetings.RecordLoader;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
        employeeLoader.loadEmployees();
        verify(mockLoader).loadRecords();
    }

    // 0, 1, many, lots, oops

    @Test
    public void canLoadZeroEmployees() {
        RecordLoader mockLoader = mock(RecordLoader.class);

        List<List<String>> zeroRows = new ArrayList<>();
        List<Employee> expected = new ArrayList<>();

        when(mockLoader.loadRecords()).thenReturn(zeroRows);

        EmployeeLoader employeeLoader = new EmployeeLoader(mockLoader);

        List<Employee> concreteResult = employeeLoader.loadEmployees();

        assertEquals(expected, concreteResult);
    }

    @Test
    public void canLoadOneEmployee() {
        RecordLoader mockLoader = mock(RecordLoader.class);

        List<List<String>> oneRow = new ArrayList<>();
        oneRow.add(Arrays.asList("Leela", "Turanga", "1975-07-29", "leela@planet-express.com"));
        when(mockLoader.loadRecords()).thenReturn(oneRow);

        EmployeeLoader employeeLoader = new EmployeeLoader(mockLoader);
        List<Employee> concreteResult = employeeLoader.loadEmployees();

        List<Employee> expected = Arrays.asList(
                new Employee("Leela", "Turanga", LocalDate.of(1975, 07, 29), "leela@planet-express.com")
        );

        assertEquals(expected, concreteResult);
    }

    public void canLoadManyEmployees() {

    }

    public void canLoadLargeNumbersOfEmployees() {

    }

    public void handlesErrors() {

    }
}
