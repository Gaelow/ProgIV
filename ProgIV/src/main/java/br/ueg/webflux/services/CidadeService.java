package br.ueg.webflux.services;

import br.ueg.webflux.document.Cidade;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CidadeService{

	Flux<Cidade> findAll();
	Mono<Cidade> findById(String id);
	Mono<Cidade> findByEstado(String estado);
	Mono<Cidade> save (Cidade cidade);
}
