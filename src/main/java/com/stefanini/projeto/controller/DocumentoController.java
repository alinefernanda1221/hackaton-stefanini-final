package com.stefanini.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.projeto.exception.NegocioException;
import com.stefanini.projeto.model.Documento;
import com.stefanini.projeto.model.Pagina;
import com.stefanini.projeto.service.DocumentoService;
import com.stefanini.projeto.service.PaginaService;

/**
 * @author Aline Carvalho
 *
 */
@CrossOrigin /*Aceita requisicoes de enderecos locais*/
@RestController
@RequestMapping(value = "/documento", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentoController {
	
	@Autowired
	private DocumentoService servico;

	/**
	 * Buscar Todos
	 * @return List<Documento>
	 */
	@RequestMapping(method = RequestMethod.GET)
		public @ResponseBody List<Documento> findAll(){
			return servico.findAll();
		}

	/**
	 * Buscar por Nome
	 * @param nome
	 * @return Documento / List<Documento>
	 */
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<Documento> findByNome(@PathVariable(value = "nome") String nome){
		return servico.findByNome(nome);
	}

	/**
	 * Buscar por ID
	 * @param id
	 * @return Documento
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Documento> findById(@PathVariable(name = "id") Long id){
		return servico.findByID(id);
	}
	
	/**
	 * Excluir documento
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(name = "id") Long id){
		servico.deleteById(id);
	}

	/**
	 * Criar documento
	 * @param documento
	 * @throws NegocioException 
	 */
	@RequestMapping(method = RequestMethod.POST)
		public void save(@RequestBody Documento documento) throws NegocioException {
			servico.save(documento);
	}

	/**
	 * Alterar documento
	 * @param documento
	 * @throws NegocioException 
	 */
	@RequestMapping(method = RequestMethod.PATCH)
	public void update(@RequestBody Documento documento) throws NegocioException {
		servico.update(documento);
	}

}
