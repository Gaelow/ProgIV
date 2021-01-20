package br.ueg.webflux.services;

import br.ueg.webflux.document.Estado;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EstadoService{

	Flux<Estado> findAll();
	Mono<Estado> findById(String id);
	Mono<Estado> save (Estado estado);
}
