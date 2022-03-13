'use strict';

angular.module('myApp').factory('LoginService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/DnDCombatant/login/';

    var factory = {
        userLogin: userLogin
    };

    return factory;

    function userLogin(user) {

    }

}]);