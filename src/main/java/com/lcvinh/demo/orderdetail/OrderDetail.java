package com.lcvinh.demo.orderdetail;


import com.lcvinh.demo.entity.BaseEntity;
import com.lcvinh.demo.screeningseat.ScreeningSeat;
import com.lcvinh.demo.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order ordere;

    @ManyToOne
    @JoinColumn(name = "screening_seat_id", nullable = false)
    private ScreeningSeat screeningSeat;

    private BigDecimal price;
}
