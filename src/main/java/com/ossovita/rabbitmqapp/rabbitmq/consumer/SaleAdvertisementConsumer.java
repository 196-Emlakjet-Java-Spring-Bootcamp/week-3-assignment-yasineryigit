package com.ossovita.rabbitmqapp.rabbitmq.consumer;

import com.ossovita.rabbitmqapp.core.dataAccess.SaleAdvertisementRepository;
import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class SaleAdvertisementConsumer {

    SaleAdvertisementRepository saleAdvertisementRepository;

    public SaleAdvertisementConsumer(SaleAdvertisementRepository saleAdvertisementRepository) {
        this.saleAdvertisementRepository = saleAdvertisementRepository;
    }

    @RabbitListener(queues = "${sr.rabbit.queue.name}")//get queue name from application.yml
    private void addPriceGraphPathToSaleAdvertisement(SaleAdvertisement saleAdvertisement) {
        try {
            //sleep for 2 min
            log.info("Consumed message.. Sleeping for 2 min  : " + saleAdvertisement.toString());
            Thread.sleep(10 * 1000);//10 sec for test
            saleAdvertisement.setPriceGraphPath(UUID.randomUUID().toString() + ".png created by worker 1");
            saleAdvertisementRepository.save(saleAdvertisement);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }
}
