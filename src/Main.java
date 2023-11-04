import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	   private static void showCommands() {
	        System.out.println("help         - Afiseaza aceasta lista de comenzi");
	        System.out.println("add          - Adauga o noua persoana (inscriere)");
	        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
	        System.out.println("remove       - Sterge o persoana existenta din lista");
	        System.out.println("update       - Actualizeaza detaliile unei persoane");
	        System.out.println("guests       - Lista de persoane care participa la eveniment");
	        System.out.println("waitlist     - Persoanele din lista de asteptare");
	        System.out.println("available    - Numarul de locuri libere");
	        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
	        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
	        System.out.println("subscribe_no - Numarul total de persoane inscrise");
	        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
	        System.out.println("quit         - Inchide aplicatia");
	    }

	    private static void addNewGuest(Scanner sc, GuestsList list) {
	    	System.out.println("Nume: ");
	    	String lastName = sc.next();
	    	System.out.println("Prenume: ");
	    	String firstName = sc.next();
	    	System.out.println("E-mail: ");
	    	String email = sc.next();
	    	System.out.println("Numar de telefon: ");
	    	String phoneNumber = sc.next();
	    	Guest g = new Guest(lastName, firstName, email, phoneNumber);
	    	list.add(g); 	
	    }

	    private static void checkGuest(Scanner sc, GuestsList list) {
	    	System.out.println("Introduceti optiunea: "
	    			+ "\n1.Cauta dupa nume si prenume: "
	    			+ "\n2.Cauta dupa email: " 
	    			+ "\n3.Cauta dupa numarul de telefon: ");
	    
	    	int option = sc.nextInt();

	            switch (option) {
	                case 1:
	                	System.out.println("Introduceti numele: ");
	        	    	String lastName = sc.next();
	       	    	System.out.println("Introduceti prenumele: ");
	        	    	String firstName = sc.next();
	        	    	System.out.println(list.search(firstName, lastName));
	        	    	break;
	                case 2:
	                	System.out.println("Introduceti adresa de e-mail: ");
	        	    	String email = sc.next();
	        	    	System.out.println(list.search(2, email));
	        	    	break;
	                case 3:
	                	System.out.println("Introduceti numarul de telefon: ");
	        	    	String phoneNumber = sc.next();
	        	    	System.out.println(list.search(3, phoneNumber));
	        	    	break;
	            } 	    	
	    }

	    private static void removeGuest(Scanner sc, GuestsList list) {
	    	System.out.println("Introduceti optiunea: "
	    			+ "\n1.Cauta dupa nume si prenume: "
	    			+ "\n2.Cauta dupa email: " 
	    			+ "\n3.Cauta dupa numarul de telefon: ");
	    	
	    	int option = sc.nextInt();

	            switch (option) {
	                case 1:
	                	System.out.println("Introduceti numele: ");
	        	    	String lastName = sc.next();
	        	    	System.out.println("Introduceti prenumele: ");
	        	    	String firstName = sc.next();
	        	    		if (list.remove(firstName, lastName)) {
	        	    			break;
	        	    		}
	                    break;
	                case 2:
	                	System.out.println("Introduceti adresa e-mail: ");
	        	    	String email = sc.next();
	        	    		if (list.remove(2, email)) {
	        	    		break;
	        	    		}
	                    break;
	                case 3:
	                	System.out.println("Introduceti numarul de telefon: ");
	        	    	String phoneNumber = sc.next();
	        	    		if (list.remove(3, phoneNumber)) {
	        	    			break;
	        	    		}
	        	    	break;
	            }
	    }
	    
	    private static Guest checkGuestToBeUpdated(Scanner sc, GuestsList list) {
	    	System.out.println("Introduceti optiunea: "
	    			+ "\n1.Cauta dupa nume si prenume: "
	    			+ "\n2.Cauta dupa email: " 
	    			+ "\n3.Cauta dupa numarul de telefon: ");
	    	
	    	int option = sc.nextInt();

	            switch (option) {
	                case 1:
	                	System.out.println("Introduceti numele: ");
	        	    	String lastName = sc.next();
	        	    	System.out.println("Introduceti prenumele: ");
	        	    	String firstName = sc.next();
	        	    	return list.search(firstName, lastName);
	                case 2:
	                	System.out.println("Introduceti adresa e-mail: ");
	        	    	String email = sc.next();
	        	    	return list.search(2, email);
	                case 3:
	               	System.out.println("Introduceti numarul de telefon: ");
	        	    	String phoneNumber = sc.next();
	        	    	return list.search(3, phoneNumber);
	            } 	
	            
	            return null;
	    }   

	    private static void updateGuest(Scanner sc, GuestsList list) {
	    	Guest guestToBeUpdated = checkGuestToBeUpdated(sc, list);
	    	
	    	if (guestToBeUpdated != null) {
			    System.out.println("Introduceti optiunea de actualizare: "
	 	 	    			+ "\n1.Actualizeaza numele: "
	 	 	    			+ "\n2.Actualizeaza prenumele: " 
	 	 	    			+ "\n3.Actualizeaza adresa de e-mail: " 
	 	 	    			+ "\n4.Actualizeaza numarul de telefon: ");	
	 	    	
	    		int option = sc.nextInt();
	    	
	            switch (option) {
		        	case 1:
		    	    	System.out.println("Introduceti noul nume: ");
		    	    	String newLastName = sc.next();
		    	    	guestToBeUpdated.setLastName(newLastName);
		    	   		break;
		        	case 2:
		    	    	System.out.println("Introduceti noul prenume: ");
		    	    	String newFirstName = sc.next();
		    	    	guestToBeUpdated.setFirstName(newFirstName);  
		    	    	break;
		            case 3:
		    	    	System.out.println("Introduceti noua adresa de e-mail: ");
			    		String newEmail = sc.next();
			    		guestToBeUpdated.setEmail(newEmail);
		                break;
		            case 4:
		    	    	System.out.println("Introduceti noul numar de telefon: ");
			    		String newPhoneNumber = sc.next();
			    		guestToBeUpdated.setPhoneNumber(newPhoneNumber);
		                break;
			    	}
	    	}
	    }

	    private static void searchList(Scanner sc, GuestsList list) {
	    	System.out.println("Introduceti secventa de caractere pentru cautare: ");
	    	String subString = sc.next();
	        ArrayList<Guest> matches = list.partialSearch(subString);
	        
	        for (int i = 0; i < matches.size(); i++) {
	        	System.out.println("Nume: " + matches.get(i).getLastName() + " " + matches.get(i).getFirstName() 
	        			+ ", Email: " + matches.get(i).getEmail() + ", Telefon: " + matches.get(i).getPhoneNumber());
	        }
	        
	        if (matches.isEmpty()) {
	        	System.out.println("Nothing found");
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Bun venit! Introduceti numarul de locuri disponibile: ");
	        int size = scanner.nextInt();
	        
	        System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi) ");
	        scanner.nextLine();

	        GuestsList list = new GuestsList(size);

	        boolean running = true;
	        while (running) {
	        	
	            String command = scanner.next();

	            switch (command) {
	                case "help":
	                    showCommands();
	                    break;
	                case "add":
	                    addNewGuest(scanner, list);
	                    break;
	                case "check":
	                    checkGuest(scanner, list);
	                    break;
	                case "remove":
	                    removeGuest(scanner, list);
	                    break;
	                case "update":
	                	updateGuest(scanner, list);
	                    break;
	                case "guests":
	                    list.showGuestsList();
	                    break;
	                case "waitlist":
	                    list.showWaitingList();
	                    break;
	                case "available":
	                    System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
	                    break;
	                case "guests_no":
	                    System.out.println("Numarul de participanti: " + list.numberOfGuests());
	                    break;
	                case "waitlist_no":
	                    System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
	                    break;
	                case "subscribe_no":
	                    System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
	                    break;
	                case "search":
	                    searchList(scanner, list);
	                    break;
	                case "quit":
	                    System.out.println("Aplicatia se inchide...");
	                    scanner.close();
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Comanda introdusa nu este valida.");
	                    System.out.println("Incercati inca o data.");
	                    break;
	            }
	        }
	    }
}
