import net.solasistim.birthdaygreetings.Employee;
import net.solasistim.birthdaygreetings.GreetingsMessage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsMessageTest {
    @Test
    public void formattingWorks() {
        Employee myTestEmployee = new Employee("Leela", "Turanga", LocalDate.of(1975, 01, 01), "leela@planet-express.com");
        GreetingsMessage gm = GreetingsMessage.of(myTestEmployee);
        assertEquals("Happy birthday!", gm.getSubject());
        assertEquals("Happy birthday, dear Turanga!", gm.getBody());
    }
}
