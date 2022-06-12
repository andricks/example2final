package com.progra3.petstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progra3.petstore.Dao.Dao;
import com.progra3.petstore.Exeception.NotFoundException;
import com.progra3.petstore.entities.Pet;
@Service
public class PetImple implements PetService  {

	@Autowired
	private Dao dao;
	
	@Override
	public List<Pet> listAll() {
		return (List<Pet>) dao.findAll();
	}

	@Override
	public Pet findById(Long id) {
		if(dao.existsById(id)) {
			Optional<Pet> ob = dao.findById(id);
			return ob.get();
		}else throw new NotFoundException("La mascota indicada no se encontró en la base de datos");
	}

	
	
	@Override
	public Pet createPet(Pet pet) {
		dao.save(pet);
		return pet;
		
	}

	@Override
	public Pet updatePet(Long id, Pet pet) {
		if(dao.existsById(id)) {
			pet.setId(id);
			dao.save(pet);
		}else throw new NotFoundException("La mascota indicada no se encontró en la base de datos");
		return pet;
	}

	@Override
	public void deletePet(Long id) {
		if(dao.existsById(id)) dao.deleteById(id);
		else throw new NotFoundException("La mascota indicada a eliminar no se encontró en la base de datos");
	}
		
	}
