package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void greet() {
        assertThat(helloService.greet()).isEqualTo("Hello");
    }
}