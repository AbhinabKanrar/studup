'use strict';

angular
		.module('studupApp')
		.controller(
				'StudentprofileCtrl',
				function($scope, $http) {
					$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
//					$http.defaults.headers.common[$("#header").val()] = $("#token").val();
					$http({
						method : 'POST',
						url : '/api/student/v0.1/ListStudentByEmailId',
						data : $(this).serialize(),
						cache : false
					}).then(
							function(res) {
								console.log(res);
								console.log(res.data);
								if (!res.data) {
									window.location = "../../createstudentprofile";
								} else {
									console.log(res.data);
									var data = res.data;
									$scope.fullName = data.firstname + ' ' + data.midname + ' ' + data.lastname;
									$scope.emailId = data.emailId;
									$scope.tagLine = data.tagline;
									$scope.universityColleges = data.universityCollege;
//									for ( var universityCollege in data.universityCollege) {
//										console.log(universityCollege.univorcollegename);
//										console.log(universityCollege.univorcollegename);
//										console.log(universityCollege.univorcollegename);
//									}
								}
							}, function(err) {
								console.log(err);
							});
					});
