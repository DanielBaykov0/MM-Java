package com.IntermediateLevelOOP.AcademyOceanAssignment;

public class Warrior extends Hero {

    public Warrior(int id) {
        super(id, "Warrior");
    }

    @Override
    public String getQuote() {
        return "If you're a true warrior, competition doesn't scare you.\n" +
                "It makes you better.";
    }

    @Override
    public int attack() {
        if (isBattlefieldLocation(FightersService.location)) {
            if (isSpecialAttackLocation(getRANDOM_NUMBER_GENERATOR().nextInt(1, 101))) {
                return (int) (super.attack() * 1.5);
            }
        }

        return super.attack();
    }

    private static boolean isBattlefieldLocation(Locations location) {
        return Locations.BATTLEFIELD.equals(location);
    }

    private boolean isSpecialAttackLocation(int specialAttackLocationNumber) {
        int specialAttackLocationPercent = 10;
        return specialAttackLocationNumber <= specialAttackLocationPercent;
    }

    public static void isWarriorHealed(Locations location, Hero firstHero, Hero secondHero, int damage, int damageTook) {
        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(firstHero.getClassName()))) {
            firstHero.setHealthPoints(firstHero.getHealthPoints() + (int) (damage * 0.05));
        }

        if ((Warrior.isBattlefieldLocation(location) && "Warrior".equals(secondHero.getClassName()))) {
            secondHero.setHealthPoints(secondHero.getHealthPoints() + (int) (damageTook * 0.05));
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
