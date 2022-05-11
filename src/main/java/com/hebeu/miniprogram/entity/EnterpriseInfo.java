package com.hebeu.miniprogram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseInfo {

  private long enterpriseId;
  private String enterpriseName;
  private String enterpriseInfo;
  private String contactInfo;

}
