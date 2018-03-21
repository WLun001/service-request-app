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

    public void addServiceRequest(String clientName, String clientAdd, String clientNo, String date){
        requestList.addServiceRequest(new Client(clientName, clientAdd, clientNo), date);
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

    public void assignTechnician(String name){
        if (serviceRequest.getTechnician() == null) {
            serviceRequest.setTechnician(new Technician(name));
        } else throw new UnsupportedOperationException("Only one technician is allowed for one com.company.com.company.service request");
    }
}
