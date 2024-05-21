package br.org.serratec.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.entities.Endereco;
import br.org.serratec.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
	
	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco update(Integer id, Endereco endereco) {
		Endereco entidade = enderecoRepository.getReferenceById(id);
		return enderecoRepository.save(entidade);
	}
	
	public Boolean delete(Integer id) {
		if(enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
			Endereco enderecoDeletado =  enderecoRepository.findById(id).orElse(null);
			
			if(enderecoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
