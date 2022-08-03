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
            if(totalTime<TimeConstans.limitHour){
                normalTime+=getNormalTime(result.get(i),result1.get(i));
                nightTime+=getNightTime(result.get(i),result1.get(i));
                sundayTime+=getSundayTime(result.get(i),result1.get(i));
                totalTime=normalTime+nightTime+sundayTime;
                if(totalTime>TimeConstans.limitHour){
                    double _auxNormalTime=getNormalTime(result.get(i),result1.get(i));
                    double _auxNightTime=getNightTime(result.get(i),result1.get(i));
                    double _auxSundayTime=getSundayTime(result.get(i),result1.get(i));

                    normalTime-=_auxNormalTime;
                    nightTime-=_auxNightTime;
                    sundayTime-=_auxSundayTime;

                    totalTime-=(_auxNormalTime+_auxNightTime+_auxSundayTime);
                    System.out.println(totalTime);

                    double _auxi=48d-totalTime;

                    if(_auxNormalTime>=_auxi){
                        normalTime+=_auxi;
                        normalTimeExtra+=(_auxNormalTime-_auxi);
                        nightTimeExtra+=_auxNightTime;
                        sundayTimeExtra+=_auxSundayTime;
                    } else if (_auxNightTime>=_auxi) {
                        normalTime+=_auxNormalTime;
                        nightTime+=_auxi;
                        nightTimeExtra+=(_auxNightTime-_auxi);
                        sundayTimeExtra+=_auxSundayTime;

                    }else if(_auxSundayTime>=_auxi){
                        normalTime+=_auxNormalTime;
                        nightTime+=_auxNightTime;
                        sundayTimeExtra+=(_auxSundayTime-_auxi);
                        sundayTime+=_auxi;
                    }


                }
            }else{
                normalTimeExtra+=getNormalTime(result.get(i),result1.get(i));
                nightTimeExtra+=getNightTime(result.get(i),result1.get(i));
                sundayTimeExtra+=getSundayTime(result.get(i),result1.get(i));
            }

            totalTime=normalTime+nightTime+sundayTime;
        }
        return getReport(normalTime,nightTime,sundayTime,normalTimeExtra,nightTimeExtra,sundayTimeExtra);
    }



}