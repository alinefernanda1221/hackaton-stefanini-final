import angular from 'angular';
import uirouter from 'angular-ui-router';

import DocumentoController from './documento.controller';

import documentoService from '../../servicos/documento.service';

export default angular.module('myApp.documento', [uirouter, documentoService])
  .controller('DocumentoController', DocumentoController)
  .name;

  