package online.fortis;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FirstTestWithProperties extends TestBase{
    @Test
    public void fillPracticeFormTests() {
       step("Открываем страницу с формами", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        //fill form
        step("Вводим имя", () -> {
            $("#firstName").setValue("FirstName");
        });
        step("Вводим фамилию", () -> {
            $("#lastName").setValue("LastName");
        });
        step("Вводим email", () -> {
            $("#userEmail").setValue("test@test.ru");
        });
        step("Выбираем пол", () -> {
            $("[for='gender-radio-3']").click();
        });
        step("Вводим телефон", () -> {
            $("#userNumber").setValue("9991234567");
        });
        step("выбираем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__year-select").selectOption("1986");
            $(".react-datepicker__day--012").click();
        });
        step("Выбираеи предметы", () -> {
            $("#subjectsInput").setValue("English").pressEnter();
            $("#subjectsInput").setValue("Computer Science").pressEnter();
        });
        step("Выбираем хобби", () -> {
            $("[for=hobbies-checkbox-1]").click();
            $("[for=hobbies-checkbox-3]").click();
        });
        step("Загружаем файл", () -> {
            $("#uploadPicture").uploadFromClasspath("Glazov.txt");
        });
        step("Вводим адрес", () -> {
            $("#currentAddress").setValue("Any Address");
        });
        step("Выбираем штат и город", () -> {
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Karnal").pressEnter();
        });
        step("Нажимаем submit", () -> {
            $("#submit").click();
        });

        // check result
        step("Проверка результата", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
            $(".table-responsive").shouldHave(text("FirstName"), text("LastName"), text("test@test.ru"),
                    text("Other"), text("9991234567"), text("12 August,1986"), text("English, Computer Science"),
                    text("Sports, Music"), text("Glazov.txt"), text("Any Address"), text("Haryana Karnal"));
        });
    }
}
