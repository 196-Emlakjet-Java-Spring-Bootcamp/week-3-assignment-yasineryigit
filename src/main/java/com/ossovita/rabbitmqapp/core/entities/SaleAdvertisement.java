package com.ossovita.rabbitmqapp.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sale_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleAdvertisement {

    @Id
    @SequenceGenerator(name = "sa_seq", allocationSize = 1)
    @GeneratedValue(generator = "sa_seq")
    @Column(name = "sale_advertisement_pk")
    private long saleAdvertisementPk;

    @Column(name = "title")
    private String title;

    @Column(name = "photo")
    private String photo;

    @Column(name = "detail_message")
    private String detailMessage;

    @Column(name = "price_graph_path")
    private String priceGraphPath;

    @ManyToOne
    @JoinColumn(name = "user_fk", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name = "user_fk")
    private long userFk;

}
