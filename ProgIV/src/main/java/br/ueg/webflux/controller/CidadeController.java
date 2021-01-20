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

import br.ueg.webflux.services.CidadeServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import br.ueg.webflux.document.Cidade;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	CidadeServiceImpl cidadeServiceImpl;
	
	@GetMapping()
	public Flux<Cidade> getCidade(){
		return cidadeServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Cidade> getCidadeId(@PathVariable String id){
		return cidadeServiceImpl.findById(id)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	@GetMapping("/estado/{id}")
	public Mono<Cidade> getCidadeEstado(@PathVariable String estado){
		return cidadeServiceImpl.findByEstado(estado)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	@PostMapping
	public Mono<Cidade> save(@RequestBody Cidade cidade){
		return cidadeServiceImpl.save(cidade);
	}
	
	public <T> Mono<T> monoResponseStatusNotFoundException(){
		return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
}
