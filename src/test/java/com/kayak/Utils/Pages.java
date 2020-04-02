package com.kayak.Utils;

import com.kayak.pages.LandingPage;
import com.kayak.pages.ResultPage;

public class Pages {

    private LandingPage landingPage;
    private ResultPage resultPage;


    public LandingPage landingPage(){

        if(landingPage == null){
            landingPage = new LandingPage();
        }

        return landingPage;
    }

    public ResultPage resultPage(){

        if(resultPage() == null){
           resultPage = new ResultPage();
        }

        return resultPage();
    }



}
