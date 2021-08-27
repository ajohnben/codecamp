package com.accessHQ.heroku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveTestSuite {

    private WebDriver driver;

    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
    }


}
