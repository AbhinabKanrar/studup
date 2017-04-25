'use strict';

angular.module('studupApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('createstudentprofile', {
        url: '/createstudentprofile',
        templateUrl: 'app/createstudentprofile/createstudentprofile.html',
        controller: 'CreatestudentprofileCtrl'
      });
  });