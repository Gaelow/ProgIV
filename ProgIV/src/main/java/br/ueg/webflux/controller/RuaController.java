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

import br.ueg.webflux.services.RuaServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import br.ueg.webflux.document.Cidade;
import br.ueg.webflux.document.Rua;

@RestController
@RequestMapping("/ruas")
public class RuaController {

	@Autowired
	RuaServiceImpl ruaServiceImpl;
	
	@GetMapping()
	public Flux<Rua> getRua(){
		return ruaServiceImpl.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Rua> getRuaId(@PathVariable String id){
		return ruaServiceImpl.findById(id)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	@GetMapping("/cidade/{id}")
	public Mono<Rua> getRuaCidade(@PathVariable String cidade){
		return ruaServiceImpl.findByCidade(cidade)
				.switchIfEmpty(monoResponseStatusNotFoundException());
	}
	
	@PostMapping
	public Mono<Rua> save(@RequestBody Rua rua){
		return ruaServiceImpl.save(rua);
	}
	
	public <T> Mono<T> monoResponseStatusNotFoundException(){
		return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
}
