import angular from 'angular';
import uirouter from 'angular-ui-router';

import DocumentoEdicaoController from './edicao.controller';

import documentoService from '../../../servicos/documento.service';

export default angular.module('myApp.edicao', [uirouter, documentoService])
  .controller('DocumentoEdicaoController', DocumentoEdicaoController)
  .name;

  