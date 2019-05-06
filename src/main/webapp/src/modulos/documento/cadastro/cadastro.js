import angular from 'angular';
import uirouter from 'angular-ui-router';

import DocumentoCadastroController from './cadastro.controller';

import documentoService from '../../../servicos/documento.service';

export default angular.module('myApp.cadastro', [uirouter, documentoService])
  .controller('DocumentoCadastroController', DocumentoCadastroController)
  .name;

  