package com.company.service.ui;

import com.company.service.domain.Client;
import com.company.service.domain.SampleData;
import com.company.service.domain.ServiceRequest;
import com.company.service.domain.ServiceRequestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class AppUI implements IUserInterface {

    private ServiceRequestController controller;
    private Scanner scanner;
    private ArrayList<Client> clients;
    public AppUI(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void setController(ServiceRequestController controller) {
        this.controller = controller;
        clients = SampleData.getSampleClients();
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.println("Do you want to:");
            System.out.println("1. Display all service requests");
            System.out.println("2. Display all clients");
            System.out.println("3. Create new service request");
            System.out.println("4. Update service request");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Invalid choice.");
                System.out.print("Enter your choice (1-5): ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    displayServiceRequests();
                    break;
                case 2:
                    displayClients();
                    break;
                case 3:
                    createNewServiceRequest();
                    break;
//                case 4:
//                    updateServiceRequest();
//                    break;
//                case 5:
//                    break;
            }
            System.out.println();
        } while (choice != 5);
    }

    private void displayServiceRequests() {
        int count = controller.getNumberOfServiceRequest();
        if (count == 0)
            System.out.println("No service requests to display");
        else {
            List<ServiceRequest> serviceRequests = controller.getServiceRequestList();
            for (ServiceRequest serviceRequest : serviceRequests) {
                System.out.println("ID: " + serviceRequest.getId()
                        + "\tClient Name: " + serviceRequest.getClient().getName()
                        + "\tService Date: " + serviceRequest.getDate());
            }
        }
    }

    private void displayClients() {
        for (Client client : clients){
            System.out.println("ID: " + client.getId()
                    + "\tClient Name: " + client.getName());
        }
    }

    private void createNewServiceRequest() {
        displayClients();
        System.out.println("Enter client ID");
        scanner.nextLine();
        String clientId = scanner.nextLine();
        List<Client> client = clients.stream().filter(c -> c.getId().equals(clientId)).collect(Collectors.toList());
        if (client.size() > 0) {
            controller.addServiceRequest(client.get(0), LocalDateTime.now().toString());
            System.out.println("Successfully added service request");
        }
        else System.out.println("No matches found");
    }
//
//    private void selectWorkshop() {
//        System.out.print("Enter workshop title: ");
//        String skip = scanner.nextLine();
//        String title = scanner.nextLine();
//        Workshop workshop = controller.searchWorkshop(title);
//        if (workshop == null)
//            System.out.println("No workshop with title " + title + " found");
//        else {
//            System.out.println("Title: " + workshop.getTitle()
//                    + "\tMax Participants: " + workshop.getMaxParticipants()
//                    + "\tCurrent Participants: " + workshop.getNumberOfParticipants());
//        }
//    }
//
//    private void updateServiceRequest() {
//        System.out.print("Enter workshop title: ");
//        String skip = scanner.nextLine();
//        String title = scanner.nextLine();
//
//        System.out.print("Enter max number of participants can accept: ");
//        int maxParticipants = scanner.nextInt();
//
//        controller.registerWorkshop(title, maxParticipants);
//        System.out.println("New workshop registered");
//        System.out.println();
//    }
}