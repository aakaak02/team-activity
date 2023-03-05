package com.aak.teamactivity.web;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeamActivityController {

    private final TeamActivityService teamActivityService;

    //test url: http://localhost:8081/teamactivity/api/activity/
    @GetMapping("/activity")
    public ResponseEntity<Optional<Activity>> geActivityById(@RequestParam("id") Long id){
        System.out.println("id from request param is "+id);
        Optional<Activity> activity = teamActivityService.geActivityById(id);
        return ResponseEntity.ok(activity);
    }

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

    //test url: http://localhost:8081/teamactivity/api/activitiesbyparticipant
    //http://localhost:8081/teamactivity/api/activitiesbyparticipant?id=101

    @GetMapping("/activitiesbyparticipant")
    public ResponseEntity<List<Activity>> getActivitiesByParticipantId(@RequestParam("id") Long id){
        List<Activity> activities = teamActivityService.getActivitiesByParticipantsId(id);
        return ResponseEntity.ok(activities);
    }

}
