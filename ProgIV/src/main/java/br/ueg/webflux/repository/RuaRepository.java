package br.ueg.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import br.ueg.webflux.document.Rua;
import reactor.core.publisher.Mono;

@Repository
public interface RuaRepository extends ReactiveMongoRepository<Rua, String>{

	Mono<Rua> findByCidade(String cidade);

}
