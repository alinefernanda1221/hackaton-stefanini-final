package com.stefanini.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.NegocioException;
import com.stefanini.projeto.model.Documento;
import com.stefanini.projeto.model.Pagina;
import com.stefanini.projeto.repository.PaginaRepository;

/**
 * @author aline
 *
 */
@Service
public class PaginaService {
	
	@Autowired
	private PaginaRepository repo;
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void deleteByDocumentoId(Documento documento) {
		repo.deleteByDocumento(documento);
	}
	
	public void save(Pagina pagina) throws NegocioException {
		if(pagina.getNome().length() > 20) {
			throw new NegocioException("Occoreu um erro: Nome da página não pode ser maior que 20 caracteres"
										+ " - pagina: " + pagina.getNome());
		}else {	repo.save(pagina);}
	}
}
