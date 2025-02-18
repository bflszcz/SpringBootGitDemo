package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private int id;
  private String username;
  private String password;
  private String role;
  private String email;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private String token;
}
