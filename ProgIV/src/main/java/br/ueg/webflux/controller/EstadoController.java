package br.ueg.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ueg.webflux.services.EstadoServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import br.ueg.webflux.document.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	EstadoServiceImpl estadoServiceImpl;
	
	@GetMapping()
	public Flux<Estado> getEstado(){
		return estadoServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Estado> getEstadoId(@PathVariable String id){
		return estadoServiceImpl.findById(id)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	@PostMapping
	public Mono<Estado> save(@RequestBody Estado estado){
		return estadoServiceImpl.save(estado);
	}
	
	public <T> Mono<T> monoResponseStatusNotFoundException(){
		return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
}
