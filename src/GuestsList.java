import java.util.ArrayList;

public class GuestsList {
    private int availableSpots;
    private ArrayList<Guest> participantsList;
    private ArrayList<Guest> waitingList;
    
    public GuestsList(int guestsCapacity) {
    	participantsList = new ArrayList<Guest>(guestsCapacity);
    	waitingList = new ArrayList<Guest>();
    	this.availableSpots = guestsCapacity;
    }

    /**
     * Add a new, unique guest to the list.
     *
     * @param g the guest to be added
     * @return '-1' if the guest is already present, '0' if he is a guest, or the
     *         number on the waiting list
     */
    public int add(Guest g) {
    	if (participantsList.size() < this.availableSpots) {
    		if (!isOnTheListAlready(g)) {
    			participantsList.add(g);
    			System.out.println("[" + g.fullName() + "] " + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
    			return 0;
    		} else {
    			System.out.println("[" + g.fullName() + "] " + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
    			return -1;
    		}
    	} else {
    		if (!isOnTheListAlready(g)) {
    			waitingList.add(g);
    			System.out.println("[" + g.fullName() + "] " + "Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " 
    								+ (waitingList.indexOf(g) + 1) + ". Te vom notifica daca un loc devine disponibil.");
    			return (waitingList.indexOf(g) + 1);    
    		} else {
    			System.out.println("[" + g.fullName() + "] " + "Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " 
    								+ (waitingList.indexOf(g) + 1) + ". Te vom notifica daca un loc devine disponibil.");
    			return -1;  
    		}  
    	}
    }
    
    /**
     * Check if someone is already registered (either as a guest, or on the waiting
     * list).
     *
     * @param g the guest we are searching for
     * @return true if present, false if not
     */
    private boolean isOnTheListAlready(Guest g) {
        for (int i = 0; i < participantsList.size(); i++) {
        	if (participantsList.get(i).equals(g)) {	
        		return true;
        	}	
        }
      /*  
        if (participantsList.contains(g)) {
        	return true;
        }
        */
        
        for (int i = 0; i < waitingList.size(); i++) {
        	if (waitingList.get(i).equals(g)) {	
            	return true;
            }
        }
        
        return false;
    }

    /**
     * Search for a guest based on first and last name. Return the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return the guest if found, null if not
     */
    public Guest search(String firstName, String lastName) {
        for (int i = 0; i < participantsList.size(); i++) {
        	if (participantsList.get(i).getFirstName().toLowerCase().equals(firstName.toLowerCase())
        		|| participantsList.get(i).getLastName().toLowerCase().equals(lastName.toLowerCase())) {
        		return participantsList.get(i);
        	}
        }
        
        for (int i = 0; i < waitingList.size(); i++) {
        	if (waitingList.get(i).getFirstName().toLowerCase().equals(firstName.toLowerCase())
        		|| waitingList.get(i).getLastName().toLowerCase().equals(lastName.toLowerCase())) {
        		return waitingList.get(i);
        	}
        }
        
        return null;
    }

    /**
     * Search for a guest based on email or phone number. Return the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return the guest if found, null if not
     */
    public Guest search(int opt, String match) {
    	if (opt == 2) {
    		for (int i = 0; i < participantsList.size(); i++) {
    			if (participantsList.get(i).getEmail().toLowerCase().equals(match.toLowerCase())) {
    				return participantsList.get(i);
    			}
    		}
    		
            for (int i = 0; i < waitingList.size(); i++) {
            	if (waitingList.get(i).getEmail().toLowerCase().equals(match.toLowerCase())) {
            		return waitingList.get(i);
            	}
            }
    	}
    	
    	if (opt == 3) {
    		for (int i = 0; i < participantsList.size(); i++) {
    			if (participantsList.get(i).getPhoneNumber().toLowerCase().equals(match.toLowerCase())) {
    				return participantsList.get(i);
    			}
    		}
            for (int i = 0; i < waitingList.size(); i++) {
            	if (waitingList.get(i).getPhoneNumber().toLowerCase().equals(match.toLowerCase())) {
            		return waitingList.get(i);
            	}
            }
    	}
    
       return null;
    }

    /**
     * Remove a guest based on first and last name. Remove the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return true if removed, false if not
     */
    public boolean remove(String firstName, String lastName) {
        for (int i = 0; i < participantsList.size(); i++) {
        	if (participantsList.get(i).getFirstName().toLowerCase().equals(firstName.toLowerCase())
        		|| participantsList.get(i).getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				participantsList.remove(participantsList.get(i));
				
				if (!waitingList.isEmpty()) {
					participantsList.add(waitingList.get(0));
					System.out.println("Felicitari " + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName() 
							+ "! Locul tau la eveniment este confirmat. Te asteptam!");
					waitingList.remove(waitingList.get(0));
				}
				
        		return true;
        	}
        }
        
    	return false;
    }

    /**
     * Remove a guest based on email or phone number. Remove the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return true if removed, false if not
     */
    public boolean remove(int opt, String match) {
    	if (opt == 2) {
    		for (int i = 0; i < participantsList.size(); i++) {
    			if (participantsList.get(i).getEmail().toLowerCase().equals(match.toLowerCase())) {
    				participantsList.remove(participantsList.get(i));
    				
    				if (!waitingList.isEmpty()) {
    					participantsList.add(waitingList.get(0));
    					System.out.println("Felicitari " + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName() 
    							+ "! Locul tau la eveniment este confirmat. Te asteptam!");
    					waitingList.remove(waitingList.get(0));
    				}
    				
            		return true;
    			}
    		}
    	}
        
    	if (opt == 3) {
    		for (int i = 0; i < participantsList.size(); i++) {
    			if (participantsList.get(i).getPhoneNumber().toLowerCase().equals(match.toLowerCase())) {
    				participantsList.remove(participantsList.get(i));
    				
    				if (!waitingList.isEmpty()) {
    					participantsList.add(waitingList.get(0));
    					System.out.println("Felicitari " + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName() 
    							+ "! Locul tau la eveniment este confirmat. Te asteptam!");
    					waitingList.remove(waitingList.get(0));
    				}
    				
            		return true;
    			}
    		}
    	}
    	
    	return false;
    }

    // Show the list of guests.
    public void showGuestsList() {
    	for (int i = 0; i < participantsList.size(); i++) {
			System.out.println((i + 1) + ". " + participantsList.get(i));
			}
    }

    // Show the people on the waiting list.
    public void showWaitingList() {
    	for (int i = 0; i < waitingList.size(); i++) {
			System.out.println((i + 1) + ". " + waitingList.get(i));
			}
    	if (waitingList.isEmpty()) {
    		System.out.println("Lista de asteptare este goala...");
    	}
    }

    /**
     * Show how many free spots are left.
     *
     * @return the number of spots left for guests
     */
    public int numberOfAvailableSpots() {
        return this.availableSpots - this.participantsList.size();
    }

    /**
     * Show how many guests there are.
     *
     * @return the number of guests
     */
    public int numberOfGuests() {
        return this.participantsList.size();
    }

    /**
     * Show how many people are on the waiting list.
     *
     * @return number of people on the waiting list
     */
    public int numberOfPeopleWaiting() {
        return this.waitingList.size();
    }

    /**
     * Show how many people there are in total, including guests.
     *
     * @return how many people there are in total
     */
    public int numberOfPeopleTotal() {
        return this.participantsList.size() + this.waitingList.size();
    }

    /**
     * Find all people based on a partial value search.
     *
     * @param match the match we are looking for
     * @return a list of people matching the criteria
     */
    
    public ArrayList<Guest> partialSearch(String match) {
        ArrayList<Guest> matches = new ArrayList<Guest>();
        
        match = match.toLowerCase();
       
        for (int i = 0; i < participantsList.size(); i++) {
        	if (participantsList.get(i).getFirstName().toLowerCase().contains(match) 
        			|| participantsList.get(i).getLastName().toLowerCase().contains(match)
        			|| participantsList.get(i).getEmail().toLowerCase().contains(match)
        			|| participantsList.get(i).getPhoneNumber().toLowerCase().contains(match)) {
        			matches.add(participantsList.get(i));
        		}		
        	
        }
        
        for (int i = 0; i < waitingList.size(); i++) {
        	if (waitingList.get(i).getFirstName().toLowerCase().contains(match) 
        			|| waitingList.get(i).getLastName().toLowerCase().contains(match)
        			|| waitingList.get(i).getEmail().toLowerCase().contains(match)
        			|| waitingList.get(i).getPhoneNumber().toLowerCase().contains(match)) {
        		matches.add(waitingList.get(i));
        	}
        }
        
        return matches;
    }

    @Override
    public String toString() {	
    	return participantsList.toString();
    }
	
}
