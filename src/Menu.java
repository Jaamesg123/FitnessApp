import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.parser.Parser;

import com.mysql.cj.ParseInfo;

import dao.ClassesDao;
import dao.ClientsDao;
import dao.InstructorsDao;
import entity.Clients;
import entity.Instructors;

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
	
	public void start() throws SQLException, ParseException {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					//method();
				} else if (selection.equals("2")) {
					viewAllInstructors();
				} else if (selection.equals("3")) {
					viewAllClients();
				} else if (selection.equals("4")) {
					viewClientsInSpecificClass();
				} else if (selection.equals("5")) {
					//method();
				} else if (selection.equals("6")) {
					//method();
				} else if (selection.equals("7")) {
					//method();
				} else if (selection.equals("8")) {
					updateClientClass();
				} else if (selection.equals("9")) {
					deleteClient();
				} else if (selection.equals("10")) {
					addNewClient();
				} else if (selection.equals("11")) {
					updatePayRate();
				} else if (selection.equals("12")) {
					deleteInstructor();
				} else if (selection.equals("13")) {
					addNewInstructor();
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
	

	private void deleteInstructor() throws SQLException {
		System.out.println("Enter nstructor ID you would like to remove: ");
		int instructor_ID = Integer.parseInt(scanner.nextLine());
		
		instructorDao.removeInstructor(instructor_ID);
		System.out.println("Instructor Removed");
	}


	private void updatePayRate() throws SQLException {
		System.out.println("Enter Instructor ID: ");
		int instructor_ID = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Pay Rate (xxxx.xx): ");
		double pay_rate = Double.parseDouble(scanner.nextLine());
		instructorDao.updatePay(instructor_ID, pay_rate);
		
		System.out.println("Pay Rate Updated");
	}


	private void addNewInstructor() throws SQLException {
		
		
		System.out.println("Enter First Name: ");
		String instructor_FN = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String instructor_LN = scanner.nextLine();
		System.out.println("Enter Classes (Zumba, Yoga, ...)");
		String classes_taught = scanner.nextLine();
		System.out.println("Enter Pay Rate (xxxx.xx): ");
		double pay_rate = Double.parseDouble(scanner.nextLine());
		
		instructorDao.newInstructor(instructor_FN, instructor_LN, classes_taught, pay_rate);
		
		System.out.println("New Instructor Added");
	}

	
	private void viewAllInstructors() throws SQLException {
		List<Instructors> instructors = instructorDao.getInstructors(); 
		for (Instructors instructor : instructors) {
			System.out.println("Instructor ID: " + instructor.getInstructor_ID() + ", Instructor First Name: " + instructor.getInstructor_FN() + ", Instructor Last Name: " + instructor.getInstructor_LN() + ", Pay Rate: " + instructor.getPay_rate() + ", Classes Taught: " + instructor.getClass());
		}
		
		
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
	
	private void addNewClient() throws SQLException, ParseException {
		System.out.println("Enter first name:");
		String fName = scanner.nextLine();
		System.out.println("Enter last name");
		String lName = scanner.nextLine();
		System.out.println("Enter birthdate (YYYY-MM-DD");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
		Date birthdate = (Date) simpleDateFormat.parse(scanner.nextLine());
		System.out.println("Enter 4-digit class ID:");
		int classId = Integer.parseInt(scanner.nextLine());
		clientsDao.createNewClient(fName, lName, birthdate, classId);
	}
 

}
