package net.solasistim.birthdaygreetings;

public interface EmailService {
    public void sendEmail(String emailAddress, String subject, String body);
}
