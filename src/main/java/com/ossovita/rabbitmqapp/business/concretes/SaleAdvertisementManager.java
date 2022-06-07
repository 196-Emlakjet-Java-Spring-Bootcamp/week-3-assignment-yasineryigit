package com.ossovita.rabbitmqapp.business.concretes;

import com.ossovita.rabbitmqapp.business.abstracts.SaleAdvertisementService;
import com.ossovita.rabbitmqapp.core.dataAccess.SaleAdvertisementRepository;
import com.ossovita.rabbitmqapp.core.dataAccess.UserRepository;
import com.ossovita.rabbitmqapp.core.entities.SaleAdvertisement;
import com.ossovita.rabbitmqapp.core.entities.User;
import com.ossovita.rabbitmqapp.core.entities.dto.CreateSaleAdvertisementDto;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleAdvertisementManager implements SaleAdvertisementService {

    SaleAdvertisementRepository saleAdvertisementRepository;
    UserRepository userRepository;
    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    public SaleAdvertisementManager(SaleAdvertisementRepository saleAdvertisementRepository, UserRepository userRepository, RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.saleAdvertisementRepository = saleAdvertisementRepository;
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    @Override
    public CreateSaleAdvertisementDto createSaleAdvertisement(CreateSaleAdvertisementDto createSaleAdvertisementDto) {
        //write to db
        User user = User.builder()
                .userName(createSaleAdvertisementDto.getUserName())
                .userMail(createSaleAdvertisementDto.getUserMail())
                .build();

        User userInDB = userRepository.save(user);

        SaleAdvertisement saleAdvertisement = SaleAdvertisement.builder()
                .title(createSaleAdvertisementDto.getTitle())
                .photo(createSaleAdvertisementDto.getPhoto())
                .detailMessage(createSaleAdvertisementDto.getDetailMessage())
                .userFk(userInDB.getUserPk()).build();

        SaleAdvertisement saleAdvertisementInDB = saleAdvertisementRepository.save(saleAdvertisement);

        //send message to queue by using direct exchange
        rabbitTemplate.convertAndSend(directExchange.getName(), routingName, saleAdvertisementInDB);

        return createSaleAdvertisementDto;
    }

    @Override
    public List<SaleAdvertisement> getAllSaleAdvertisements() {
        return saleAdvertisementRepository.findAll();
    }
}
