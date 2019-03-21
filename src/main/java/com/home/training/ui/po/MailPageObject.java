package com.home.training.ui.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MailPageObject extends AbstractPage {

    private static final String BASE_URL = "https://mail.yahoo.com";

    @FindBy(xpath = "//input[@id = 'ybarAccountMenu']/..")
    @CacheLookup
    private WebElement accountMenu;

    @FindBy(xpath = "//*[@id='ybarAccountMenuBody']/a[3]")
    @CacheLookup
    private WebElement accountMenuSignOut;

    @FindBy(xpath = "//a[@data-test-id='compose-button']")
    @CacheLookup
    private WebElement composeButton;

    @FindBy(xpath = "//button[@data-test-id='toolbar-archive-restore']")
    private WebElement restoreButton;

    @FindBy(xpath = "//*[@id='message-to-field']")
    private WebElement editorToField;

    @FindBy(xpath = "//input[@data-test-id='compose-subject']")
    private WebElement editorSubjectField;

    @FindBy(xpath = "//*[@id='editor-container']/div")
    private WebElement editorBodyField;

    @FindBy(xpath = "//span[@data-test-folder-name='Inbox']")
    private WebElement inboxFolder;

    @FindBy(xpath = "//a[@data-test-smartview-type='UNREAD']")
    private WebElement unreadFolder;

    @FindBy(xpath = "//a[@data-test-smartview-type='STARRED']")
    private WebElement starredFolder;

    @FindBy(xpath = "//*[@data-test-folder-name='Draft']")
    private WebElement draftFolder;

    @FindBy(xpath = "//span[@data-test-folder-name='Sent']")
    private WebElement sentFolder;

    @FindBy(xpath = "//div[@data-test-folder-container='Archive']")
    private WebElement archiveFolder;

    @FindBy(xpath = "//span[@data-test-folder-name='Spam']")
    private WebElement spamFolder;

    @FindBy(xpath = "//*[@data-test-folder-name='Trash']")
    private WebElement trashFolder;

    @FindBy(xpath = "//li[@data-test-id='folder-list-expand']")
    private WebElement expandFolders;

    @FindBy(xpath = "//li[@data-test-id='folder-list-collapse']")
    private WebElement collapseFolders;

    @FindBy(xpath = "//button[@data-test-id='checkbox']")
    private WebElement selectAllMessages;

    @FindBy(xpath = "//div[@data-test-id='message-toolbar']/div[2]/ul/li[3]")
    private WebElement deleteMessages;

    @FindBy(xpath = "//button[@data-test-id='primary-btn']")
    private WebElement alertOkButton;

    @FindBy(xpath = "//span[@class='o_h G_e J_x em_N']")
    private WebElement messListTo;

    @FindBy(xpath = "//span[contains(@class,'o_h G_e J_x en_N')]")
    private WebElement messListSubj;

    @FindBy(xpath = "//div[@class='J_x o_h C_Z1VRpVF G_e']")
    private WebElement messListBody;

    @FindAll({ @FindBy(xpath = "//span[@class='o_h G_e J_x em_N']"),
            @FindBy(xpath = "//span[contains(@class,'o_h G_e J_x en_N')]"),
            @FindBy(xpath = "//div[@class='J_x o_h C_Z1VRpVF G_e']"), })
    private List<WebElement> allMessagesFieldsList;

    @FindBy(xpath = "//span[@data-test-id='efv-folder-name']")
    private WebElement folderIsEmptyMessage;

    @FindBy(xpath = "//a[@data-test-id='message-list-item']")
    private WebElement mailLine;

    @FindBy(xpath = "//button[@data-test-id='compose-send-button']")
    private WebElement sendMailButton;

    public MailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MailPageObject openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MailPageObject expandFodrersList() {
        expandFolders.click();
        return this;
    }

    public MailPageObject gotoInbox() {
        inboxFolder.click();
        return this;
    }

    public MailPageObject gotoUnread() {
        unreadFolder.click();
        return this;
    }

    public MailPageObject gotoStarred() {
        starredFolder.click();
        return this;
    }

    public MailPageObject gotoArchive() {
        archiveFolder.click();
        return this;
    }

    public MailPageObject gotoSpam() {
        spamFolder.click();
        return this;
    }

    public MailPageObject gotoSent() {
        sentFolder.click();
        return this;
    }

    public MailPageObject gotoTrash() {
        trashFolder.click();
        return this;
    }

    public String getMessageTo() {
        return messListTo.getText();
    }

    public String getMessageSubj() {
        return messListSubj.getText();
    }

    public String getMessageBody() {
        return messListBody.getText();
    }

    public MailPageObject composeMail() {
        composeButton.click();
        return this;
    }

    public MailPageObject setMessageTo(String address) {
        editorToField.sendKeys(address);
        return this;
    }

    public MailPageObject setMessageSubject(String subject) {
        editorSubjectField.sendKeys(subject);
        return this;
    }

    public MailPageObject setMessageBody(String body) {
        editorBodyField.sendKeys(body);
        return this;
    }

    public MainPageObject signOut() {
        accountMenu.click();
        accountMenuSignOut.click();
        return new MainPageObject(driver);
    }

    public MailPageObject selectAllMessages() {
        selectAllMessages.click();
        return this;
    }

    public MailPageObject deleteMessages() {
        deleteMessages.click();
        return this;
    }

}
