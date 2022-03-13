package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void greet() {
        Assertions.assertThat(helloService.greet()).isEqualTo("Hello");
    }
}