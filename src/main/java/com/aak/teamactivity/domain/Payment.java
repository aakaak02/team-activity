package com.aak.teamactivity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.aak.teamactivity.domain.Participant;

import java.util.List;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    @Column(name = "amount")
    private double amount;



}
