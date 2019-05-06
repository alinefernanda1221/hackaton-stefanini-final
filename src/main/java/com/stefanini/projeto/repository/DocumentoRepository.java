package com.stefanini.projeto.repository;
import java.util.List;

/**
 * @author Aline
 * Interface que permite execução de CRUD para a entidade Documento
 */
import org.springframework.data.repository.CrudRepository;

import com.stefanini.projeto.model.Documento;

public interface DocumentoRepository extends CrudRepository<Documento, Long> {
	
	List<Documento> findByNome(String nome);
	
}

