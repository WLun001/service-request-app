package java.service.domain;

import java.util.List;

interface IServiceRequestList {
    void addServiceRequest(Client client, String date);
    ServiceRequest searchServiceRequest(String requestId);
    int getServiceRequestCount();
    List<ServiceRequest> getServiceRequestList();
}
