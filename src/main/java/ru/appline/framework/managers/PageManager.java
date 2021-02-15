package ru.appline.framework.managers;

import ru.appline.framework.pages.MortgagePage;
import ru.appline.framework.pages.StartPage;

public class PageManager {
    private static PageManager pageManager;
    private StartPage startPage;
    private MortgagePage mortgagePage;

    private PageManager(){

    }
    public static PageManager getPageManager(){
        if(pageManager == null) {
            pageManager = new PageManager();
        }
         return pageManager;
    }
    public StartPage getStartPage(){
        if(startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgagePage getMortgagePage() {
        if(startPage == null){
            startPage = new StartPage();
        }
        return mortgagePage;
    }
}
