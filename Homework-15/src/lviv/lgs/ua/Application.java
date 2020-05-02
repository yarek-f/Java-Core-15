package lviv.lgs.ua;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int choise = scanner.nextInt();
			switch(choise){
			case 1: 
				ZooClub.addPerson();
				break;
				
			case 2:
				ZooClub.addAnimal();
				break;
				
			case 3: 
				ZooClub.deleteAnimal();
				break;
				
			case 4:
				ZooClub.deletePerson();
				break;
				
			case 5:
				ZooClub.deleteTheConcreteAnimal();
				break;
				
			case 6:
				ZooClub.displayZooClub();
				break;
				
			case 7:
				ZooClub.exit();
				break;
				
			}
						
		}
	
	}

}
