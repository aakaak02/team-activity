package com.aak.teamactivity.service;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.domain.Participant;

import java.util.List;
import java.util.Optional;

public interface TeamActivityService {

      List<String> geActivityNames();
      List<String> getParticipantNames();

      Activity geActivityById(Long id);

      public Optional<Participant> getParticipantById(Long id);

      public List<Activity> getActivitiesByParticipantsId(Long id);

      public List<Participant> getParticipantsByActivitiesId(Long id);

      public Participant updateParticipant(Participant participant);

      public Participant addParticipant(Participant participant);

      public void deleteParticipant(Participant participant);

      public Activity updateActivity(Activity activity);

      public Activity addActivity(Activity activity);

      public void deleteActivity(Activity activity);
}
