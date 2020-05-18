package com.shankulk.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.shankulk.dao.PursuitDao;
import com.shankulk.model.Objective;
import com.shankulk.model.ObjectiveComparator;
import com.shankulk.model.Pursuit;
import com.shankulk.model.PursuitStatus;
import com.shankulk.service.impl.PursuitServiceImpl;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Create pursuit should create a new pursuit with generated id.")
    void createPursuit_pursuitIdIsGenerated() {
        Pursuit pursuit = sut.createPursuit("Pursuit 1", Objective.createObjective("obj1",ObjectiveComparator.EQ,2.0));
        assertThat(pursuit.getId()).isNotNull();
    }

    @Test
    void createPursuit_pursuitStatusIsCreated() {
        Pursuit pursuit = sut.createPursuit("Pursuit 1", Objective.createObjective("obj1",ObjectiveComparator.EQ,2.0));
        assertThat(pursuit.getStatus()).isNotNull();
        assertThat(pursuit.getStatus()).isEqualTo(PursuitStatus.CREATED);
    }

    @Test
    void createPursuit_savePursuitIsCalledWithAppropriateValues() {
        // Given
        ArgumentCaptor<Pursuit> pursuitCaptor = ArgumentCaptor.forClass(Pursuit.class);
        Mockito.doNothing().when(pursuitDao).save(pursuitCaptor.capture());

        // When
        var pursuit = sut.createPursuit("Pursuit 1", Objective.createObjective("obj1",ObjectiveComparator.EQ,2.0));

        // Then
        Mockito.verify(pursuitDao, Mockito.times(1)).save(Mockito.any(Pursuit.class));
        Pursuit capturedPursuit = pursuitCaptor.getValue();
        assertThat(capturedPursuit).isEqualTo(pursuit);
        assertThat(capturedPursuit).isNotNull();
        assertThat(capturedPursuit.getId()).isNotNull();
        assertThat(capturedPursuit.getId()).isInstanceOf(UUID.class);
        assertThat(capturedPursuit.getStatus()).isEqualTo(PursuitStatus.CREATED);
    }
    
    @Test
    void createPursuitWithObjective_save() {
    	//Given
    	
    	//When
    	Pursuit pursuit = sut.createPursuit("Pursuit 1", Objective.createObjective("obj1",ObjectiveComparator.EQ, 1.9999999995));
    	
    	//Then
    	assertThat(pursuit.getObjective()).isNotNull();
    	assertThat(pursuit.getObjective().getId()).isNotNull();
    	assertThat(pursuit.getObjective().getMetricName()).isEqualTo("obj1");
    	assertThat(pursuit.getObjective().getComparator()).isEqualTo(ObjectiveComparator.EQ);
    	assertThat(pursuit.getObjective().getMetricValve()).isEqualTo(1.9999999995);
    }
    
    @Test
    void createPursuitWithObjective_saveWithObjective() {
    	//Given
    	ArgumentCaptor<Pursuit> argumentCaptor = ArgumentCaptor.forClass(Pursuit.class);
    	Mockito.doNothing().when(pursuitDao).save(argumentCaptor.capture());
    	//When
    	sut.createPursuit("Pursuit 1", Objective.createObjective("obj1",ObjectiveComparator.EQ, 1.9999999995));
    	
    	//Then
    	Objective objective = argumentCaptor.getValue().getObjective();
    	
    	assertThat(objective).isNotNull();
    	assertThat(objective.getId()).isNotNull();
    	assertThat(objective.getMetricName()).isEqualTo("obj1");
    	assertThat(objective.getComparator()).isEqualTo(ObjectiveComparator.EQ);
    	assertThat(objective.getMetricValve()).isEqualTo(1.9999999995);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
