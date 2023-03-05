package com.aak.teamactivity.service;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.domain.Participant;

import java.util.List;
import java.util.Optional;

public interface TeamActivityService {

      List<String> geActivityNames();
      List<String> getParticipantNames();

      public Optional<Activity> geActivityById(Long id);

      public Optional<Participant> getParticipantById(Long id);

      public List<Activity> getActivitiesByParticipantsId(Long id);

      public List<Participant> getParticipantsByActivitiesId(Long id);
}
