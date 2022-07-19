package com.co.ias.infrastructure.configurations;

import com.co.ias.infrastructure.models.OrderServiceDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoOrderService extends MongoRepository<OrderServiceDTO,String> {
}
