package com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.exceptions.IntegrityViolationException;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria nao encontrada - id: " + id));
		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		
		// TODO - Verificar trecho abaixo para ver se nao vai gerar erro
		return categoriaRepository.save(obj);
	}

	public Categoria update(Categoria obj) {
		
		find(obj.getId());
		
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		
		find(id);
		
		try {
			categoriaRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException dive) {
			throw new IntegrityViolationException("Nao é possivel deletar uma categoria que contem produtos.");
		}
		
	}

}
