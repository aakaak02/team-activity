package com.aak.teamactivity.service;
import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.domain.Participant;
import com.aak.teamactivity.repo.ActivityRepo;
import com.aak.teamactivity.repo.ParticipantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamActivityServiceImpl implements TeamActivityService {

  private final ActivityRepo activityRepo;
  private final ParticipantRepo participantRepo;
  @Override
  public List<String> geActivityNames() {
    List<String> list = activityRepo.getActivityNames();
    log.info("Team count is :{}",list.size());
    return list;
  }

  @Override
  public List<String> getParticipantNames() {
    List<String> list = participantRepo.getParticipantNames();
    log.info("Participant count is :{}",list.size());
    return list;
  }

 @Override
 public Optional<Activity> geActivityById(Long id){
   log.info("id in service impl is :{}",id);
   Optional<Activity> activity =  activityRepo.findById(id);
   log.info("activity is :{}",activity.toString());
   return activity;
 }

 @Override
  public Optional<Participant> getParticipantById(Long id){
   log.info("id in service impl is :{}",id);
   Optional<Participant> participant = participantRepo.findById(id);
   log.info("participant is :{}",participant.toString());
   return participant;
  }

    public List<Activity> getActivitiesByParticipantsId(Long id){
        log.info("id in service impl getActivitiesByParticipantId is :{}",id);
        List <Activity> activities = activityRepo.findActivitiesByParticipantsId(id);
        log.info("activities size is :{}",activities.size());
        return activities;
    }

    public List<Participant> getParticipantsByActivitiesId(Long id){
        log.info("id in service impl getParticipantsByActivitiesId is :{}",id);
        List <Participant> participants = participantRepo.findParticipantsByActivitiesId(id);
        log.info("participants size is :{}",participants.size());
        return participants;
    }

    @Override
    @CachePut(value = "participant", key = "#participant.id")
    public Participant updateParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    @Override
    public Participant addParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) {
      participantRepo.delete(participant);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    @Override
    public void deleteActivity(Activity activity) {
        activityRepo.delete(activity);
    }
}
