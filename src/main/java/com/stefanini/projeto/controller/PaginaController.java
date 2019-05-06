package com.stefanini.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.projeto.exception.NegocioException;
import com.stefanini.projeto.model.Pagina;
import com.stefanini.projeto.service.PaginaService;

/**
 * @author Aline Carvalho
 *
 */
@CrossOrigin /*Aceita requisicoes de enderecos locais*/
@RestController
@RequestMapping(value = "/pagina", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaginaController {

	@Autowired
	private PaginaService servico;
	/**
	 * Excluir pagina
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(name = "id") Long id){
		servico.deleteById(id.longValue());
	}

	/**
	 * Adicionar pagina
	 * @param pagina
	 * @throws NegocioException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void deleteById(@RequestBody Pagina pagina) throws NegocioException{
		servico.save(pagina);
	}
	
}
