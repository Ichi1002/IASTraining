package com.co.ias.application.utils;

import java.util.HashMap;
import java.util.Map;

public class Reports {

    public static Map<String,Double> getReport(double normalTime, double nightTime, double sundayTime, double normalExtraTime, double nigthExtraTime, double sundayExtraTime){
        Map<String,Double> relationParams = new HashMap<String,Double>();
        relationParams.put("horasNormales", normalTime);
        relationParams.put("horasNormales", normalTime);
        relationParams.put("horasNocturnas", nightTime);
        relationParams.put("horasDominicales", sundayTime);
        relationParams.put("horasNormalesExtras", normalExtraTime);
        relationParams.put("horasNocturnasExtras", nigthExtraTime);
        relationParams.put("horasDominicalesExtras", sundayExtraTime);
        return  relationParams;
    }
}
