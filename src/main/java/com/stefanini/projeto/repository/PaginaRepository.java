package com.stefanini.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.stefanini.projeto.model.Documento;
import com.stefanini.projeto.model.Pagina;

public interface PaginaRepository extends CrudRepository<Pagina, Long>{
	
	@Transactional
	void deleteByDocumento(Documento documento);
}
