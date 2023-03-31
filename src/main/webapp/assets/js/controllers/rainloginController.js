angular.module('app')

    .controller('rainloginController', ['$scope', '$http','urls', function($scope, $http,urls) {
    	
    	if($('#datepicker-component2').length!=0){
    	$('#datepicker-component2').datepicker({
		    format: 'dd-mm-yyyy'
		 });
    	}
      
    	$scope.accounts = [
            {value : "Demo", ref : "1"},
            {value : "Basic", ref : "2"},
            {value : "Standard", ref : "3"},
            {value : "Pro", ref : "4"},
            {value : "Unlimited", ref : "5"}
        ];
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
    	
    	$http.post("http://ec2-54-212-201-118.us-west-2.compute.amazonaws.com:8080/Rainutility/rain/app/login",loginjson).success(function(data){
    		$http.get("http://ec2-54-212-201-118.us-west-2.compute.amazonaws.com:8080/Rainutility/rain/app/getUserInfo").success(function(info){
    			console.log(info);
    		})
        	});
    	}
    	
    	
    	$scope.registerUser=function(){
    		$scope.subiderror=false;
    		$scope.gendererror=false;
    		if($scope.user.subscriptionType==undefined || $scope.user.subscriptionType==''){
    			$scope.subiderror=true;
    		}
    		if($scope.user.gender==undefined || $scope.user.subscriptionType==''){
    			$scope.gendererror=true;
    		}
    		else{
    			
    			$http.post(urls.registerUser,$scope.user).success(function(data){
    				
    				console.log(data);
    	    		
//    	    		$scope.loginResponse=data;
//    	    		if($scope.loginResponse.code=="101")
//    				{$scope.invalidMsg=$scope.loginResponse.message}
    	    		
//    	    		if($scope.loginResponse.code==3000)
//    	    			{$scope.invalidMsg="";window.location.href="#access/login";}
    	    	});
    			
    		}
        	console.log($scope.user);
        	
        	}
    	
    }])