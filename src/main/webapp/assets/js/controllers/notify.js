angular.module('app')
    .controller('notifyCtrl', ['$scope', '$http', function($scope, $http) {
        $scope.notificationData=[
                                 {
                                	 sub:"notification one",
                                	 time:"few sec ago",
                                	 detail:"more details about the notification",
                                	
                                	 notify_class:"notification-item unread clearfix",
                                	 text_class:"text-complete pull-left"
        		
                                 },
                                 {
                                	 sub:"notification two",
                                	 time:"few sec ago",
                                	 detail:"more details about the notification",
                                	
                                	 notify_class:"notification-item clearfix",
                                	 text_class:"text-danger pull-left"
        		
                                 }
                                 
                                 ]
    }])
    
     .controller('rainUserController', ['$scope', '$http','urls', function($scope, $http,urls) {
       
    	 $scope.userInfo={};
    	 $scope.userInfo.img="";
        
      $http.get(urls.getUserInfo).success(function(data){
    	  
    	  $scope.userInfo=data;
    	  
    	  if (typeof  $scope.userInfo.code != 'undefined'){if( $scope.userInfo.code==8001)window.location.href="#access/login";}
    	  
    	  if (typeof  $scope.userInfo.firstName != 'undefined')
    	  if($scope.userInfo.firstName.length<=0)
          	window.location.href="#access/login";
      });
      
      $scope.logout=function()
      {
    	  $http.get(urls.logout).success(function(data){
        	  
    		  window.location.href="#access/login";
      
          });
      }
        
       
    }])
    