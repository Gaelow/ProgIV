package br.ueg.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import br.ueg.webflux.document.Estado;

@Repository
public interface EstadoRepository extends ReactiveMongoRepository<Estado, String>{

}
