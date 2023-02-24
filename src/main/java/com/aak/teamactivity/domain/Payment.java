package com.aak.teamactivity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.aak.teamactivity.domain.Participant;

import java.util.List;

@Entity
@Table(name = "activity_payment")
@Getter
@Setter
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "activityid",nullable = false)
    private String activityid;
    @Column(name = "participantid", nullable = false)
    private String participantid;
    @Column(name = "amount")
    private double amount;

    @OneToMany(mappedBy ="payment",fetch = FetchType.EAGER)
    private List<Participant> participants;

    @OneToMany(mappedBy ="payment",fetch = FetchType.EAGER)
    private List<Activity> activities;

}
