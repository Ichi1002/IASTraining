package com.co.ias.infrastructure.controllers;


import com.co.ias.application.ports.input.CreateServiceUseCase;
import com.co.ias.application.ports.input.GetServiceByTechnicalIdAndNumberWeekUseCase;
import com.co.ias.infrastructure.models.OrderServiceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderService")
public class OrderServiceController {
    private final CreateServiceUseCase createServiceUseCase;
    private final GetServiceByTechnicalIdAndNumberWeekUseCase getServiceByTechnicalIdAndNumberWeekUseCase;

    public OrderServiceController(CreateServiceUseCase createServiceUseCase, GetServiceByTechnicalIdAndNumberWeekUseCase getServiceByTechnicalIdAndNumberWeekUseCase) {
        this.createServiceUseCase = createServiceUseCase;
        this.getServiceByTechnicalIdAndNumberWeekUseCase = getServiceByTechnicalIdAndNumberWeekUseCase;
    }

    @PostMapping()
    public ResponseEntity<OrderServiceDTO> createOrderService(@RequestParam OrderServiceDTO orderServiceDTO){
        OrderServiceDTO orderServiceDTOOutput = createServiceUseCase.execute(orderServiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceDTOOutput);
    }


}
