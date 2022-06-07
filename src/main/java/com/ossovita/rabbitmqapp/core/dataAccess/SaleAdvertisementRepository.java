package com.ossovita.rabbitmqapp.core.dataAccess;

import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleAdvertisementRepository extends JpaRepository<SaleAdvertisement, Long> {

}
