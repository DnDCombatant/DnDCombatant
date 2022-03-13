package com.combatant.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.combatant.model.Character;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService{

	private static final AtomicLong counter = new AtomicLong();

	private static List<Character> characters;

	static{
		characters= populateDummyCharacters();
	}

	public List<Character> findAllCharacters() {
		return characters;
	}

	public Character findById(long id) {
		for(Character character : characters){
			if(character.getId() == id){
				return character;
			}
		}
		return null;
	}

	public Character findByName(String name) {
		for(Character character : characters){
			if(character.getCharacterName().equalsIgnoreCase(name)){
				return character;
			}
		}
		return null;
	}

	public void saveCharacter(Character character) {
		character.setId(counter.incrementAndGet());
		characters.add(character);
	}

	public void updateCharacter(Character character) {
		int index = characters.indexOf(character);
		characters.set(index, character);
	}

	public void deleteCharacterById(long id) {

		for (Iterator<Character> iterator = characters.iterator(); iterator.hasNext(); ) {
			Character character = iterator.next();
			if (character.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isCharacterExist(Character character) {
		return findByName(character.getCharacterName())!=null;
	}

	public void deleteAllCharacters(){
		characters.clear();
	}

	private static List<Character> populateDummyCharacters(){
		List<Character> characters = new ArrayList<Character>();
		characters.add(new Character(counter.incrementAndGet(),"Gideon Dane", 15, 105, 20,
				11, 18, 10, 12, 18, 30, "Paladin", "Soldier"));
		characters.add(new Character(counter.incrementAndGet(),"Rold Rondle", 15, 80, 8,
				14, 16, 14, 20, 13, 30, "Druid", "Sage"));
		characters.add(new Character(counter.incrementAndGet(),"Grog Strongjaw", 13, 200, 26,
				14, 22, 6, 10, 14, 35, "Barbarian", "Nomad"));
		characters.add(new Character(counter.incrementAndGet(),"Vrak'naar", 20, 130, 14,
				20, 19, 12, 20, 17, 45, "Monk", "Folk Hero"));
		return characters;
	}

}
