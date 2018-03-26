package com.company.service.dbHelper;

public class Client extends Person {
    private String address;
    private String contactNo;

    public Client(String name, String address, String contactNo) {
        super(name);
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }
}