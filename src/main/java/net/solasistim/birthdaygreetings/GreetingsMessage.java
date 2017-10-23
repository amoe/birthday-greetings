package net.solasistim.birthdaygreetings;

import lombok.Getter;

public class GreetingsMessage {
    @Getter private String subject;
    @Getter private String body;

    private GreetingsMessage(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public static GreetingsMessage of(Employee e) {
        String subject = "Happy birthday!";
        String body = String.format("Happy birthday, dear %s!", e.getFirstName());

        return new GreetingsMessage(subject, body);
    }
}
