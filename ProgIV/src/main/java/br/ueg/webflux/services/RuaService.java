package br.ueg.webflux.services;

import br.ueg.webflux.document.Rua;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RuaService{

	Flux<Rua> findAll();
	Mono<Rua> findById(String id);
	Mono<Rua> findByCidade(String cidade);
	Mono<Rua> save (Rua rua);
}
