package com.shankulk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

    @Getter
    @LocalServerPort
    private int port;

    protected String baseUrl = "http://localhost:";

    @Test
    void testNonZeroPort() {
        assertThat(port).isGreaterThan(0);
    }

}
