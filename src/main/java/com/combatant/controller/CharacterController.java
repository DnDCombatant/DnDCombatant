package com.combatant.controller;

import java.util.List;

import com.combatant.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.combatant.model.Character;

@RestController
public class CharacterController {

	@Autowired
	CharacterService characterService;  //Service which will do all data retrieval/manipulation work


	//-------------------Retrieve All Characters--------------------------------------------------------

	@RequestMapping(value = "/character/", method = RequestMethod.GET)
	public ResponseEntity<List<Character>> listAllCharacters() {
		List<Character> characters = characterService.findAllCharacters();
		if(characters.isEmpty()){
			return new ResponseEntity<List<Character>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Character>>(characters, HttpStatus.OK);
	}



	//-------------------Retrieve Single Character--------------------------------------------------------

	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Character> getCharacter(@PathVariable("id") long id) {
		System.out.println("Fetching Character with id " + id);
		Character character = characterService.findById(id);
		if (character == null) {
			System.out.println("Character with id " + id + " not found");
			return new ResponseEntity<Character>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Character>(character, HttpStatus.OK);
	}



	//-------------------Create a Character--------------------------------------------------------

	@RequestMapping(value = "/character/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCharacter(@RequestBody Character character,    UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Character " + character.getCharacterName());

		if (characterService.isCharacterExist(character)) {
			System.out.println("A Character with name " + character.getCharacterName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		characterService.saveCharacter(character);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/character/{id}").buildAndExpand(character.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}



	//------------------- Update a Character --------------------------------------------------------

	@RequestMapping(value = "/character/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Character> updateCharacter(@PathVariable("id") long id, @RequestBody Character character) {
		System.out.println("Updating Character " + id);

		Character currentCharacter = characterService.findById(id);

		if (currentCharacter==null) {
			System.out.println("Character with id " + id + " not found");
			return new ResponseEntity<Character>(HttpStatus.NOT_FOUND);
		}

		currentCharacter.setCharacterName(character.getCharacterName());
		currentCharacter.setLevel(character.getLevel());
		currentCharacter.setHealth(character.getHealth());
		currentCharacter.setStrength(character.getStrength());
		currentCharacter.setDexterity(character.getDexterity());
		currentCharacter.setConstitution(character.getConstitution());
		currentCharacter.setIntelligence(character.getIntelligence());
		currentCharacter.setWisdom(character.getWisdom());
		currentCharacter.setCharisma(character.getCharisma());
		currentCharacter.setSpeed(character.getSpeed());
		currentCharacter.setCharacterClass(character.getCharacterClass());
		currentCharacter.setBackground(character.getBackground());

		characterService.updateCharacter(currentCharacter);
		return new ResponseEntity<Character>(currentCharacter, HttpStatus.OK);
	}



	//------------------- Delete a Character --------------------------------------------------------

	@RequestMapping(value = "/character/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Character> deleteCharacter(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Character with id " + id);

		Character character = characterService.findById(id);
		if (character == null) {
			System.out.println("Unable to delete. Character with id " + id + " not found");
			return new ResponseEntity<Character>(HttpStatus.NOT_FOUND);
		}

		characterService.deleteCharacterById(id);
		return new ResponseEntity<Character>(HttpStatus.NO_CONTENT);
	}



	//------------------- Delete All Characters --------------------------------------------------------

	@RequestMapping(value = "/character/", method = RequestMethod.DELETE)
	public ResponseEntity<Character> deleteAllCharacters() {
		System.out.println("Deleting All Characters");

		characterService.deleteAllCharacters();
		return new ResponseEntity<Character>(HttpStatus.NO_CONTENT);
	}

}
