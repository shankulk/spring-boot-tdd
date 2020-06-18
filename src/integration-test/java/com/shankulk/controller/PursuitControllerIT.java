package com.shankulk.controller;

import static com.shankulk.helper.TestFixtures.pursuitFixture;

import com.shankulk.BaseIntegrationTest;
import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Pursuit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


class PursuitControllerIT extends BaseIntegrationTest {

    @MockBean
    private PursuitDao pursuitDao;
    private String baseUrl = "http://localhost:" + getPort();

    @BeforeEach
    public void setup() {
        BDDMockito.doNothing().when(pursuitDao).save(Mockito.any(Pursuit.class));
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testCreatePursuit() {
        ResponseEntity<Void> pursuit = restTemplate.postForEntity(baseUrl + "/pursuits", pursuitFixture(),Void.class);
        Assertions.assertThat(pursuit.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}