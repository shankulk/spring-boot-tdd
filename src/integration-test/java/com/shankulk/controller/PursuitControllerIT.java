package com.shankulk.controller;

import com.shankulk.BaseIntegrationTest;
import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Pursuit;
import com.shankulk.model.PursuitStatus;
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

    @BeforeEach
    public void setup() {
        BDDMockito.doNothing().when(pursuitDao).save(Mockito.any(Pursuit.class));
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testCreatePursuit() {
        ResponseEntity<Pursuit> pursuit = restTemplate.getForEntity("http://localhost:" + getPort() + "/pursuits", Pursuit.class);

        Assertions.assertThat(pursuit.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(pursuit.getBody().getStatus()).isEqualTo(PursuitStatus.CREATED);
    }


}