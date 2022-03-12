package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setup() {
        given(helloService.greet()).willReturn("Hello");
    }

    @Test
    void shouldReturnHello() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    void shouldReturnHelloUsingWebTestClient() {

        String responseBody = webTestClient.get()
                .uri("/")
                .exchange()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();

        assertThat(responseBody).isEqualTo("Hello");
    }
}