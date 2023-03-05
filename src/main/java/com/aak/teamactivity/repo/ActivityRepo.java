package com.aak.teamactivity.repo;

import com.aak.teamactivity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Long> {


  @Query("select t.title from Activity t")
  public List<String> getActivityNames();
/*
  select p.name from participant p, activity_participant ap
  where ap.activity_id =1 and ap.participant_id=p.id
  @Query("""
      select new com.aak.teamacivity.dto.ParticipantDto(
      p.id, p.name,p.email, p.mobile) from Participant p,  activity_participant ap
      where ap. = :id and p.
      """)*/
  public List<Activity> findActivitiesByParticipantsId(Long participantId);

}
