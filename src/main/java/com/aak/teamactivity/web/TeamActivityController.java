package com.aak.teamactivity.web;

import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeamActivityController {

    private final TeamActivityService teamActivityService;

    //test url: http://localhost:8081/teamactivity/api/activity-names
    @GetMapping("/activity-names")
    public ResponseEntity<List<String>> geActivityNames(){
      List<String> activityNames = teamActivityService.geActivityNames();
      return ResponseEntity.ok(activityNames);
    }

    //test url: http://localhost:8081/teamactivity/api/participant-names
    @GetMapping("/participant-names")
    public ResponseEntity<List<String>> getParticipantNames(){
        List<String> participantNames = teamActivityService.getParticipantNames();
        return ResponseEntity.ok(participantNames);
    }

}
