'use strict';

angular.module('studupApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ui.router'
])
  .config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider
      .otherwise('/');

    $locationProvider.html5Mode(true);
  });

jQuery('.stud-profiles li').on('click', function(){
    jQuery('.stud-profiles li').removeClass('stud-focus');
    jQuery(this).addClass('stud-focus');
});

jQuery('.stud-profile-circle li a').on('click', function(){
    jQuery('.stud-profile-circle li a').removeClass('stud-focus');
    jQuery(this).addClass('stud-focus');
});
/*
jQuery('.affix').affix({
  offset: {
    top: 10,
  }
})
$(".scroll_accomplishments_box").on("click", function( e ) {
    e.preventDefault();
    $("body, html").animate({ 
        scrollTop: $( $(this).attr('href') ).offset().top 
    }, 600);
    
});
*/
$(".scroll_education_box,.scroll_project_box,.scroll_personal_details_box,.scroll_accomplishments_box").click(function() {
    $('html,body').animate({
        scrollTop: $( $(this).attr('href') ).offset().top},
        'slow');
});
