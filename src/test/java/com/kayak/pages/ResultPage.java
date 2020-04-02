package com.kayak.pages;

import com.kayak.Utils.BasePage;
import com.kayak.Utils.Driver;
import org.openqa.selenium.support.PageFactory;

import java.sql.ResultSet;

public class ResultPage extends BasePage {

    public ResultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
