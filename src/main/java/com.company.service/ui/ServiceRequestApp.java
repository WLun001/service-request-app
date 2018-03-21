package com.company.service.ui;


import com.company.service.domain.ServiceRequestController;

public class ServiceRequestApp {

    public static void main(String[] args){
        AppUI appUI = new AppUI();
        appUI.setController(new ServiceRequestController());
        appUI.start();
    }
}
