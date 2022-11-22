package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


// только success test
public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        // Configuration.browserSize = "1920x1080"; у меня открывалось окно посередине двух экранов мне это надоело
        // поэтому я просто скроллил до нужного элемента .scrollTo()
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Solo");
        $("#userEmail").setValue("solo@awg.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__day.react-datepicker__day--006").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        File testFile = new File("src/test/resources/testFile.jpg");
        $("#uploadPicture").uploadFile(testFile);




















/*
        $("#submit").scrollTo().click();

        $("#output").shouldHave(text("Alex"), text("alex@company.com"),
                text("Some address 1"), text("Other address 2")); */
    }
}
