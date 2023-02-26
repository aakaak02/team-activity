package com.aak.teamactivity.repo;

import com.aak.teamactivity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity,Long> {


  @Query("select t.name from Activity t")
  public List<String> geActivityNames();

}
