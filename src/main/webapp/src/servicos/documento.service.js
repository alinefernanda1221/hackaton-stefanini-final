import angular from 'angular';

class DocumentoService {

    constructor($http) {
        this.$http = $http;
        const apiBase = "http://localhost:8080";
        this.path =  apiBase + "/documento";
    }
    
    get() {
    	return this.$http.get(this.path);
    }   

    getByName(paramPesquisa) {
    	return this.$http.get(this.path + '/nome/' + paramPesquisa);
    }    

    post(dados){
    		return this.$http.post(this.path, dados);    		
    }

    postPagina(dados){		
    	return this.$http.post('http://localhost:8080/pagina/', dados);    		
    }
    
    
    deleteById(id){
    	return this.$http.delete(this.path + '/' + id);
    }

    deletePaginaById(id){
    	return this.$http.delete('http://localhost:8080/pagina/' + id);
    }
    
    patch(dados){
    	return this.$http.patch(this.path, dados);    		
    }
}

export default angular.module('services.documento-service', [])
.service('documentoService', DocumentoService)
.name;


//    post(dados){
//    	var config = {
//    			headers : { 'Content-Type' : 'application/json;'},
//		    	data : { dados },
//		    	paramSerializer: '$httpParamSerializerJQLike'
//    	};
//    	config.data = dados;

//    	var data = dados
//    	console.log(data);
//    	return this.$http.post(this.path, dados, config);
//    	return this.$http.post(this.path, dados);
//    }