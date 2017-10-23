import net.solasistim.birthdaygreetings.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BirthdayServiceCollaborationTest {
    @Test
    public void asksRightQuestionToEmployeeRepository() {
        // Mock employee repository and verify.
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmailService mockEmailService = mock(EmailService.class);


        when(mockRepository.loadEmployees()).thenReturn(
                Arrays.asList(new Employee("Leela", "Turanga", LocalDate.of(1975, 01, 01), "leela@planet-express.com")
                )
        );

        BirthdayService sut = new BirthdayService(mockRepository, mockEmailService);
        sut.sendGreetings(LocalDate.of(2015, 01, 01));
        verify(mockRepository).loadEmployees();
        verify(mockEmailService).sendEmail("leela@planet-express.com", "Happy birthday!", "Happy birthday, dear Turanga!");
    }
}
