package com.aak.teamactivity.service;
import com.aak.teamactivity.repo.ActivityRepo;
import com.aak.teamactivity.repo.ParticipantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
