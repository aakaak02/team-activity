package com.aak.teamactivity.dto;

import com.aak.teamactivity.domain.ActivityType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivityDto {
  private Long id;
  private String title;
  private String clubName;
  private ActivityType activityType;
  private LocalDate date;
  private LocalTime startTime;
  private LocalTime endTime;
  private int maxCount;
  private float amount;
  private List<ParticipantDto> participants;

}
