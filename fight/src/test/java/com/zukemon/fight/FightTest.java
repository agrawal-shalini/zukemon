package com.zukemon.fight;

import com.zukemon.exception.InvalidZukemonException;
import com.zukemon.fight.CriticalHit;
import com.zukemon.fight.Fight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class FightTest {

    private Fight classUnderTest;
    private CriticalHit criticalHit;

    @BeforeEach
    public void setUp() {
        criticalHit = Mockito.mock(CriticalHit.class);
        Mockito.when(criticalHit.isCriticalHit(ArgumentMatchers.anyInt())).thenReturn(false);
        this.classUnderTest = new Fight(criticalHit);
    }

    @Test
    public void whenAttackerTypeIsWartortleAndNoCriticalHitReturn300() {

        int damage = classUnderTest.hit(8);

        assertThat(damage).isEqualTo(300);
    }

    @Test
    public void whenAttackerTypeIsKrookodileAndNoCriticalHitReturn1204() {

        int damage = classUnderTest.hit(553);

        assertThat(damage).isEqualTo(1204);
    }

    @Test
    public void whenAttackerTypeIsMudkipAndCriticalHitReturn468() {
        Mockito.when(criticalHit.isCriticalHit(ArgumentMatchers.anyInt())).thenReturn(true);
        int damage = classUnderTest.hit(258);

        assertThat(damage).isEqualTo(468);
    }

    @Test
    public void whenAttackerTypeIsInvalidThenThrowException() {

        Assertions.assertThrows(InvalidZukemonException.class, () -> classUnderTest.hit(0));

    }
}
