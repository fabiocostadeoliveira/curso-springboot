package com.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Produto;
import com.cursomc.dto.CategoriaDTO;
import com.cursomc.dto.ProdutoDTO;
import com.cursomc.services.ProdutoService;
import com.cursomc.utils.StringUtil;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		
		Produto produto = service.find(id);
		return ResponseEntity.ok().body(produto);
	}
	
/*
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue = "") String nome,
			@RequestParam(value="categorias", defaultValue = "") String categorias,
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue =  "ASC") String direction){
		
		List<Integer> ids = StringUtil.decodeToIntList(categorias);
		
		Page<Produto> list = service.search(page, linesPerPage, orderBy, direction);
		
		Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));	
		return ResponseEntity.ok().body(listDTO);
		
		
	}
*/
	
	
}
