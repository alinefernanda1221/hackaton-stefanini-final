import angular from 'angular';

class DocumentoService {

    constructor($http) {
        this.$http = $http;
        const apiBase = "http://localhost:8080";
        this.apiBase = apiBase
        this.montaUrl = function (apiBase, endpoint) { return apiBase + endpoint; };
    }
    
    get(endpoint) { //ok
    	return this.$http.get( this.montaUrl(this.apiBase, endpoint) );
    }   

    getByParam(paramPesquisa, endpoint, param) { //ok
    	return this.$http.get( this.montaUrl(this.apiBase, endpoint) + param + paramPesquisa );
    }    

    post(dados, endpoint){ //ok
    		return this.$http.post(this.montaUrl(this.apiBase, endpoint), dados);    		
    }

    postPagina(dados){		
    	return this.$http.post('http://localhost:8080/pagina/', dados);    		
    }
    
    
    deleteById(id, endpoint){//ok
    	return this.$http.delete(this.montaUrl(this.apiBase, endpoint) + '/' + id);
    }
    
    patch(dados, endpoint){
    	return this.$http.patch( this.montaUrl(this.apiBase, endpoint), dados );    		
    }
}

export default angular.module('services.documento-service', [])
.service('documentoService', DocumentoService)
.name;
