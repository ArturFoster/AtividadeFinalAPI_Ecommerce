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

import br.org.serratec.ecommerce.entities.Pedido;
import br.org.serratec.ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		Pedido pedido = pedidoService.findById(id);
		
		if(pedido == null) {
			return new ResponseEntity<>(pedido, HttpStatus.NOT_FOUND);	
		}else {
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.CREATED);
	}
	
	@PutMapping 
	public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(pedidoService.update(pedido), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = pedidoService.delete(id);
		
		if(deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
