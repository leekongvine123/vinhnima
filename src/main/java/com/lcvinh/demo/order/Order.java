package com.lcvinh.demo.order;

import com.lcvinh.demo.entity.BaseEntity;
import com.lcvinh.demo.orderdetail.OrderDetail;
import com.lcvinh.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "ordere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    @Column(length = 20, nullable = false)
    private String status; // Paid, Pending, Cancelled
}