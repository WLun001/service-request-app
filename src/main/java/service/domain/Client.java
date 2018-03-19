package java.service.domain;

import java.util.UUID;

public class Client {

    private String id;
    private String name;
    private String address;
    private String contactNo;

    public Client(String name, String address, String contactNo){
        id = UUID.fromString(name).toString();
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }
}