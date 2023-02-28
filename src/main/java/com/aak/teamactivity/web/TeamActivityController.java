package com.aak.teamactivity.web;

import com.aak.teamactivity.service.TeamActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ta")
@RequiredArgsConstructor
public class TeamActivityController {

    private final TeamActivityService teamActivityService;

    @GetMapping("/activity-names")
    public ResponseEntity<List<String>> geActivityNames(){
      List<String> activityNames = teamActivityService.geActivityNames();
      return ResponseEntity.ok(activityNames);
    }

}
