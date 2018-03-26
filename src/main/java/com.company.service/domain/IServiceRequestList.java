package com.company.service.domain;

import com.company.service.dbHelper.Client;

import java.util.List;

interface IServiceRequestList {
    void addServiceRequest(Client client, String date);

    ServiceRequest searchServiceRequest(String requestId);

    int getServiceRequestCount();

    List<ServiceRequest> getServiceRequestList();
}