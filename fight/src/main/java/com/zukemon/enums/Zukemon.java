package com.zukemon.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Zukemon {
    BLASTOISE(9, "Water", 258, 0),
    MEW(151, "Psychic", 150, 10),
    WARTORTLE(8, "Water", 300, 0),
    MUDKIP(258, "Water", 234, 0),
    PIKACHU(25, "Electric", 135, 0),
    PSYDUCK(54, "Water", 127, 20),
    KROOKODILE(553, "Dark(Team Lead)", 0, 0);

    private final int zukemonType;
    private final String zukemonCategory;
    private final int damage;
    private final int criticalHitChance;

    Zukemon(int zukemonType, String zukemonCategory, int damage, int criticalHitChance) {
        this.zukemonType = zukemonType;
        this.zukemonCategory = zukemonCategory;
        this.damage = damage;
        this.criticalHitChance = criticalHitChance;
    }


    public static Zukemon getZukemonByType(int type) {
        return Arrays.stream(Zukemon.values())
                .filter(zuke -> zuke.getZukemonType() == type)
                .findFirst()
                .orElse(null);
    }

    public int getZukemonType() {
        return zukemonType;
    }

    public String getZukemonCategory() {
        return zukemonCategory;
    }

    public int getDamage() {
        return Optional.of(this.getZukemonType() == KROOKODILE.getZukemonType())
                .filter(isTrue -> isTrue)
                .map(t -> getCollectiveDamageByZukemonOtherThanKrookodile())
                .orElse(this.damage);
    }

    private int getCollectiveDamageByZukemonOtherThanKrookodile() {
        return Arrays.stream(Zukemon.values()).filter(zuke -> zuke.getZukemonType() != KROOKODILE.getZukemonType()).mapToInt(Zukemon::getDamage).sum();
    }

    public int getCriticalHitChance() {
        return criticalHitChance;
    }
}
