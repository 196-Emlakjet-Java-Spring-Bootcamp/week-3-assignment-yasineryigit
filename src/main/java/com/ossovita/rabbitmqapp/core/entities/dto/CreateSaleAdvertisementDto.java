package com.ossovita.rabbitmqapp.core.entities.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateSaleAdvertisementDto {

    @NotBlank
    private String title;

    @NotBlank
    private String photo;

    @NotBlank
    private String detailMessage;

    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String userMail;


}
