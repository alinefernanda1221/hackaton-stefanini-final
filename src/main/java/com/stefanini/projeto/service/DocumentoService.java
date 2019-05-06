package com.stefanini.projeto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.NegocioException;
import com.stefanini.projeto.model.Documento;
import com.stefanini.projeto.model.Pagina;
import com.stefanini.projeto.repository.DocumentoRepository;
import com.stefanini.projeto.repository.PaginaRepository;

/**
 * @author aline
 *
 */
@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository repo;

	@Autowired
	private PaginaService servPagina;
	
	
	public List<Documento> findAll() {
		return (List<Documento>) repo.findAll();
	}
	
	public List<Documento> findByNome(String nome) {
		return (List<Documento>) repo.findByNome(nome);
	}
	
	/**
	 * Implementa as regras de validacao da entidade Pai e filhas
	 */	
	public void save(Documento documento) throws NegocioException {
		validaDocumento(documento);
		validaPagina(documento); /*Salva se tudo ok!*/
	}

	/**
	 * @param documento
	 * @throws NegocioException
	 */
	private void validaPagina(Documento documento) throws NegocioException {
		/*Validações páginas*/
		if(documento.getPaginas() != null && documento.getPaginas().size() > 0) {
			if(documento.getPaginas().size() > 5) {	throw new NegocioException("Ocorreu um erro: "
													+ "Quantidade máxima de páginas(5), acima do permitido"); }
			else {
				for(Pagina pagina : documento.getPaginas()) {
					if(pagina.getNome().length() > 20) {
						throw new NegocioException("Occoreu um erro: Nome da página não pode ser mair que 20 caracteres"
													+ " - pagina: " + pagina.getNome());
					}else {	pagina.setDocumento(documento);	}
				}
				repo.save(documento);			
			}
		}
		if(documento.getPaginas() == null || documento.getPaginas().size() == 0) {	repo.save(documento); } 
//		}else {	repo.save(documento); }
	}
	/**
	 * @param documento
	 * @throws NegocioException
	 */
	private void validaDocumento(Documento documento) throws NegocioException {
		/*Validação nome documento*/
		if(documento.getNome().length() > 20) {
			throw new NegocioException("Ocorreu um erro: Nome do documento acima do permitido");
		}else {
			ArrayList<Documento> cadastrados = (ArrayList<Documento>) repo.findAll();
			for(Documento doc : cadastrados) {
				if(doc.getNome().toUpperCase().equals(documento.getNome().toUpperCase())
						&& doc.getId() != documento.getId()) {
					throw new NegocioException("Ocorreu um erro: Já foi cadastrado um documento com este nome");
				}
			}		
		}
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
		servPagina.deleteByDocumentoId(new Documento(id));
	}
	
	public Optional<Documento> findByID(Long id) {
		return repo.findById(id);
	}
	
	public void update(Documento documento) throws NegocioException {
		save(documento);
	}
}
