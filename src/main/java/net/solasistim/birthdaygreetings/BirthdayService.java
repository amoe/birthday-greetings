package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class BirthdayService {
    private EmployeeRepository employeeRepository;
    private EmailService emailService;

    public void sendGreetings(LocalDate currentDay) {
        List<Employee> employees = employeeRepository.loadEmployees();


        for (Employee e : employees) {
            if (isBirthday(e, currentDay)) {
                GreetingsMessage gm = GreetingsMessage.of(e);
                emailService.sendEmail(e.getEmail(), gm.getSubject(), gm.getBody());
            }
        }
    }

    private boolean isBirthday(Employee e, LocalDate currentDay) {
        return currentDay.getDayOfYear() == e.getDateOfBirth().getDayOfYear();
    }
}
