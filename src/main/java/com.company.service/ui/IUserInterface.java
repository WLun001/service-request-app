package com.company.service.ui;

import com.company.service.domain.ServiceRequestController;

interface IUserInterface {
    void setController(ServiceRequestController controller);
    void start();
}
