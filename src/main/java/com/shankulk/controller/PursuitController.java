package com.shankulk.controller;

import com.shankulk.dto.PursuitDto;
import com.shankulk.model.Objective;
import com.shankulk.model.ObjectiveComparator;
import com.shankulk.model.Pursuit;
import com.shankulk.service.PursuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pursuits")
public class PursuitController {

    @Autowired
    private PursuitService pursuitService;

    /*@GetMapping
    public Pursuit getPursuitById(UUID id) {

    }*/


    @PostMapping
    public ResponseEntity<Pursuit> createPursuit(PursuitDto pursuit) {
        Pursuit pursuitModel = pursuitService
            .createPursuit(pursuit.getPursuitName(),
                Objective.createObjective(pursuit.getObjectiveName(), pursuit.getMetric(),
                    ObjectiveComparator.valueOf(pursuit.getComparator()), pursuit.getValue()));
        return ResponseEntity.ok(pursuitModel);
    }

}
