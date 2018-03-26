package com.company.service.ui;


import com.company.service.domain.Controller;

public class ServiceRequestApp {

    public static void main(String[] args) {
        AppUI appUI = new AppUI();
        appUI.setController(new Controller());
        appUI.start();
    }
}