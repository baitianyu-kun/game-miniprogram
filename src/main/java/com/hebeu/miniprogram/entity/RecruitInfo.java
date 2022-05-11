package com.hebeu.miniprogram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitInfo {

  private long recruitId;
  private long userId;
  private long enterpriseId;
  private String recruitType;
  private String recruitPosition;
  private String workType;
  private String workTime;
  private String workLocation;
  private String workPayment;
  private String workContent;
  private String workPeriod;
  private String contactInfo;
  private java.sql.Timestamp releaseTime;

}
