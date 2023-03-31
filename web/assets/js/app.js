
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
.constant('domain','http://localhost:8080/Rainutility/rain/app/')
.constant('getUserInfo','getUserInfo')
.constant('logout','logout')
.constant('login','login')
.constant('getAllUsers','getAllUsers')
 .service('urls',function(domain,getUserInfo,logout,login,getAllUsers){ 
	 this.getUserInfo = domain+getUserInfo;
	 this.logout = domain+logout;
	 this.login=domain+login;
	 this.getAllUsers=domain+getAllUsers;
 })
;
 