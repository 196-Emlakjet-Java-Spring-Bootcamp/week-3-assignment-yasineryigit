package com.ossovita.rabbitmqapp.business.abstracts;


import com.ossovita.rabbitmqapp.core.entities.dto.CreateSaleAdvertisementDto;

public interface SaleAdvertisementService {

    public CreateSaleAdvertisementDto createSaleAdvertisement(CreateSaleAdvertisementDto createSaleAdvertisementDto);
}
