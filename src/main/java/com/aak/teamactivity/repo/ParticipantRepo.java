package com.aak.teamactivity.repo;

import com.aak.teamactivity.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {

}
