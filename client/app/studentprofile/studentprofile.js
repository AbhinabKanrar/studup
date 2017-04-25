'use strict';

angular.module('studupApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('studentprofile', {
        url: '/profile/student',
        templateUrl: 'app/studentprofile/studentprofile.html',
        controller: 'StudentprofileCtrl'
      });
  });