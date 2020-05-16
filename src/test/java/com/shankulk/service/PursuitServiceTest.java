package com.shankulk.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Pursuit;
import com.shankulk.model.PursuitStatus;
import com.shankulk.service.impl.PursuitServiceImpl;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

@ExtendWith(MockitoExtension.class)
public class PursuitServiceTest {

    @Mock
    private PursuitDao pursuitDao;

    @InjectMocks
    private PursuitServiceImpl sut;

    @Test
    void createPursuit_pursuitIdIsGenerated() {
        Pursuit pursuit = sut.createPursuit();
        assertThat(pursuit.getId()).isNotNull();
    }

    @Test
    void createPursuit_pursuitStatusIsCreated() {
        Pursuit pursuit = sut.createPursuit();
        assertThat(pursuit.getStatus()).isNotNull();
        assertThat(pursuit.getStatus()).isEqualTo(PursuitStatus.CREATED);
    }

    @Test
    void createPursuit_savePursuitIsCalledWithAppropriateValues() {
        // Given
        ArgumentCaptor<Pursuit> pursuitCaptor = ArgumentCaptor.forClass(Pursuit.class);
        Mockito.doNothing().when(pursuitDao).save(pursuitCaptor.capture());

        // When
        var pursuit = sut.createPursuit();

        // Then
        Mockito.verify(pursuitDao, Mockito.times(1)).save(Mockito.any(Pursuit.class));
        Pursuit capturedPursuit = pursuitCaptor.getValue();
        assertThat(capturedPursuit).isEqualTo(pursuit);
        assertThat(capturedPursuit).isNotNull();
        assertThat(capturedPursuit.getId()).isNotNull();
        assertThat(capturedPursuit.getId()).isInstanceOf(UUID.class);
        assertThat(capturedPursuit.getStatus()).isEqualTo(PursuitStatus.CREATED);
    }
}
