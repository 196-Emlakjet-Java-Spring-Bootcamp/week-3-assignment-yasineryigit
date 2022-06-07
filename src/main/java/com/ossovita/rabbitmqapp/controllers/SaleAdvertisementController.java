package com.ossovita.rabbitmqapp.controllers;

import com.ossovita.rabbitmqapp.business.abstracts.SaleAdvertisementService;
import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import com.ossovita.rabbitmqapp.core.entities.dto.CreateSaleAdvertisementDto;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class SaleAdvertisementController {

    private SaleAdvertisementService saleAdvertisementService;


    public SaleAdvertisementController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;

    }

    @PostMapping("/sale-advertisement")
    public ResponseEntity<CreateSaleAdvertisementDto> createSaleAdvertisement(@Validated @RequestBody CreateSaleAdvertisementDto createSaleAdvertisementDto) {
        return ResponseEntity.ok(saleAdvertisementService.createSaleAdvertisement(createSaleAdvertisementDto));
    }

    @GetMapping("/sale-advertisement")
    public List<SaleAdvertisement> getAllSaleAdvertisements(){
        return saleAdvertisementService.getAllSaleAdvertisements();
    }

}
