package birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa;

import org.openqa.selenium.By;

public interface Locators {

    String url = "https://demoqa.com/automation-practice-form";

    By lfirstName = By.id("firstName");
    By lLastName = By.id("lastName");
    By lUserEmail = By.cssSelector("#userEmail");

    //By lGender = By.xpath("//input[contains(@id,'-radio-')]//parent::div[contains(., '')]");

    By lPhoneNumber = By.cssSelector("#userNumber");

    By lDateOfBirth = By.id("dateOfBirthInput");

    By lSubjects = By.id("subjectsInput");

    By lAddress = By.id("currentAddress");
    By lFileUpload = By.cssSelector("input[id=uploadPicture]");
    By lState = By.cssSelector("input[id=react-select-3-input]");
    By lCity = By.cssSelector("input[id=react-select-4-input]");
    By lSubmit = By.cssSelector("button[id=submit]");
    By lModalDialoge = By.cssSelector("#closeLargeModal");



    static By clickGender(String gender) {

        return By.xpath("//input[contains(@id,'-radio-')]//parent::div[contains(., '" + gender + "')]");

    }


}
