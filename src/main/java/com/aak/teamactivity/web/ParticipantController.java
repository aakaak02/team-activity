package com.aak.teamactivity.web;

import com.aak.teamactivity.domain.Participant;
import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //http://localhost:8081/teamactivity/api/addparticipant
    @PostMapping("/addparticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant) {
        return ResponseEntity.ok(teamActivityService.addParticipant(participant));
    }

    //http://localhost:8081/teamactivity/api/updateparticipant
    @PutMapping(("/updateparticipant"))
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) {
        return ResponseEntity.ok(teamActivityService.updateParticipant(participant));
    }

    //http://localhost:8081/teamactivity/api/deleteparticipant
    @DeleteMapping(("/deleteparticipant"))
    public void deleteParticipant(@RequestBody Participant participant) {
         teamActivityService.deleteParticipant(participant);
    }

}
