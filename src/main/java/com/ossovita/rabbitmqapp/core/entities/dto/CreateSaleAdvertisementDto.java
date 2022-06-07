package com.ossovita.rabbitmqapp.core.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import com.ossovita.rabbitmqapp.core.entities.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CreateSaleAdvertisementDto {

    @NotBlank
    private String title;

    @NotBlank
    private String photo;

    @NotBlank
    private String detailMessage;

    private String priceGraphPath;//will be filled by consumer

    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String userMail;


}
