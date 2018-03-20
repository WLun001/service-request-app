package java.service.domain;

import java.util.UUID;

public class Technician {

    private String id;
    private String name;

    public Technician(String name){
        this.id = UUID.fromString(name).toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
