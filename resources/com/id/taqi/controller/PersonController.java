package com.id.taqi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.id.taqi.entity.Person;
import com.id.taqi.services.PersonService;

@RestController
@RequestMapping(value="/api")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getPerson() {
        return personService.getAll();
    }
	
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Map<String, Object> savePerson(@RequestBody Person p) {
		personService.saveOrUpdate(p);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Tersimpan");
        return m;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public Map<String, Object> updatePerson(@RequestBody Person p) {
		personService.saveOrUpdate(p);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data TerUbah");
        return m;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/person/{id_person}", method = RequestMethod.DELETE)
    public Map<String, Object> deletePerson(@PathVariable("id") Integer id_person) {
		personService.remove(personService.get(id_person));

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data TerHapus");
        return m;
    }
}
