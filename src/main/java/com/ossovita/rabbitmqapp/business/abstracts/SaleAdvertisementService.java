package com.ossovita.rabbitmqapp.business.abstracts;


import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import com.ossovita.rabbitmqapp.core.entities.dto.CreateSaleAdvertisementDto;

import java.util.List;

public interface SaleAdvertisementService {

    CreateSaleAdvertisementDto createSaleAdvertisement(CreateSaleAdvertisementDto createSaleAdvertisementDto);

    List<SaleAdvertisement> getAllSaleAdvertisements();


}
