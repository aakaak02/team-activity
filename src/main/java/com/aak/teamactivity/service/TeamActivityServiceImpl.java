package com.aak.teamactivity.service;
import com.aak.teamactivity.repo.ActivityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamActivityServiceImpl implements TeamActivityService {

  private final ActivityRepo activityRepo;

  @Override
  public List<String> geActivityNames() {
    List<String> list = activityRepo.getActivityNames();
    log.info("Team count is :{}",list.size());
    return list;
  }

}
