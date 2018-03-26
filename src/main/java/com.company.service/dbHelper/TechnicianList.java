package com.company.service.dbHelper;

import java.util.ArrayList;

public class TechnicianList extends PersonList {

    public TechnicianList() {
        init();
    }

    @Override
    protected void init() {
        ArrayList<Person> technicians = new ArrayList<>();
        technicians.add(new Technician("Chia Kim Hui"));
        technicians.add(new Technician("Lee Pei Ling"));
        technicians.add(new Technician("See Lem"));
        technicians.add(new Technician("Chua Ai Sim"));
        technicians.add(new Technician("Lee Kai Li"));
        technicians.add(new Technician("Chua C.C"));
        technicians.add(new Technician("Chow Pui Yan"));
        technicians.add(new Technician("Andy Lau"));
        technicians.add(new Technician("Teoh Wan Ching"));
        technicians.add(new Technician("Yong Wei Lun"));
        technicians.trimToSize();
        persons = technicians;
    }
}
