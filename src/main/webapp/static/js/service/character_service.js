'use strict';
 
angular.module('myApp').factory('CharacterService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/DnDCombatant/character/';

    var factory = {
        fetchAllCharacters: fetchAllCharacters,
        createCharacter: createCharacter,
        updateCharacter:updateCharacter,
        deleteCharacter:deleteCharacter
    };

    return factory;

    function fetchAllCharacters() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Characters');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createCharacter(character) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, character)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Character');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateCharacter(character, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, character)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Character');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteCharacter(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Character');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);