package com.progra3.petstore.Dao;

import org.springframework.data.repository.CrudRepository;

import com.progra3.petstore.entities.Pet;


public interface Dao extends CrudRepository<Pet, Long>{

}
