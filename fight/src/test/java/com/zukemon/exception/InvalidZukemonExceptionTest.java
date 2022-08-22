package com.zukemon.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidZukemonExceptionTest {

    @Test
    public void test() {
        var message = new InvalidZukemonException().getMessage();
        assertThat(message).isEqualTo("Invalid zukemon!!");
    }
}