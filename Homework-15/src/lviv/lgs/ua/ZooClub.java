package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ZooClub {
	static Map<Person, List<Animal>> map = new HashMap<>();

	public Map<Person, List<Animal>> getMap() {
		return map;
	}

	public void setMap(Map<Person, List<Animal>> map) {
		this.map = map;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZooClub other = (ZooClub) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}

	public static void addPerson() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter name Person: ");
		String inputPersonName = s.next();
		System.out.println("Enter age of Person: ");
		int inputPersonAge = s.nextInt();
		map.put(new Person(inputPersonName, inputPersonAge), new ArrayList<>());

		System.out.println(map);
	}

	public static void addAnimal() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the name of the person who wanna own an animal: ");
		String name = s.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				System.out.println("Enter animal type: ");
				String inputAnimalType = s.next();
				System.out.println("Enter name of animal: ");
				String inputAnimalName = s.next();

				List<Animal> value = next.getValue();
				value.add(new Animal(inputAnimalType, inputAnimalName));
				next.setValue(value);
			}
		}
		System.out.println(map);
	}

	public static void deleteAnimal() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a name of the person who owns an animal: ");
		String name = s.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equals(name)) {
				List<Animal> animals = next.getValue();
				System.out.println("Enter a name of an animal you wanna remove:");
				String nameAnimal = s.next();
				Iterator<Animal> iterator3 = animals.iterator();
				while(iterator3.hasNext()) {
					Animal next2 = iterator3.next();
					if(next2.getName().equalsIgnoreCase(nameAnimal)) {
						iterator3.remove();
					}
				}
			}
		}

		System.out.println(map);
	}
	
	public static void deletePerson() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a name of the person you wanna remove from the ZooClub: ");
		String name = s.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			if (next.getKey().getName().equalsIgnoreCase(name)) {
				iterator.remove();
			} 
		}
		System.out.println(map);
	}
	
	public static void deleteTheConcreteAnimal() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter animal type you wanna remove from the ZooClub: ");
		String type = s.next();
		Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Person, List<Animal>> next = iterator.next();
			List<Animal> animals = next.getValue();
			Iterator<Animal> iterator3 = animals.iterator();
			while(iterator3.hasNext()) {
				Animal next2 = iterator3.next();
				if(next2.getAnimalType().equalsIgnoreCase(type)) {
					iterator3.remove();
				} 
			}
		}
		System.out.println(map);
	}
	
	public static void displayZooClub() {
		Set<Entry<Person, List<Animal>>> entrySet = map.entrySet(); 

		for (Entry<Person, List<Animal>> entry : entrySet) {
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
	}
	
	public static void exit() {
		System.out.println("exit...");
		System.exit(0);
	}


}
