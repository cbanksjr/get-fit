package com.exercisegenerator.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exercisegenerator.backend.models.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long>{
}
