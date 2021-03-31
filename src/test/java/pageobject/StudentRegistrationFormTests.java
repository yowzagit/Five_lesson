package pageobject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationForm = new StudentRegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillFormTest() {
        studentRegistrationForm
                .openPage()
                .fillForm()
                .checkData();
    }
}
