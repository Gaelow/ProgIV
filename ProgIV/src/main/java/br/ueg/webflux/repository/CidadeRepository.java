package br.ueg.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import br.ueg.webflux.document.Cidade;
import reactor.core.publisher.Mono;

@Repository
public interface CidadeRepository extends ReactiveMongoRepository<Cidade, String>{

	Mono<Cidade> findByEstado(String estado);

}
