package net.solasistim.birthdaygreetings;

import java.nio.file.Paths;
import java.time.LocalDate;

public class EntryPoint {
    public static void main(String[] args) {
        RecordLoader recordLoader = new FlatFileLoader(Paths.get("employee_data.txt"));
        EmployeeRepository employeeRepository = new EmployeeLoader(recordLoader);
        EmailService emailService = new EmailServiceImpl();
        BirthdayService birthdayService = new BirthdayService(employeeRepository, emailService);
        birthdayService.sendGreetings(LocalDate.now());
    }
}
