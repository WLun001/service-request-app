package com.company.service.ui;

import com.company.service.domain.Controller;

interface IUserInterface {
    void setController(Controller controller);

    void start();
}