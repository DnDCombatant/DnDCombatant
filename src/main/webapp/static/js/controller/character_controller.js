'use strict';
 
angular.module('myApp').controller('CharacterController', ['$scope', 'CharacterService', function($scope, CharacterService) {
    var self = this;
    self.character={id:null,characterName:'',level:'',health:'',strength:'',dexterity:'',constitution:'',intelligence:'',
        wisdom:'',charisma:'',speed:'',characterClass:'',background:''};
    self.characters=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllCharacters();
 
    function fetchAllCharacters(){
        CharacterService.fetchAllCharacters()
            .then(
            function(d) {
                self.characters = d;
            },
            function(errResponse){
                console.error('Error while fetching Characters');
            }
        );
    }
 
    function createCharacter(character){
        CharacterService.createCharacter(character)
            .then(
            fetchAllCharacters,
            function(errResponse){
                console.error('Error while creating Character');
            }
        );
    }
 
    function updateCharacter(character, id){
        CharacterService.updateCharacter(character, id)
            .then(
            fetchAllCharacters,
            function(errResponse){
                console.error('Error while updating Character');
            }
        );
    }
 
    function deleteCharacter(id){
        CharacterService.deleteCharacter(id)
            .then(
            fetchAllCharacters,
            function(errResponse){
                console.error('Error while deleting Character');
            }
        );
    }
 
    function submit() {
        if(self.character.id===null){
            console.log('Saving New Character', self.character);
            createCharacter(self.character);
        }else{
            updateCharacter(self.character, self.character.id);
            console.log('Character updated with id ', self.character.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.characters.length; i++){
            if(self.characters[i].id === id) {
                self.character = angular.copy(self.characters[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.character.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteCharacter(id);
    }
 
 
    function reset(){
        self.character={id:null,characterName:'',level:'',health:'',strength:'',dexterity:'',constitution:'',
            intelligence:'',wisdom:'',charisma:'',speed:'',characterClass:'',background:''};
        $scope.myForm.$setPristine();
    }
 
}]);