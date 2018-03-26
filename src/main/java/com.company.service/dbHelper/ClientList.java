package com.company.service.dbHelper;

import java.util.ArrayList;
import java.util.List;

public class ClientList extends PersonList {

    public ClientList() {
        init();
    }

    private void init() {
        ArrayList<Person> clients = new ArrayList<>();
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
        persons = clients;
    }
}
