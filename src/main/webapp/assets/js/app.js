/* ============================================================
 * File: app.js
 * Configure global module dependencies. Page specific modules
 * will be loaded on demand using ocLazyLoad
 * ============================================================ */

'use strict';

angular.module('app', [
    'ui.router',
    'ui.utils',
    'oc.lazyLoad'
])
.constant('domain','http://ec2-34-222-133-66.us-west-2.compute.amazonaws.com:8080/Rainutility/rain/app/')
.constant('getUserInfo','getUserInfo')
.constant('logout','logout')
.constant('login','login')
.constant('getAllUsers','getAllUsers')
.constant('getAllUsers','getAllUsers')
.constant('registerUser','registerUser')
 .service('urls',function(domain,getUserInfo,logout,login,getAllUsers,registerUser){ 
	 this.getUserInfo = domain+getUserInfo;
	 this.logout = domain+logout;
	 this.login=domain+login;
	 this.getAllUsers=domain+getAllUsers;
	 this.registerUser=domain+registerUser;
 })
;
 