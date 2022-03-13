'use strict';

angular.module('myApp').controller('LoginController', ['$scope', 'LoginService', function($scope, LoginService) {
    var self = this;
    self.user={username:'',password:''};

    self.submit = submit;

    function submit() {
            if(self.user.username && self.user.password){
                userLogin(self.user);
            }else{

            }
    }

}]);