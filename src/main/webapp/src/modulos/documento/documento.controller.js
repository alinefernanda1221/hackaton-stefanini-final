import { inherit } from "@uirouter/core";

export default class DocumentoController {

  constructor(documentoService, $state) {
    var vm = this;
    vm.documentos = {};
    vm.resp = null;
    vm.buscarTodos = null;
    vm.pesquisa = null;
    vm.excluir = null;
    /*Cadastro*/
    vm.cadastrarDocumento = null;
    vm.maxSize = 20;
    vm.cadastrarPagina = null;
    vm.editar = null;
    vm.voltar = null;
    
    init();
    
    function init(){ 
    vm.editar = editarPagina;
    vm.voltar = voltar;

     vm.buscarTodos = function (){
    	 documentoService.get()
    	   .then(function response(resp){
    		   vm.documentos = resp.data;
    	 }).catch(function (error) {
    		 console.log(error);     		  
    	 });	
     } 

     vm.buscarPorNome = function (){
    	 documentoService.getByName(vm.pesquisa)
    	 .then(function response(resp){
    		 vm.documentos = resp.data;
    		 console.log(resp);     		  
    	 }).catch(function (error) {
    		 console.log(error);     		  
    	 });	
     }
     
     vm.excluir = function (id) {
		documentoService.deleteById(id)
		.then(function response(resp) {
			console.log(resp);
		}).catch(function error(error) {
			console.log(error);
		});
	}

     function editarPagina(doc) { //Vai para o router página passando o doc como param de edicao :)
    	 $state.go('edicao', {
    		documento : doc 
    	 });
     }

     function voltar() { window.history.back(); };     
    
  }
 }
}//Fim classe
DocumentoController.$inject = ['documentoService', '$state'];
