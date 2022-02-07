package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//a[contains(@id, \"hs-eu-confirmation-button\")]")
    WebElement acceptCookiesButton;

    @FindBy(xpath="//input[contains(@id, \"question\")]")
    WebElement questionInputField;

    @FindBy(xpath="//textarea[contains(@id, \"answer\")]")
    WebElement answerTextAreaField;

    @FindBy(xpath="//button[contains(@class, \"btn btn-success\")]")
    WebElement createButton;

    @FindBy(xpath="//button[contains(@class, \"btn btn-danger\")]")
    WebElement removeQuestionsButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
    }

    public void getPage(WebDriver driver, String url){
        System.out.println("... Loading page " + url + "...");
        driver.get(url);
    }

    public int getHeaderList() {
        System.out.println("... Searching the page header...");
        List header = driver.findElements(By.xpath("//h1[contains(text(), \"The awesome Q/A tool\")]"));
        return header.size();
    }

    public void typeQuestion(String question) {
        System.out.println("... Typing the question \"" + question + "\"...");
        questionInputField.sendKeys(question);
    }

    public void typeAnswer(String answer) {
        System.out.println("... Typing the answer \"" + answer + "\"...");
        answerTextAreaField.sendKeys(answer);
    }

    public void clickCreateButton() {
        System.out.println("... Clicking \"Create question\" button...");
        createButton.click();
    }

    public int findQuestion(String question) {
        System.out.println("... Searching the question \"" + question + "\"...");
        List questionDiv = driver.findElements(By.xpath("//div[contains(text(), \"" + question + "\") and contains(@class, \"question__question\")]"));
        return questionDiv.size();
    }

    public void clickQuestion(String question) {
        System.out.println("... Clicking the question \"" + question + "\"...");
        driver.findElement(By.xpath("//div[contains(text(), \"" + question + "\") and contains(@class, \"question__question\")]")).click();
    }

    public int findAnswer(String answer) {
        System.out.println("... Searching the answer \"" + answer + "\"...");
        List answerParagraph = driver.findElements(By.xpath("//p[contains(text(), \"" + answer + "\") and contains(@class, \"question__answer\")]"));
        return answerParagraph.size();
    }

    public void clickRemoveQuestions() {
        System.out.println("... Removing questions...");
        removeQuestionsButton.click();
    }

    public int findNoQuestionsYetDiv() {
        System.out.println("... Searching the \"No questions yet :-(\" message...");
        List noQuestionsYetDiv = driver.findElements(By.xpath("//div[contains(text(), \"No questions yet :-(\") and contains(@class, \"alert alert-danger\")]"));
        return noQuestionsYetDiv.size();
    }
}