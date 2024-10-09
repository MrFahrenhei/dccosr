package com.ddcrpg.entity;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class Character {
    private static final Random random = new Random();
    private final String name;
    private final int maxHP;
    private final Map<Ability, Integer> abilities = new EnumMap<>(Ability.class);
    private final Map<Ability, Integer> abilitiesModifier = new EnumMap<>(Ability.class);
    private final int cooperPieces;
    private Occupation occupation;

    public Character(String name, int strength, int agility, int stamina, int personality, int intelligence,
                     int luck) {
        this.name = name;
        setAbilityScore(Ability.STRENGTH, strength);
        setAbilityScore(Ability.AGILITY, agility);
        setAbilityScore(Ability.STAMINA, stamina);
        setAbilityScore(Ability.PERSONALITY, personality);
        setAbilityScore(Ability.INTELLIGENCE, intelligence);
        setAbilityScore(Ability.LUCK, luck);
        calculateAndStoreModifiers();
        this.maxHP = Math.max(getHP() + getAbilityModifier(Ability.STAMINA), 1);
        this.cooperPieces = thrownCooperCoins();
    }
    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public int getHP() {
        return random.nextInt(4)+1;
    }
    public static int thrownCooperCoins() {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += random.nextInt(12) + 1;
        }
        return total;
    }

    private void calculateAndStoreModifiers() {
        for (Map.Entry<Ability, Integer> entry : abilities.entrySet()) {
            Ability ability = entry.getKey();
            int score = entry.getValue();
            abilitiesModifier.put(ability, calculateModifier(score));
        }
    }

    private void setAbilityScore(Ability ability, int score) {
        abilities.put(ability, score);
        abilitiesModifier.put(ability, calculateModifier(score));
    }

    public int getAbilityScore(Ability ability) {
        return abilities.get(ability);
    }

    public int getAbilityModifier(Ability ability) {
        return abilitiesModifier.get(ability);
    }

    private int calculateModifier(int score) {
        if (score == 3) {
            return -3;
        } else if (score == 4 || score == 5) {
            return -2;
        } else if (score >= 6 && score <= 8) {
            return -1;
        } else if (score >= 9 && score <= 12) {
            return 0;
        } else if (score >= 13 && score <= 15) {
            return 1;
        } else if (score == 16 || score == 17) {
            return 2;
        } else if (score == 18) {
            return 3;
        }
        return 0;
    }

    public String score() {
        StringBuilder scoreString = new StringBuilder("Abilities: ");
        for (Ability ability : Ability.values()) {
            scoreString.append(ability.name().toLowerCase()).append(" ")
                    .append(getAbilityScore(ability)).append(" (modifier: ")
                    .append(getAbilityModifier(ability)).append("); ");
        }
        return scoreString.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(name)
                .append(", HP: ").append(maxHP)
                .append(", Coins: ").append(cooperPieces)
                .append(", Occupation: ").append(occupation.getOccupation())
                .append(", Weapon name: ").append(occupation.getTrainedWeapon());
        return sb.toString();
    }
}