package com.company.service.domain;

import com.company.service.dbHelper.Client;
import com.company.service.dbHelper.Technician;

import java.util.List;

public class Controller {
    private IServiceRequestList requestList;
    private ServiceRequest serviceRequest;

    public Controller() {
        requestList = new ServiceRequestList();
    }

    public ServiceRequest getSelectedServiceRequest() {
        return serviceRequest;
    }

    public void addServiceRequest(Client client, String date) {
        requestList.addServiceRequest(client, date);
    }

    public ServiceRequest searchServiceRequest(String requestId) {
        serviceRequest = requestList.searchServiceRequest(requestId);
        return serviceRequest;
    }

    public int getNumberOfServiceRequest() {
        return requestList.getServiceRequestCount();
    }

    public List<ServiceRequest> getServiceRequestList() {
        return requestList.getServiceRequestList();
    }

    public void assignTechnician(Technician technician) {
        if (serviceRequest.getTechnician() == null) {
            serviceRequest.setTechnician(technician);
        } else throw new UnsupportedOperationException("Only one technician is allowed for one service request");
    }

    public void addServiceCharge(double serviceCharge) {
        serviceRequest.setServiceCharge(serviceCharge);
    }
}