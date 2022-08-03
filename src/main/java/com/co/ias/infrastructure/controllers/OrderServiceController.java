package com.co.ias.infrastructure.controllers;


import com.co.ias.application.ports.input.CreateServiceUseCase;
import com.co.ias.application.ports.input.GetServiceByTechnicalIdAndNumberWeekUseCase;
import com.co.ias.infrastructure.models.OrderServiceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orderService")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderServiceController {
    private final CreateServiceUseCase createServiceUseCase;
    private final GetServiceByTechnicalIdAndNumberWeekUseCase getServiceByTechnicalIdAndNumberWeekUseCase;

    public OrderServiceController(CreateServiceUseCase createServiceUseCase, GetServiceByTechnicalIdAndNumberWeekUseCase getServiceByTechnicalIdAndNumberWeekUseCase) {
        this.createServiceUseCase = createServiceUseCase;
        this.getServiceByTechnicalIdAndNumberWeekUseCase = getServiceByTechnicalIdAndNumberWeekUseCase;
    }

    @PostMapping()
    public ResponseEntity<?> createOrderService(@RequestBody OrderServiceDTO orderServiceDTO){
    try{
        OrderServiceDTO orderServiceDTOOutput = createServiceUseCase.execute(orderServiceDTO);
            if (orderServiceDTOOutput.equals(new OrderServiceDTO()))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fecha Inicio debe ser inferior a la Fecha Fin");
            return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceDTOOutput);
        }catch (IllegalArgumentException | NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    }

    @GetMapping("/{idTechnicial}/{week}")
    public ResponseEntity<?> getReport(@PathVariable String idTechnicial, @PathVariable String week){
        List<String> elememts = new ArrayList();
        elememts.add(idTechnicial);
        elememts.add(week);

        return ResponseEntity.status(HttpStatus.OK).body(getServiceByTechnicalIdAndNumberWeekUseCase.execute(elememts));

    }





}
