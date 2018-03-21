package com.company.service.domain;

import java.util.UUID;

public class ServiceRequest {
    private String id;
    private String date;
    private Client client;
    private Technician technician;
    private double serviceCharge;

    public ServiceRequest(Client client, String date) {
        this.id = UUID.randomUUID().toString();
        this.client = client;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}