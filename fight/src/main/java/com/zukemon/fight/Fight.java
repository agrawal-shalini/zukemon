package com.zukemon.fight;

import com.zukemon.enums.Zukemon;
import com.zukemon.exception.InvalidZukemonException;

import java.util.Optional;

public class Fight {

    private final CriticalHit criticalHit;

    public Fight(CriticalHit criticalHit) {
        this.criticalHit = criticalHit;
    }

    /**
     * <p>
     * This method returns hit or damage inflicted for the given attacker type
     *
     * @param attackerType attacker type
     */
    public int hit(int attackerType) {
        var zukemon = Zukemon.getZukemonByType(attackerType);
        return Optional.ofNullable(zukemon)
                .map(this::damageInflicted)
                .orElseThrow(InvalidZukemonException::new);
    }

    private int damageInflicted(Zukemon zuke) {
        return Optional.of(this.criticalHit.isCriticalHit(zuke.getCriticalHitChance()))
                .filter(isTrue -> isTrue)
                .map(o -> zuke.getDamage() * 2)
                .orElse(zuke.getDamage());
    }
}
