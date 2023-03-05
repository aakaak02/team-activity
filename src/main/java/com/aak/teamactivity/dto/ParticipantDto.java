package com.aak.teamactivity.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParticipantDto {
  private Long id;
  private String name;
  private String email;
  private String mobile;
  private List<ActivityDto> activities;

}