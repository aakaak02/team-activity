package com.aak.teamactivity.web;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class TeamActivityController {

  private final TeamActivityService teamActivityService;

  @GetMapping("/{id}")
  public ResponseEntity<Activity> geActivityById(@PathVariable("id") Long id) {
    Activity activity = teamActivityService.geActivityById(id);
    return ResponseEntity.ok(activity);
  }

  @GetMapping("/activity-names")
  public ResponseEntity<List<String>> geActivityNames() {
    List<String> activityNames = teamActivityService.geActivityNames();
    return ResponseEntity.ok(activityNames);
  }

  @GetMapping("/participant-names")
  public ResponseEntity<List<String>> getParticipantNames() {
    List<String> participantNames = teamActivityService.getParticipantNames();
    return ResponseEntity.ok(participantNames);
  }

  @GetMapping("/activitiesbyparticipant")
  public ResponseEntity<List<Activity>> getActivitiesByParticipantId(@RequestParam("id") Long id) {
    List<Activity> activities = teamActivityService.getActivitiesByParticipantsId(id);
    return ResponseEntity.ok(activities);
  }

  @PostMapping("/addactivity")
  public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
    return ResponseEntity.ok(teamActivityService.addActivity(activity));
  }

  @PutMapping(("/updateactivity"))
  public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) {
    return ResponseEntity.ok(teamActivityService.updateActivity(activity));
  }

  @DeleteMapping(("/deleteactivity"))
  public void deleteActivity(@RequestBody Activity activity) {
    teamActivityService.deleteActivity(activity);
  }


}
