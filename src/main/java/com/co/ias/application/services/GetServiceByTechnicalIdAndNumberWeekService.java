package com.co.ias.application.services;

import com.co.ias.application.ports.input.GetServiceByTechnicalIdAndNumberWeekUseCase;
import com.co.ias.application.ports.output.OrderServiceRepository;
import com.co.ias.application.utils.TimeConstans;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

import static com.co.ias.application.utils.GetTime.*;
import static com.co.ias.application.utils.Reports.getReport;

@Service
public class GetServiceByTechnicalIdAndNumberWeekService implements GetServiceByTechnicalIdAndNumberWeekUseCase {

    private final OrderServiceRepository orderServiceRepository;
    public GetServiceByTechnicalIdAndNumberWeekService(OrderServiceRepository orderServiceRepository) {
        this.orderServiceRepository = orderServiceRepository;
    }
    @Override
    public Map<String,Double> execute(List<String> input) {

        double normalTime=0d;
        double nightTime=0d;
        double sundayTime=0d;
        double normalTimeExtra=0d;
        double nightTimeExtra=0d;
        double sundayTimeExtra=0d;
        double totalTime=0d;

        List<LocalDateTime> result= orderServiceRepository.findAllBytechnicalId(input.get(0)).stream()
                .map(x->x.getServiceStartDate())
                .filter(a->(input.get(1).equals(String.valueOf(a.get(WeekFields.of(new Locale("English")).weekOfYear())))))
                .collect(Collectors.toList());

        List<LocalDateTime> result1= orderServiceRepository.findAllBytechnicalId(input.get(0)).stream()
                .map(x->x.getServiceEndDate())
                .filter(a->(input.get(1).equals(String.valueOf(a.get(WeekFields.of(new Locale("English")).weekOfYear())))))
                .collect(Collectors.toList());
        int _aux=result.size()>=result1.size()?result.size():result1.size();


       if(result1.size()< result.size())
            result1.add(LocalDateTime.of(result.get(_aux-1).getYear(),result.get(_aux-1).getMonth().getValue(),result.get(_aux-1).getDayOfMonth(),23,59,59));
        if(result.size()< result1.size())
            result.add(LocalDateTime.of(result1.get(_aux-1).getYear(),result1.get(_aux-1).getMonth().getValue(),result1.get(_aux-1).getDayOfMonth(),0,0,0));

        for (int i = 0; i < _aux ; i++) {
            /*try {
                if(result1.get(i)==null)
                    System.out.println("in");
            }catch ( IndexOutOfBoundsException e){
                result1.add(LocalDateTime.of(result.get(i).getYear(),result.get(i).getMonth().getValue(),result.get(i).getDayOfMonth(),23,59,59));

            }
            try {
                if(result.get(i)==null)
                    System.out.println("in");
            }catch ( IndexOutOfBoundsException e){
                result.add(LocalDateTime.of(result1.get(i).getYear(),result1.get(i).getMonth().getValue(),result1.get(i).getDayOfMonth(),0,0,0));
            }*/


            if(totalTime<TimeConstans.limitHour){
                normalTime+=getNormalTime(result.get(i),result1.get(i));
                nightTime+=getNightTime(result.get(i),result1.get(i));
                sundayTime+=getSundayTime(result.get(i),result1.get(i));
                totalTime=normalTime+nightTime+sundayTime;
                if(totalTime>TimeConstans.limitHour){
                    double _auxNormalTime=getNormalTime(result.get(i),result1.get(i));
                    double _auxNightTime=getNightTime(result.get(i),result1.get(i));
                    double _auxSundayTime=getSundayTime(result.get(i),result1.get(i));
                    double extraTime=totalTime- TimeConstans.limitHour; // Cuando Tiempo se paso despues de las 48 horas
                    double _auxExtraTime=_auxNormalTime+_auxNightTime+_auxSundayTime; // Cuanto tiempo agrego antes de las 48 h
                    double timeCorrecion=_auxExtraTime-extraTime; // tiempo no extra que se debe agregar
                    normalTime-=_auxNormalTime;
                    nightTime-=_auxNightTime;
                    sundayTime-=_auxSundayTime;
                    if((totalTime-_auxExtraTime+_auxNormalTime)>TimeConstans.limitHour){
                        normalTime+=timeCorrecion;
                        normalTimeExtra+=(_auxNormalTime-timeCorrecion);
                        nightTimeExtra+=_auxNightTime;
                        sundayTimeExtra+=_auxSundayTime;
                    }
                    if((totalTime-_auxExtraTime+_auxNightTime)>TimeConstans.limitHour){
                        nightTime+=timeCorrecion;
                        nightTimeExtra+=_auxNightTime;
                        normalTime+=_auxNormalTime;
                        sundayTimeExtra+=_auxSundayTime;
                    }
                    if((totalTime-_auxExtraTime+_auxSundayTime)>TimeConstans.limitHour){
                        sundayTime+=timeCorrecion;
                        sundayTimeExtra+=_auxSundayTime;
                        normalTime+=_auxNormalTime;
                        nightTimeExtra+=_auxNightTime;
                    }
                }
            }else{
                normalTimeExtra+=getNormalTime(result.get(i),result1.get(i));
                nightTimeExtra+=getNightTime(result.get(i),result1.get(i));
                sundayTimeExtra+=getSundayTime(result.get(i),result1.get(i));
            }
            System.out.println(normalTime);
            System.out.println(nightTime);
            System.out.println(sundayTime);
            totalTime=normalTime+nightTime+sundayTime;
        }
        return getReport(normalTime,nightTime,sundayTime,normalTimeExtra,nightTimeExtra,sundayTimeExtra);
    }



}