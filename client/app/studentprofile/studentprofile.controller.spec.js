'use strict';

describe('Controller: StudentprofileCtrl', function () {

  // load the controller's module
  beforeEach(module('studupApp'));

  var StudentprofileCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StudentprofileCtrl = $controller('StudentprofileCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
