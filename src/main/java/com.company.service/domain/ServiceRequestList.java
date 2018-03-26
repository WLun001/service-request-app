package com.company.service.domain;

import com.company.service.dbHelper.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRequestList implements IServiceRequestList {
    private List<ServiceRequest> serviceRequests;

    public ServiceRequestList() {
        serviceRequests = new ArrayList<>();
    }

    @Override
    public void addServiceRequest(Client client, String date) {
        serviceRequests.add(new ServiceRequest(client, date));
    }

    /**
     * Find the first matched  of {@link ServiceRequest}
     *
     * @param requestId Unique id of {@link ServiceRequest}
     * @return {@link ServiceRequest}
     */
    @Override
    public ServiceRequest searchServiceRequest(String requestId) {
        return serviceRequests
                .stream()
                .filter(serviceRequest -> serviceRequest.getId().equals(requestId))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public int getServiceRequestCount() {
        return serviceRequests.size();
    }

    @Override
    public List<ServiceRequest> getServiceRequestList() {
        return serviceRequests;
    }
}