package net.solasistim.birthdaygreetings;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    @Getter private String lastName;
    @Getter private String firstName;
    @Getter private LocalDate dateOfBirth;
    @Getter private String email;
}
