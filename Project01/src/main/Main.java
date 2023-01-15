package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.github.javafaker.Faker;

import structures.AggregateCab;
import structures.BaggyCab;
import structures.Cab;
import structures.Greyhound;
import structures.IndividualsCab;
import structures.People;
import structures.Person;

/**
 * This Main class tests the defined and implemented interfaces and classes.
 * @author Karim Sammouri
 */
public class Main {

	public static void main(String[] args) {
		People p1 = new Person("James");
		People p2 = new Person("Chen");
		System.out.println(p1);
		System.out.println(p2);

		Cab aggregate = new AggregateCab(3);
		System.out.println(aggregate.addPassenger(new Person("Paula")));
		System.out.println(aggregate.addPassenger(new Person("Vijay")));
		System.out.println(aggregate.addPassenger(new Person("Brad")));
		System.out.println(aggregate.addPassenger(new Person("Brady")));
		if (aggregate.isFull()) {
			System.out.println("Your implementation seems to work!");
		}
		
		Cab individuals = new IndividualsCab(3);
		System.out.println(individuals.addPassenger(new Person("Paula")));
		System.out.println(individuals.addPassenger(new Person("Vijay")));
		System.out.println(individuals.addPassenger(new Person("Brad")));
		System.out.println(individuals.addPassenger(new Person("Brady")));
		if (individuals.isFull()) {
			System.out.println("Your implementation seems to work!");
		}
		
		Cab greyhound = new Greyhound(3);
		System.out.println(greyhound.addPassenger(new Person("Paula")));
		System.out.println(greyhound.addPassenger(new Person("Vijay")));
		System.out.println(greyhound.addPassenger(new Person("Brad")));
		System.out.println(greyhound.addPassenger(new Person("Brady")));
		System.out.println(greyhound.addPassenger(new Person("Kong")));
		if (greyhound.isFull()) {
			System.out.println("Your implementation seems to work!");
		}
		
		Cab baggy = new BaggyCab(3);
		System.out.println(baggy.addPassenger(new Person("Paula")));
		System.out.println(baggy.addPassenger(new Person("Vijay")));
		System.out.println(baggy.addPassenger(new Person("Brad")));
		System.out.println(baggy.addPassenger(new Person("Brady")));
		System.out.println(baggy.addPassenger(new Person("Kong")));
		if (baggy.isFull()) {
			System.out.println("Your implementation seems to work!");
		}
		
		test1();
		test2();
		test3();
		test4();
	}
	
	// Testing various algorithms through code substitution:
	
	public static void test1() {
		List<People> p = new ArrayList<>();
		List<Cab> c = new ArrayList<>();
		Faker faker = new Faker();
		for (int i = 0; i < 50; i++) {
			p.add(new Person(faker.name().fullName()));
		}
		for (int i = 0; i < 10; i++) {
			c.add(i, new AggregateCab(5));
		}
		System.out.println(storePeople(p, c));
	}

	public static void test2() {
		List<People> p = new ArrayList<>();
		List<Cab> c = new ArrayList<>();
		Faker faker = new Faker();
		for (int i = 0; i < 50; i++) {
			p.add(new Person(faker.name().fullName()));
		}
		for (int i = 0; i < 4; i++) {
			c.add(i, new AggregateCab(3));
		}
		System.out.println(storePeople(p, c));
		System.out.println(p);
	}
	
	public static void test3() {
		Queue<People> p = new LinkedList<>();
		Queue<Cab> c = new LinkedList<>();
		Faker faker = new Faker();
		for (int i = 0; i < 50; i++) {
			p.add(new Person(faker.name().fullName()));
		}
		for (int i = 0; i < 10; i++) {
			c.add(new IndividualsCab(5));
		}
		System.out.println(fastStorePeople(p, c));
	}
	
	public static void test4() {
		Queue<People> p = new LinkedList<>();
		Queue<Cab> c = new LinkedList<>();
		Faker faker = new Faker();
		for (int i = 0; i < 50; i++) {
			p.add(new Person(faker.name().fullName()));
		}
		for (int i = 0; i < 4; i++) {
			c.add(new IndividualsCab(3));
		}
		System.out.println(fastStorePeople(p, c));
		System.out.println(p);
	}
	
	public static int storePeople(List<People> p,  List<Cab> c){
		while(!p.isEmpty()){ //while there are people needing cabs
			if(c.isEmpty()) return p.size(); //error, stranded people
			if(c.get(0).isFull()){ //if the current cab is full…
				c.remove(0); //…that cab is dealt with
				if(c.isEmpty()) return p.size(); //got more cabs?
			}
			//the current person can get into the current cab
			c.get(0).addPassenger(p.get(0)); 
			p.remove(0); //person dealt with
		}
		return 0;
	}
	
	public static int fastStorePeople(Queue<People> p,  Queue<Cab> c) {
		while(!p.isEmpty()){ //while there are people needing cabs
			if(c.isEmpty()) return p.size(); //error, stranded people
			if(c.peek().isFull()){ //if the current cab is full…
				c.remove(); //…that cab is dealt with
				if(c.isEmpty()) return p.size(); //got more cabs?
			}
			//the current person can get into the current cab
			c.peek().addPassenger(p.peek()); 
			p.remove(); //person dealt with
		}
		return 0;
	}
	
	public static int storeGroupPeople(Queue<People> p, Queue<Cab> c) {
		while (!c.isEmpty()) { //while there are cabs
			if (p.isEmpty()) { //exit if no one needs a cab
				return 0;
			}
			//if the next taxi has atleast enough room for the next group, take them in. If not, move for the next taxi.
			if (c.peek().getSize() >= count(p)) {
				for (int i = 0; i < count(p); i++) {
					c.peek().addPassenger(p.remove());
				}
			}
			c.remove();
		}
		// return stranded people
		return p.size();
	}
	
	public static int apocalypticCabs(Queue<People> p, Queue<Cab> c) {
		// flag represents whether person is infected.
		boolean flag = false;
		while(!p.isEmpty()){ //while there are people needing cabs
			if(c.isEmpty()) return p.size(); //error, stranded people
			if(c.peek().isFull()){ //if the current cab is full…
				c.remove(); //…that cab is dealt with
				if(c.isEmpty()) return p.size(); //got more cabs?
			}
			if (p.peek().hasCovid()) {
				flag = true;
			}
			//the current person can get into the current cab
			c.peek().addPassenger(p.peek()); 
			p.remove(); //person dealt with
			if (flag) {
				c.remove();
				continue;
			}
		}
		return 0;
	}
	
	// Counts the number of people in the first group, assuming people with the same group numbers are grouped together in the queue.
	public static int count(Queue<People> p) {
		int num = p.peek().getGroupNumber();
		int counter = -1;
		for (People x : p) {
			if (x.getGroupNumber() == num) {
				counter++;
			}
		}
		return counter;
	}
}
