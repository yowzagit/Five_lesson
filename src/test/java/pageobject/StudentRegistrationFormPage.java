package pageobject;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("in-ID"), new RandomService());
    //присвоение имён
    String siteName = "https://demoqa.com/automation-practice-form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = fakeValuesService.bothify("????##@gmail.com"),
            sex = "Male",
            number = faker.number().digits(10),
            birthMonth = "June",
            birthYear = ("19" + faker.number().digits(2)),
            subjects = "Maths",
            hobbies = "Reading",
            address = faker.address().streetAddress(),
            state = "NCR",
            city = "Delhi";

    public StudentRegistrationFormPage openPage() {
        open(siteName);

        return this;
    }

    public StudentRegistrationFormPage fillForm() {
    //вписываем значения
        $("#firstName").setValue(firstName);
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

        return this;
    }

    public void checkData() {
    //проверка
        $(".table").shouldHave(text(firstName),
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
