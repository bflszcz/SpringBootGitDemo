package com.bflsz.springbootgit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donate {
    private int donateId;
    private Integer userId;
    private Integer projectId;
    private BigDecimal amount;
    private LocalDateTime donateTime;
    private String paymentMethod;
    private String donorName;
}
