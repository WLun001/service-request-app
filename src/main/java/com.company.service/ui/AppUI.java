package com.company.service.ui;

import com.company.service.dbHelper.*;
import com.company.service.domain.Controller;
import com.company.service.domain.ServiceRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AppUI implements IUserInterface {

    PersonList personList;
    private Controller controller;
    private Scanner scanner;
    private final String c = "Client";
    private final String t = "Technician";

    public AppUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        displayMainMenu();
    }

    private void displayMainMenu() {
        int choice;
        do {
            System.out.println("Do you want to:");
            System.out.println("1. Display all service requests");
            System.out.println("2. Display all clients");
            System.out.println("3. Create new service request");
            System.out.println("4. Assign Technician to service request");
            System.out.println("5. Add service charge to service request");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();
            while (choice < 1 || choice > 6) {
                System.out.println("Invalid choice.");
                System.out.print("Enter your choice (1-6): ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    displayServiceRequests();
                    break;
                case 2:
                    displayPerson(new ClientList(), c);
                    break;
                case 3: {
                    displayPerson(new ClientList(), c);
                    createNewServiceRequest();
                }
                    break;
                case 4: {
                    selectServiceRequest();
                    displayPerson(new TechnicianList(), t);
                    assignTechnician();
                }
                    break;
                case 5: {
                    selectServiceRequest();
                    addServiceCharge();
                }
                case 6:
                    break;
            }
            System.out.println();
        } while (choice != 6);
    }

    private void displayServiceRequests() {
        int count = controller.getNumberOfServiceRequest();
        if (count == 0)
            System.out.println("No service requests to display");
        else {
            List<ServiceRequest> serviceRequests = controller.getServiceRequestList();
            for (ServiceRequest serviceRequest : serviceRequests) {
                displayServiceRequest(serviceRequest);
            }
        }
    }

    private void displayPerson(PersonList pList, String message) {
        personList = pList;
        for (Person person : personList.getPersonList()) {
            System.out.println("ID: " + person.getId()
                    + "\t"+ message+  "Name: " + person.getName());
        }
    }

    private void createNewServiceRequest() {
        System.out.println("Enter client ID");
        scanner.nextLine();
        String clientId = scanner.nextLine();
        Person client = personList.search(clientId);
        if (client != null) {
            controller.addServiceRequest((Client) client, LocalDateTime.now().toString());
            System.out.println("Successfully added service request");
        } else System.out.println("No matches found");
    }

    private void displayServiceRequest(ServiceRequest request) {
        if (request == null)
            System.out.println("No matches found");
        else {
            System.out.println("\nId: " + request.getId()
                    + "\nService date " + request.getDate()
                    + "\nClient: " + request.getClient().getName());
            String technician = request.getTechnician() != null ? request.getTechnician().getName() : "No technician assigned";
            System.out.println("Technician : " + technician);
            System.out.println("Service charge : " + request.getServiceCharge());
        }
    }

    private void selectServiceRequest() {
        displayServiceRequests();
        System.out.print("Enter service request id : ");
        scanner.nextLine();
        String requestId = scanner.nextLine();
        displayServiceRequest(controller.searchServiceRequest(requestId));
    }

    private void assignTechnician() {
        System.out.print("Enter technician id to assign : ");
        scanner.nextLine();
        String techId = scanner.nextLine();
        Person technician = personList.search(techId);
        if (technician != null) {
            controller.assignTechnician((Technician) technician);
            System.out.println("Successfully assigned technician");
        }
    }

    private void addServiceCharge() {
        System.out.print("Enter service charge : ");
        scanner.nextLine();
        controller.addServiceCharge(scanner.nextDouble());
        System.out.println("Successfully added service charge");
    }
}