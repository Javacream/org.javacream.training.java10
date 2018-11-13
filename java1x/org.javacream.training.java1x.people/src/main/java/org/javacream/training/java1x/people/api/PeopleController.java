package org.javacream.training.java1x.people.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.javacream.training.java1x.people.impl.MapPeopleController;

public interface PeopleController {
    
    static PeopleController create() {
	return new MapPeopleController();
    }
    void save(Person person);
    void update(Person person);
    Optional<Person> findById(Long id);
    void deleteById(Long id);
    Collection<Person> findAll();
    default List<Person> findAllAscending(){
	return findSorted(SortCriterium.ID_ASCENDING);
    }
    
    default List<Person> findAllDescending(){
	return findSorted(SortCriterium.ID_DESCENDING);
	
    }
    
    private List<Person> findSorted(SortCriterium sortCriterium){
	var peopleList = new ArrayList<>(findAll());
	peopleList.sort(sortCriterium.getAlgorithm());
	return peopleList;
    }
    
    }
    
    enum SortCriterium{
	ID_ASCENDING((p1, p2) -> p1.getId().compareTo(p2.getId())) , ID_DESCENDING((p1, p2) -> p2.getId().compareTo(p1.getId()));
	private Comparator <Person> algorithm;
	public Comparator <Person> getAlgorithm() {
	    return algorithm;
	}
	private SortCriterium(Comparator<Person> algorithm) {
	    this.algorithm = algorithm;
	    
    }
}
