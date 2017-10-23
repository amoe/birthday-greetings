package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Employee {
    @Getter private String lastName;
    @Getter private String firstName;
    @Getter private LocalDate dateOfBirth;
    @Getter private String email;
}
