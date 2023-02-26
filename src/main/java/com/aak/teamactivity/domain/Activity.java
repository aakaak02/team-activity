package com.aak.teamactivity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "activity")
@Getter
@Setter
public class Activity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String clubName;
  private ActivityType activityType;
  private LocalDate date;
  private LocalTime startTime;
  private LocalTime endTime;
  private int maxCount;
  private float amount;
  @ManyToMany
  @JoinTable(
      name = "activity_participant",
      joinColumns = @JoinColumn(name = "activity_id"),
      inverseJoinColumns = @JoinColumn(name = "participant_id"))
  private List<Participant> participants;

}
