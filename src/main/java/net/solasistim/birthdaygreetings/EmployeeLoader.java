package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class EmployeeLoader {
    private RecordLoader rl;

    public List<Employee> loadEmployees() {
        List<List<String>> data = rl.loadRecords();
        List<Employee> result = new ArrayList<>();

        for (List<String> datum : data) {
            Employee thisEmployee = convertEmployee(datum);
            result.add(thisEmployee);
        }

        return result;
    }

    private Employee convertEmployee(List<String> datum) {
        String lastName = datum.get(0);
        String firstName = datum.get(1);
        LocalDate dateOfBirth = LocalDate.parse(datum.get(2));
        String email = datum.get(3);

        Employee result = new Employee(lastName, firstName, dateOfBirth, email);

        return result;
    }
}
