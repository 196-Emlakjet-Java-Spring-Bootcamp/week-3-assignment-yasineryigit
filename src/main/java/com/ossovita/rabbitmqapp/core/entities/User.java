package com.ossovita.rabbitmqapp.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_seq")
    @Column(name = "user_pk")
    private long userPk;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_mail")
    private String userMail;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SaleAdvertisement> saleAdvertisementList;


}
