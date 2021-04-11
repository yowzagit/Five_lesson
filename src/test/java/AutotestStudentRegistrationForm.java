import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutotestStudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void middleTest() {

        //присвоение имён
        String name = "Gregory",
                lastName = "Perelman",
                email = "who_know_i_not@gmail.com",
                sex = "Male",
                number = "8005553535",
                birthMonth = "June",
                birthYear = "1966",
                subjects = "Maths",
                hobbies = "Reading",
                address = "Budapeshtskaya street 98k3 kv.131 and kv.350, Saint-Petersburg, Russia",
                state = "NCR",
                city = "Delhi";

        //начинается магия, заходим на сайт
        open("https://demoqa.com/automation-practice-form");

        //вписываем значения
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(sex)).click();
        $("#userNumber").setValue(number);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day.react-datepicker__day--013").click();

        $("#subjectsInput").val("ma");
        $(byText(subjects)).click();

        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#uploadPicture").uploadFromClasspath("per.png");
        $("[for='hobbies-checkbox-2']").click();

        $("#submit").click();

        //проверка
        $(".table").shouldHave(text(name),
                text(lastName),
                text(email),
                text(sex),
                text(number),
                text(birthMonth),
                text(birthYear),
                text(subjects),
                text(hobbies),
                text(address),
                text("per.png"),
                text(state),
                text(city));

        $("#closeLargeModal").click();

    }
}
