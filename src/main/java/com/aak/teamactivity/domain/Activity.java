package com.aak.teamactivity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
  @Column(name = "type")
  private String name;
  @Column(name = "place")
  private String role;
  @Column(name = "maxcount")
  private int maxcount;
  @Column(name = "amount")
  private double amount;
  @ManyToMany
  @JoinTable(
      name = "activity_participant",
      joinColumns = @JoinColumn(name = "activity_id"),
      inverseJoinColumns = @JoinColumn(name = "participant_id"))
  private List<Participant> participants;

}
