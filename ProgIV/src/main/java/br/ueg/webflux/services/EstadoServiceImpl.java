package br.ueg.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.webflux.document.Estado;
import br.ueg.webflux.repository.EstadoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	EstadoRepository estadoRepository;
	
	public Flux<Estado> findAll() {
		return estadoRepository.findAll();
	}

	public Mono<Estado> findById(String id) {
		return estadoRepository.findById(id);
	}

	public Mono<Estado> save(Estado estado) {
		return estadoRepository.save(estado);
	}

}
