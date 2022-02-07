package org.danielCastro;

import PageFactory.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;

public class StepDefinitions {

    public static WebDriver driver = new ChromeDriver();

    static HomePage objHome;

    @Given("^the user is at the website \"([^\"]*)\"$")
    public void theUserIsAtTheWebsite(String arg0){
        objHome = new HomePage(driver);
        objHome.getPage(driver, arg0);
        boolean headerFound = false;
        if (objHome.getHeaderList() > 0) {
            System.out.println("=== Page header found!");
            headerFound = true;
        }
        Assert.assertTrue(headerFound);
    }

    @When("the user creates the question {string} with the answer {string}")
    public void createsQuestion(String arg0, String arg1) {
        objHome.typeQuestion(arg0);
        objHome.typeAnswer(arg1);
        objHome.clickCreateButton();
    }

    @Then("the user should be able to see the question {string} in the page")
    public void checkQuestion(String arg0) throws InterruptedException {
        boolean questionFound = false;
        if (objHome.findQuestion(arg0) > 0) {
            System.out.println("=== Question \"" + arg0 + "\" found!");
            questionFound = true;
        }
        Assert.assertTrue(questionFound);
    }

    @And("the user should be able to expand and see the answer {string} for the question {string}")
    public void checkAnswer(String arg0, String arg1){
        objHome.clickQuestion(arg1);
        boolean answerFound = false;
        if (objHome.findAnswer(arg0) > 0) {
            System.out.println("=== Answer \"" + arg0 + "\" found!");
            answerFound = true;
        }
        Assert.assertTrue(answerFound);
    }

    @When("the user removes the questions")
    public void removesQuestions() throws InterruptedException {
        objHome.clickRemoveQuestions();
    }

    @Then("no questions are listed")
    public void noQuestionsYet() throws InterruptedException {
        boolean noQuestionsYetFound = false;
        if (objHome.findNoQuestionsYetDiv() > 0) {
            System.out.println("=== \"No questions yet :-(\" message found!");
            noQuestionsYetFound = true;
        }
        Assert.assertTrue(noQuestionsYetFound);
    }
}