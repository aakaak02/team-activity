package com.aak.teamactivity.domain;

import com.aak.teamactivity.domain.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participant")
@Getter
@Setter
public class Participant {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "mobile")
  private String mobile;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "participantid", nullable = false)
  private Payment payment;

}
