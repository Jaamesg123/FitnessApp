import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	//private ClientsDao clientsDao = new ClientsDao();
	//private ClassesDao classesDao = new ClassesDao();
	//private InstructorsDao instructorDao = new InstructorDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"View List of All Classes",
			"View List of All Instructors",
			"View List of All Clients",
			"View Clients Within a Specific Class",
			"Update Class Day/Time",
			"Delete Class",
			"Add New Class",
			"Update Client Class Type",
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
					//method();
				} else if (selection.equals("2")) {
					//getAllInstructors();
				} else if (selection.equals("3")) {
					//method();
				} else if (selection.equals("4")) {
					//method();
				} else if (selection.equals("5")) {
					//method();
				} else if (selection.equals("6")) {
					//method();
				} else if (selection.equals("7")) {
					//method();
				} else if (selection.equals("8")) {
					//method();
				} else if (selection.equals("9")) {
					//method();
				} else if (selection.equals("10")) {
					//method();
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
	
	private void getAllInstructors() {
		// TODO Auto-generated method stub
		
	}

	private void printMenu() {
		System.out.println("Select an Option:\n---------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

}
