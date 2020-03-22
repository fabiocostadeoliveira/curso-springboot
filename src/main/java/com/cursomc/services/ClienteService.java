package com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursomc.domain.Cidade;
import com.cursomc.domain.Cliente;
import com.cursomc.domain.Endereco;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.dto.ClienteDTO;
import com.cursomc.dto.ClienteNewDTO;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.repositories.EnderecoRepository;
import com.cursomc.services.exceptions.IntegrityViolationException;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Cliente find(Integer id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente nao encontrada - id: " + id));
		
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		
		enderecoRepository.saveAll(obj.getEnderecos());
		
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		
		Cliente newObj = find(obj.getId());
		
		updateData(newObj, obj);
		
		return clienteRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		
		find(id);
		
		try {
			clienteRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException dv) {
			
			throw new IntegrityViolationException("Nao é possivel deletar um cliente porque existem vinculos com outros registros.");
			
		}
		
	}

	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		
 		return clienteRepository.findAll(pageRequest);
		
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {		
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		
		Cliente cli = new Cliente(	objDTO.getId(),
									objDTO.getNome(),
									objDTO.getEmail(),
									objDTO.getCpfOuCnpj(),
									TipoCliente.toEnum(objDTO.getTipo()));
		
		Cidade cid = new Cidade(objDTO.getCidade().getId(), null, null);
		
		Endereco end = new Endereco(objDTO.getEndereco().getId(),
								 	objDTO.getEndereco().getLogradouro(),
								  	objDTO.getEndereco().getNumero(),
								  	objDTO.getEndereco().getComplemento(),
								  	objDTO.getEndereco().getBairro(),
								  	objDTO.getEndereco().getCep(),
								  	cli,
								  	cid);
		
		cli.getEnderecos().add(end);
		
		objDTO.getTelefones().forEach(t -> cli.getTelefones().add(t));
		
		return cli;
	}
	
	// TODO Fazer metodo generico para fazer atualizacao dos dados
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}


}
