package com.shankulk.controller;

import com.shankulk.dto.PursuitDto;
import com.shankulk.model.Objective;
import com.shankulk.model.ObjectiveComparator;
import com.shankulk.model.Pursuit;
import com.shankulk.service.PursuitService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pursuits")
public class PursuitController {

    private final PursuitService pursuitService;

    @Autowired
    public PursuitController(PursuitService pursuitService) {
        this.pursuitService = pursuitService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPursuit(@RequestBody PursuitDto pursuit) {
        Pursuit pursuitModel = pursuitService
            .createPursuit(pursuit.getPursuitName(),
                Objective.createObjective(pursuit.getObjectiveName(), pursuit.getMetric(),
                    ObjectiveComparator.valueOf(pursuit.getComparator()), pursuit.getValue()));
        return ResponseEntity.created(URI.create("/pursuits")).build();
    }

}
