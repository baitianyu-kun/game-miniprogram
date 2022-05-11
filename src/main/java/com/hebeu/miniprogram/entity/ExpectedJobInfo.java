package com.hebeu.miniprogram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpectedJobInfo {

  private long expectedId;
  private long userId;
  private String workTime;
  private String workLocation;
  private String workPayment;
  private String workType;
  private String workContent;
  private String workPeriod;
  private String contactInfo;
  private java.sql.Timestamp releaseTime;

}
