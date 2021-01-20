package br.ueg.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ueg.webflux.document.Cidade;
import br.ueg.webflux.repository.CidadeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CidadeServiceImpl implements CidadeService{

	@Autowired
	CidadeRepository cidadeRepository;
	
	public Flux<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	public Mono<Cidade> findById(String id) {
		return cidadeRepository.findById(id);
	}

	public Mono<Cidade> save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public Mono<Cidade> findByEstado(String estado) {
		return cidadeRepository.findByEstado(estado);
	}
}
