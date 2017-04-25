'use strict';

describe('Controller: CreatestudentprofileCtrl', function () {

  // load the controller's module
  beforeEach(module('studupApp'));

  var CreatestudentprofileCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CreatestudentprofileCtrl = $controller('CreatestudentprofileCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
