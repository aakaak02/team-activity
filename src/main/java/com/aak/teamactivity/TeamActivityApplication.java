package com.aak.teamactivity;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.domain.ActivityType;
import com.aak.teamactivity.domain.Participant;
import com.aak.teamactivity.repo.ActivityRepo;
import com.aak.teamactivity.repo.ParticipantRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class TeamActivityApplication implements CommandLineRunner {

  @Autowired
  private ActivityRepo activityRepo;
  @Autowired
  private ParticipantRepo participantRepo;

  public static void main(String[] args) {
    SpringApplication.run(TeamActivityApplication.class, args);
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    activityRepo.deleteAll();
    participantRepo.deleteAll();
    Activity activity = new Activity();
    activity.setActivityType(ActivityType.BADMINTON);
    activity.setDate(LocalDate.now());
    activity.setStartTime(LocalTime.now());
    activity.setEndTime(LocalTime.now().plusMinutes(60));
    activity.setClubName("PlayTM");
    activity.setAmount(80);
    activity.setMaxCount(5);
    activity.setTitle("Evening Activity - Badminton");
    activityRepo.save(activity);

    Participant participant = new Participant();
    participant.setName("Satya");
    participant.setMobile("9036102111");
    participant.setEmail("javawithlwl@gmail.com");
    participantRepo.save(participant);

    activity = activityRepo.findAll().stream().findFirst().get();
    participant = participantRepo.findAll().stream().findFirst().get();
    participant.addActivities(activity);
    participantRepo.save(participant);
  }
}
