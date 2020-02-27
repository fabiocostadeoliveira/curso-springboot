package com.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria nao encontrada - id: " + id));
		
	}

}
