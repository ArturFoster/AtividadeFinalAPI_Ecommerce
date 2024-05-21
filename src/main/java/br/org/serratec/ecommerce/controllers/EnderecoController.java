package br.org.serratec.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ecommerce.entities.Endereco;
import br.org.serratec.ecommerce.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		return new ResponseEntity<>(enderecoService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id){
		Endereco endereco = enderecoService.findById(id);
		if (endereco == null)
			return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(endereco, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.save(endereco), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco) {
		endereco = enderecoService.update(id,endereco);
		return new ResponseEntity<>(endereco,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = enderecoService.delete(id);
		if (deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
