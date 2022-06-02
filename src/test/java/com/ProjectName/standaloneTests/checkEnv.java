package com.ProjectName.standaloneTests;

import com.ProjectName.utilities.ConfigurationReader;
import com.ProjectName.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class checkEnv {
    @Test
    public void test1(){
        //ConfigurationReader.getProperty("env")
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));


    }
}
