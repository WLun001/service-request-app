package com.company.service.domain;

import java.util.UUID;

public class Technician {

    private String id;
    private String name;

    public Technician(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}