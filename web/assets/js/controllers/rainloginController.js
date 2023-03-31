angular.module('app')

    .controller('rainloginController', ['$scope', '$http','urls', function($scope, $http,urls) {
      
    	$scope.processLogin=function(){
    		
    	var loginjson={};
    	loginjson.userName=$scope.user.username;
    	loginjson.password=$scope.user.password;
    	loginjson.appid=$scope.user.appid;
    	
    
    	$http.post(urls.login,loginjson).success(function(data){
    		
    		$scope.loginResponse=data;
    		if($scope.loginResponse.code=="101")
			{$scope.invalidMsg=$scope.loginResponse.message}
    		
    		if($scope.loginResponse.code==3000)
    			{$scope.invalidMsg="";window.location.href="#app/dashboard";}
    	});
    	}
    	
    
    	
    }])