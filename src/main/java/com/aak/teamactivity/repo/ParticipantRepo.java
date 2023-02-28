package com.aak.teamactivity.repo;

import com.aak.teamactivity.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {

    @Query("select p.name from Participant p")
    public List<String> getParticipantNames();
}
