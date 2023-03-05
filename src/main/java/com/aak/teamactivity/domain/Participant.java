package com.aak.teamactivity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
  @ManyToMany(mappedBy = "participants")
  @JsonIgnore
 /* This is an issue with bidirectional relationships, as they hold references to each other,
  at deserialization, Jackson runs in an infinite loop. My first suggestion would be adding @JsonIgnore
  to one end of the relation.
  above is needed to avoid
  Spring Boot : Error :Cannot call sendError() after the response has been committed
  */
  private List<Activity> activities;

}
