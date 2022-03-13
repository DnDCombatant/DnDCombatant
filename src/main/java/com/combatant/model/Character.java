package com.combatant.model;

public class Character {

	private long id;
	private String characterName;
 	private Integer level;
	private Integer health;
	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	private Integer speed;
 	private String characterClass;
	private String background;

	public Character(){
		id=0;
	}

	public Character(long id, String characterName, Integer level, Integer health, Integer strength, Integer dexterity,
					 Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, Integer speed,
					 String characterClass, String background) {
		this.id = id;
		this.characterName = characterName;
		this.level = level;
		this.health = health;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.speed = speed;
		this.characterClass = characterClass;
		this.background = background;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Character))
			return false;
		Character other = (Character) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Character{" +
				"id=" + id +
				", characterName='" + characterName + '\'' +
				", level=" + level +
				", health=" + health +
				", strength=" + strength +
				", dexterity=" + dexterity +
				", constitution=" + constitution +
				", intelligence=" + intelligence +
				", wisdom=" + wisdom +
				", charisma=" + charisma +
				", speed=" + speed +
				", characterClass='" + characterClass + '\'' +
				", background='" + background + '\'' +
				'}';
	}
}
