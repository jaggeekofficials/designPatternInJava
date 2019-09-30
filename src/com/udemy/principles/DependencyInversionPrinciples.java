package com.udemy.principles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;


public class DependencyInversionPrinciples {

	//1 high level modules should not depend on low level modules.
	// both should depend on abstraction
	//2 Abstractions should not depend on details.
	//details should not depend on abstraction
	
	
	public static void main(String[] args) {

		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");
		
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);
		new Research(relationships);
	}
    // here the problem is in this style is that we are exposing an internal storage implementation of relations
	// as a public getter.
}
enum Relationship{
	PARENT, CHILD, SIBLING
}

class Person {
	
	public String name;

	public Person(String name) {
		this.name = name;
	}
	
}

class Relationships implements RelationshipBrowser { //low level  module follows single responsibilities
	
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}

	/*
	 * public void setRelations(List<Triplet<Person, Relationship, Person>>
	 * relations) { this.relations = relations; }
	 */

	public void addParentAndChild(Person parent, Person child) {
		
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}

	@Override
	public List<Person> findAllChildrenOf(String name) {
		return relations.stream().filter(x -> Objects.equals(x.getValue0().name, name)
				&& x.getValue1() == Relationship.PARENT)
				.map(Triplet :: getValue2)
				.collect(Collectors.toList());
	}
}

class Research { // high-level module  becos it allows us to operations on some low level module
	// according to Dependency inverison principle high level module should not depend on low level module.
	
	/*
	 * public Research(Relationships relationships) { // constructor here takes the
	 * dependency from low level module
	 * 
	 * List<Triplet<Person, Relationship, Person>> relations =
	 * relationships.getRelations(); relations.stream().filter(x ->
	 * x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
	 * .forEach(ch -> System.out.println(
	 * "John has a child called "+ch.getValue2().name)); }
	 */
	// commented in order to achieve the principle
	public Research(RelationshipBrowser browser) {
		
		List<Person> children = browser.findAllChildrenOf("John");
		
		
		for(Person child : children) {
			System.out.println("John has a child called "+child.name);
		}
	}
	
}

// to achieve principle

interface RelationshipBrowser{
	
	List<Person> findAllChildrenOf(String name);
}