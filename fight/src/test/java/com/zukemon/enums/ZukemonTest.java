package com.zukemon.enums;

import com.zukemon.enums.Zukemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZukemonTest {

    @Test
    public void whenTypeIs25ReturnPikachu() {
        var zukemon = Zukemon.getZukemonByType(25);
        Assertions.assertEquals(Zukemon.PIKACHU, zukemon);
        Assertions.assertEquals(Zukemon.PIKACHU.getDamage(), zukemon.getDamage());
    }

    @Test
    public void whenPikachuTypeDamageIs135() {
        var damage = Zukemon.PIKACHU.getDamage();
        Assertions.assertEquals(Zukemon.PIKACHU.getDamage(), damage);
    }
}