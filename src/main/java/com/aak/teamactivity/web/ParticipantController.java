package com.aak.teamactivity.web;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.domain.Participant;
import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParticipantController {

    private final TeamActivityService teamActivityService;

    //test url: http://localhost:8081/teamactivity/api/participant?id=101
    @GetMapping("/participant")
    public ResponseEntity<Optional<Participant>> geParticipantById(@RequestParam("id") Long id){
        System.out.println("id from request param is "+id);
        Optional<Participant> participant = teamActivityService.getParticipantById(id);
        return ResponseEntity.ok(participant);
    }

    //test url: http://localhost:8081/teamactivity/api/participantsbyactivities
    //http://localhost:8081/teamactivity/api/participantsbyactivities?id=101

    @GetMapping("/participantsbyactivities")
    public ResponseEntity<List<Participant>> getParticipantsByActivitiesId(@RequestParam("id") Long id){
        List<Participant> participants = teamActivityService.getParticipantsByActivitiesId(id);
        return ResponseEntity.ok(participants);
    }

}
