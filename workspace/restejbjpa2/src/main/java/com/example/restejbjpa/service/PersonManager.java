package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Car;
import com.example.restejbjpa.domain.Dog;
import com.example.restejbjpa.domain.Person;

@Stateless
public class PersonManager {	
	
	@PersistenceContext
	EntityManager em;
	
	public Person getPerson(Long id){
		return em.find(Person.class, id);
	}
	
	public Car getCar(Long id){
		return em.find(Car.class, id);
	}
	
	public Car updateCar(Car car){
		return em.merge(car);
	}

	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons(){
		return em.createNamedQuery("person.getAll").getResultList();
	}
	
	public void addPerson(Person person){
		em.persist(person);		
	}
	
	public void clearPersons(){
		em.createNamedQuery("person.deleteAll").executeUpdate();
	}

	public List<Dog> getDogsOfPerson(Long id) {
//		Person person = em.find(Person.class, id);

//		List<Dog> dogs = person.getDogs();

		//for lazy loading
//		System.out.println(dogs.size());

        List<Dog> dogs = em.createNamedQuery("person.getDogsOfPerson").setParameter("pId", id).getResultList();

		return dogs;
	}

}
