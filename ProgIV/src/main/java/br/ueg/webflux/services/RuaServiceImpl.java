package br.ueg.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.webflux.document.Rua;
import br.ueg.webflux.repository.RuaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RuaServiceImpl implements RuaService{

	@Autowired
	RuaRepository ruaRepository;
	
	public Flux<Rua> findAll() {
		return ruaRepository.findAll();
	}

	public Mono<Rua> findById(String id) {
		return ruaRepository.findById(id);
	}

	public Mono<Rua> save(Rua rua) {
		return ruaRepository.save(rua);
	}
	
	public Mono<Rua> findByCidade(String cidade) {
		return ruaRepository.findByCidade(cidade);
	}

}
