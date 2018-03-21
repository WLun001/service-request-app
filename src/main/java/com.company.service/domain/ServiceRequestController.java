package com.company.service.domain;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequestController {
    private IServiceRequestList requestList;
    private ServiceRequest serviceRequest;

    public ServiceRequestController(){
        requestList = new ServiceRequestList();
    }

    public ServiceRequest getSelectedServiceRequest() {
        return serviceRequest;
    }

    public void addServiceRequest(Client client, String date){
        requestList.addServiceRequest(client, date);
    }

    public ServiceRequest searchServiceRequest(String requestId){
        serviceRequest = requestList.searchServiceRequest(requestId);
        return  serviceRequest;
    }

    public int getNumberOfServiceRequest(){
        return requestList.getServiceRequestCount();
    }

    public List<ServiceRequest> getServiceRequestList() {
        return requestList.getServiceRequestList();
    }

    public void assignTechnician(Technician technician){
        if (serviceRequest.getTechnician() == null) {
            serviceRequest.setTechnician(technician);
        } else throw new UnsupportedOperationException("Only one technician is allowed for one service request");
    }

    public void addServiceCharge(double serviceCharge){
        serviceRequest.setServiceCharge(serviceCharge);
    }
}
