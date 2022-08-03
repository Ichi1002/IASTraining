package com.co.ias.application.services;


import com.co.ias.application.ports.output.OrderServiceRepository;
import com.co.ias.infrastructure.models.OrderServiceDTO;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GetServiceByTechnicalIdAndNumberWeekServiceTest {

    private GetServiceByTechnicalIdAndNumberWeekService getServiceByTechnicalIdAndNumberWeekService;

    @MockBean
    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @BeforeEach
    void setUp(){
        GetServiceByTechnicalIdAndNumberWeekService getServiceByTechnicalIdAndNumberWeekService = new GetServiceByTechnicalIdAndNumberWeekService(orderServiceRepository);
    }

    @Test
    public void prueba1(){
        List<String> lista  =new ArrayList<>();
        lista.add("1");
        lista.add("2");
        Map<String,Double> relationParams = new HashMap<String,Double>();

        relationParams.put("Resone1",2d);

        when(getServiceByTechnicalIdAndNumberWeekService.execute(lista)).thenReturn(relationParams);

        Assert.assertEquals(relationParams,getServiceByTechnicalIdAndNumberWeekService.execute(lista));

    }



}