package com.id.taqi.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.id.taqi.dao.GenericDao;
import com.id.taqi.dao.PersonDao;
import com.id.taqi.entity.Person;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, Integer> implements PersonService{

	private PersonDao personDao;

	public PersonServiceImpl() {
	}

	public PersonServiceImpl(@Qualifier("adminDaoImpl")GenericDao<Person, Integer> genericDao) {
		super(genericDao);
		this.personDao = (PersonDao) genericDao;
	}
	
}
