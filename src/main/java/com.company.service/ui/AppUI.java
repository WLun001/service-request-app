package com.company.service.ui;

import com.company.service.domain.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class AppUI implements IUserInterface {

    private ServiceRequestController controller;
    private Scanner scanner;
    private ArrayList<Client> clients;
    private ArrayList<Technician> technicians;
    public AppUI(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void setController(ServiceRequestController controller) {
        this.controller = controller;
        clients = SampleData.getSampleClients();
        technicians = SampleData.getSampleTechnicians();
    }

    @Override
    public void start() {
       displayMainMenu();
    }

    private void displayMainMenu(){
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
                case 4:
                    displayUpdateServiceRequestMenu();
                    break;
                case 5:
                    break;
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
                displayServiceRequest(serviceRequest);
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


    private void displayUpdateServiceRequestMenu() {
        selectServiceRequest();
        int choice;
        do {
            System.out.println("Do you want to:");
            System.out.println("1. Assign technician");
            System.out.println("2. Add service charge");
            System.out.println("3. Back to Main menu");

            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Invalid choice.");
                System.out.print("Enter your choice (1-3): ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    assignTechnician();
                    break;
                case 2:
                    addServiceCharge();
                    break;
            }
            System.out.println();
        } while (choice != 3);
    }

    private void displayServiceRequest(ServiceRequest request){
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

    private void displayTechnicians(){
        for (Technician technician : technicians){
            System.out.println("ID: " + technician.getId()
                    + "\tTechnician Name: " + technician.getName());
        }
    }

    private void assignTechnician(){
        displayTechnicians();
        System.out.print("Enter technician id to assign : ");
        scanner.nextLine();
        String techId = scanner.nextLine();
        List<Technician> technician = technicians.stream().filter(t -> t.getId().equals(techId)).collect(Collectors.toList());
        if (technician.size() > 0) {
            controller.assignTechnician(technician.get(0));
            System.out.println("Successfully assigned technician");
        }
    }

    private void addServiceCharge(){
        System.out.print("Enter service charge : ");
        scanner.nextLine();
        controller.addServiceCharge(scanner.nextDouble());
        System.out.println("Successfully added service charge");
    }
}