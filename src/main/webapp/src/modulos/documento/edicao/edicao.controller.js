import { inherit } from "@uirouter/core";

export default class DocumentoEdicaoController {

  constructor(documentoService, $stateParams) {
    var vm = this;
    vm.documento = $stateParams.documento; //Recebe documento do state anterior :)
    vm.salvarEdicao = null;
    vm.documentoEditado = null;
    vm.excluirPagina = null;
    vm.voltar = null;
    vm.adicionaPagina = null;
    init();

    
    function init(){
    vm.salvarEdicao = salvarEdicao;
    vm.documentoEditado = vm.documento;
    vm.excluirPagina = excluirPagina;
    vm.voltar = voltar;
    vm.adicionaPagina = adicionaPagina;
    
     function salvarEdicao(documento) {
    	 console.log(documento);
    	 documentoService.patch(documento)
    	 .then(function (resp) {
    		 alert(resp.data.message);
			console.log(resp);
		}).catch(function (error) {
			alert(resp.error.message);
			console.log(error);
		});
     }

     function excluirPagina(pagina) { //Remove pagina do Array
    	 var index = vm.documento.paginas.indexOf(pagina);
    	 vm.documento.paginas.splice(index, 1);
    	 documentoService.deletePaginaById(pagina.id)
    	 .then(function (resp) {
    		 console.log(resp);
    	 }).catch(function (error) {
    		 console.log(error);
    	 });
     }
     
     function voltar() {
    	  window.history.back();
     };
     
     function adicionaPagina(pagina) {
 		vm.documentoEditado.paginas.push(angular.copy(pagina));    	 
	}
     
  }
 }
}//Fim classe
DocumentoEdicaoController.$inject = ['documentoService', '$stateParams'];
