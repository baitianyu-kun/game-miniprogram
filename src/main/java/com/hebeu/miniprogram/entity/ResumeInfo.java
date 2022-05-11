package com.hebeu.miniprogram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeInfo {

  private long resumeId;
  private long recruitId;
  private long userId;
  private String resumeFileUrl;
  private String resumeStatus;

}
