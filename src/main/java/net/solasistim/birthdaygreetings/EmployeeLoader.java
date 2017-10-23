package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class EmployeeLoader {
    private RecordLoader rl;

    public List<Employee> loadEmployees() {
        List<List<String>> foo = new ArrayList<>();

        foo.add(new ArrayList<String>());

        List<Employee> result = new ArrayList<>();

        return result;
    }
}
