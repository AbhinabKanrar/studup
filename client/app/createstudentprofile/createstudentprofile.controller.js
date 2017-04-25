'use strict';

angular
		.module('studupApp')
		.controller(
				'CreatestudentprofileCtrl',
				function($scope, $http) {
					$scope.firstname = '';
					$scope.midname = '';
					$scope.lastname = '';
					$scope.tagLine = '';
					$scope.collegeOrUniversity = '';
					$scope.department = '';
					$scope.highestDegree = '';
					$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
					$http({
						method : 'POST',
						url : '/api/university/v0.1/ListUniversity',
						data : null,
						cache : true
					}).then(function(res) {
						if (res.status == 200) {
							$scope.collegeOrUniversityArray = res.data;
						} else {
							console.log('error');
						}
					}, function(err) {
						console.log(err);
					});
					$('#collegeOrUniversity').focusout(function() {
						$http({
							method : 'POST',
							url : '/api/department/v0.1/ListDepartmentOfUniversity/'+$scope.formData.collegeOrUniversity,
							data : null,
							cache : true
						}).then(function(res) {
							if (res.status == 200) {
								$("#department").autocomplete({
									source : res.data,
									select: function( event, ui ) {
										$scope.formData.department = ui.item.value;
							            return false;
									}
								});
							} else {
								alert('error');
							}
						}, function(err) {
							alert(err);
						});
					});
					$('#department').focusout(function() {
						$http({
							method : 'POST',
							url : '/api/degree/v0.1/ListDegreeOfDepartment/'+$scope.formData.department,
							data : null,
							cache : true
						}).then(function(res) {
							if (res.status == 200) {
								$("#highestDegree").autocomplete({
									source : res.data,
									select: function( event, ui ) {
										$scope.formData.highestDegree = ui.item.value;
							            return false;
									}
								});
							} else {
								alert('error');
							}
						}, function(err) {
							alert(err);
						});
					});
					$http({
						method : 'POST',
						url : '/api/student/v0.1/ListStudentByEmailId',
						data : $(this).serialize(),
						cache : false
					})
							.then(
									function(res) {
										console.log(res.data);
										if (!res.data) {
											$("#collegeOrUniversity")
													.autocomplete({
														source : $scope.collegeOrUniversityArray,
														select : function(event,ui) {
															$scope.formData.collegeOrUniversity = ui.item.value;
															return false;
														}
													});
										} else {
											window.location.href = "/profile/student";
										}
									}, function(err) {
										alert(err);
									});
					$scope.createProfile = function() {
						$scope.$apply;
						$http({
							method : 'POST',
							url : '/api/student/v0.1/UpdateStudent',
							data : $.param($scope.formData),
							cache : false
						}).then(function(res) {
							if (res.status == 200) {
								window.location.href = "/profile/student";
							} else {
								alert('error');
							}
						}, function(err) {
							alert(err);
						});
					};
				});
