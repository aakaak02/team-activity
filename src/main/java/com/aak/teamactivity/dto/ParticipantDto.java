package com.aak.teamactivity.dto;

import lombok.Value;

@Value
public class ParticipantDto {
  private Long id;
  private String name;
  private String email;
  private String mobile;
}