import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ClassesDao;
import dao.ClientsDao;
import dao.InstructorsDao;
import entity.Classes;
import entity.Clients;


public class Menu {
	
	private ClientsDao clientsDao = new ClientsDao();
	private ClassesDao classesDao = new ClassesDao();
	private InstructorsDao instructorDao = new InstructorsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"View List of All Classes",
			"View List of All Instructors",
			"View List of All Clients",
			"View Clients Within a Specific Class",
			"Update Class Day/Time",
			"Delete Class",
			"Add New Class",
			"Update Client's Class",
			"Delete Client",
			"Add New Client",
			"Update Instructor Pay Rate",
			"Delete Instructor",
			"Add New Instrcutor");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayClasses();
				} else if (selection.equals("2")) {
					//getAllInstructors();
				} else if (selection.equals("3")) {
					viewAllClients();
				} else if (selection.equals("4")) {
					viewClientsInSpecificClass();
				} else if (selection.equals("5")) {
					updateClassDateAndTime();
				} else if (selection.equals("6")) {
					deleteClass();
				} else if (selection.equals("7")) {
					createClass();
				} else if (selection.equals("8")) {
					updateClientClass();
				} else if (selection.equals("9")) {
					deleteClient();
				} else if (selection.equals("10")) {
					addNewClient();
				} else if (selection.equals("11")) {
					//method();
				} else if (selection.equals("12")) {
					//method();
				} else if (selection.equals("13")) {
					//method();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayClasses() throws SQLException {
		List<Classes> classes = classesDao.getClasses();
		for (Classes classe : classes) {
			System.out.println(classe.getClassId() + ": " + classe.getClassType() + "  Date and Time of class: " + classe.getDateAndTime());
		}
	}
	
	private void getAllInstructors() {
		// TODO Auto-generated method stub
		
	}
	
	private void viewAllClients() throws SQLException {
		List<Clients> clients = clientsDao.getClients();
		for (Clients client : clients) {
			System.out.println("Client ID:" + client.getId() + ", Client Name:" + client.getfName() + " " + client.getlName()
			+ ", DOB:" + client.getBirthdate() + ", Class ID:" + client.getClassId());
		}
	}
	
	private void viewClientsInSpecificClass() throws SQLException {
		System.out.println("Enter class id: ");
		int classId = Integer.parseInt(scanner.nextLine());
		Clients clients = clientsDao.getClientsByClassID(classId);
		System.out.println(clients.getfName() + " " + clients.getlName());
	}
	
	private void updateClassDateAndTime() throws SQLException {
		System.out.println("Enter Class ID you want to change the date and time for: ");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter new date and time: ");
		String dateAndTime = scanner.nextLine();
		classesDao.updateClassDateAndTimeById(classId, dateAndTime);
	}
	
	private void deleteClass() throws SQLException {
		System.out.println("Enter the class ID you would like to delete: ");
		int classId = Integer.parseInt(scanner.nextLine());
		classesDao.deleteClassById(classId);
	}
	
	private void createClass() throws SQLException {
		System.out.println("Enter class type: ");
		String classType = scanner.nextLine();
		System.out.println("Enter the date and time of the class: ");
		String dateAndTime = scanner.nextLine();
		classesDao.createNewClassById(classType, dateAndTime);
	}

	private void updateClientClass() throws SQLException {
		System.out.println("Enter client's new class id:");
		int classId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter client id:");
		int clientId = Integer.parseInt(scanner.nextLine());
		clientsDao.updateClientClassById(classId, clientId);
	}
	
	private void deleteClient() throws SQLException {
		System.out.println("Enter client id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		clientsDao.deleteClientById(id);
	}
	
	private void addNewClient() throws SQLException {
		System.out.println("Enter first name:");
		String fName = scanner.nextLine();
		System.out.println("Enter last name");
		String lName = scanner.nextLine();
		System.out.println("Enter birthdate (YYYY-MM-DD");
		Date birthdate = parser.parse(scanner.nextLine());
		System.out.println("Enter 4-digit class ID:");
		int classId = Integer.parseInt(scanner.nextLine());
		clientsDao.createNewClient(fName, lName, birthdate, classId);
	}
 

}
