package com.aak.teamactivity.dto;

import lombok.Value;

@Value
public class ActivityDto {
  private Long id;
  private String name;

  private String role;

  private int maxcount;

  private double amount;

}
