package com.co.ias.infrastructure.configurations;

import com.co.ias.infrastructure.models.OrderServiceDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAOrderService extends CrudRepository<OrderServiceDAO,Long> {

    List<OrderServiceDAO> findAllByTechnicalIdOrderByServiceStartDate(String id);
    List<OrderServiceDAO> findAllByTechnicalId(String id);
}


