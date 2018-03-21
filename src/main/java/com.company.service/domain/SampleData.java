package com.company.service.domain;

import java.util.ArrayList;

public class SampleData {

    public static ArrayList<Client> getSampleClients() {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Dheeno", "Ampang", "012-2722330"));
        clients.add(new Client("Hong Ah Kau", "Kajang", "012-2724330"));
        clients.add(new Client("Leong Jia Meng", "Hula Langat", "014-2727330"));
        clients.add(new Client("Wong Jia Hau", "Kuala Lumpur", "015-2727330"));
        clients.add(new Client("Tew Ah Sau", "Serdang", "012-2725330"));
        clients.add(new Client("Si Xiao Gui", "Sungai Long", "012-6727330"));
        clients.add(new Client("Chua Der Xi", "Cheras", "012-2727730"));
        clients.add(new Client("Jasmie Ah Bu", "Taman Bukit Segar", "012-2737330"));
        clients.add(new Client("Ham Ah Kau", "Connought", "012-2726330"));
        clients.trimToSize();
        return clients;
    }

    public static ArrayList<Technician> getSampleTechnicians() {
        ArrayList<Technician> technicians = new ArrayList<>();
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
        return technicians;
    }
}