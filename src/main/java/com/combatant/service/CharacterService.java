package com.combatant.service;

import java.util.List;

import com.combatant.model.Character;

public interface CharacterService {

    Character findById(long id);

    Character findByName(String name);

    void saveCharacter(Character character);

    void updateCharacter(Character character);

    void deleteCharacterById(long id);

    List<Character> findAllCharacters();

    void deleteAllCharacters();

    public boolean isCharacterExist(Character character);

}
