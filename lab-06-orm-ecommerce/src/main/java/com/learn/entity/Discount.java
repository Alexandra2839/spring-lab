package com.learn.entity;

import com.learn.enums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Discount extends BaseEntity{

    private String name;
    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

}
