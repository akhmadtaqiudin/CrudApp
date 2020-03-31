package com.id.taqi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable{

	private static final long serialVersionUID = 2161644442927156092L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name="first_name", nullable = false)
    private String firstname;
	
	@Column(name="last_name", nullable = false)
    private String lastname;
	
	@Column(name="address", nullable = false)
    private String address;
}
