package com.co.ias.application.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class GetTime {

    public static Double getNormalTime(LocalDateTime startingDate, LocalDateTime endingDate){

        double totalNormalTime=0d;
        double initialTimed=0d;
        double finalTimed=0d;
        double initialTime=startingDate.getHour()+startingDate.getMinute()/60d+startingDate.getSecond()/3600d;
        double finalTime=endingDate.getHour()+endingDate.getMinute()/60d+endingDate.getSecond()/3600d;

        if(!startingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            initialTimed=initialTime;
            finalTimed=finalTime;
            if(startingDate.getDayOfYear()==endingDate.getDayOfYear()){
                if (initialTime <= 7)
                    initialTimed=7d;
                if (initialTime >= 20)
                    initialTimed=20d;
                if(finalTime<=7)
                    finalTimed=7d;
                if(finalTime>=20)
                    finalTimed=20d;
                totalNormalTime=finalTimed-initialTimed;
            }else{
                if (initialTime >= 7 && initialTime <= 20)
                    initialTimed=20d-initialTime;
                if(initialTime<7)
                    initialTimed=0d;
                if(initialTime>20d)
                    initialTimed=0d;
                if(finalTime>=7 &&finalTime<=20)
                    finalTimed=finalTime-7d;
                if(finalTime<7)
                    finalTimed=0d;
                if(finalTime>20d)
                    finalTimed=0d;
                totalNormalTime=initialTimed+finalTimed;
            }
        }
        return totalNormalTime;
    }
    public static Double[] getNightTime(LocalDateTime startingDate, LocalDateTime endingDate){
        //double totalNighTime=0d;
        Double totalNighTime[]=new Double[2];
        if(!startingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            double initialTime=startingDate.getHour()+startingDate.getMinute()/60d+startingDate.getSecond()/3600d;
            double finalTime=endingDate.getHour()+endingDate.getMinute()/60d+endingDate.getSecond()/3600d;
            double initialTimed=0d;
            double finalTimed=0d;
            if(startingDate.getDayOfYear()==endingDate.getDayOfYear()){
                if (initialTime <= 7 && finalTime<=7){
                    totalNighTime[0]=finalTime-initialTime;
                    totalNighTime[1]=0d;
                }
                if (initialTime <= 7 && finalTime>=7){
                    totalNighTime[0]=7d-initialTime;
                    totalNighTime[1]=0d;
                }

                if (initialTime >= 7 && finalTime<=20){
                    totalNighTime[0]=0d;
                    totalNighTime[1]=0d;
                }
                if (initialTime >=20 ){
                    totalNighTime[0]=0d;
                    totalNighTime[1]=finalTime-20d;
                }
                if (initialTime <=7 && finalTime>=20d ){
                    totalNighTime[0]=7d-initialTime;
                    totalNighTime[1]=finalTime-20d;
                }
                if (initialTime >=7 && initialTime <=20 && finalTime>=20d ){
                    totalNighTime[0]=0d;
                    totalNighTime[1]=finalTime-20d;
                }

                /*if (initialTime < 7)
                    initialTimed=7d-initialTime;
                if (initialTime > 20)
                    initialTimed=finalTime-20d;
                if (finalTime < 7)
                    finalTimed=7d-finalTime;
                if (finalTime > 20)
                    finalTimed=finalTime-20d;*/

            }else{
                if (initialTime <= 20)
                    initialTimed=4d;
                if (initialTime > 20)
                    initialTimed=24d-initialTime;
                if (finalTime <= 7)
                    finalTimed=finalTime;
                if(finalTime > 7)
                    finalTimed=7d;
                //totalNighTime=finalTimed+initialTimed;
            }
            //totalNighTime=finalTimed+initialTimed;

        }else{
        totalNighTime[0]=0d;
        totalNighTime[1]=0d;}
        return totalNighTime;
    }


    public static Double getSundayTime(LocalDateTime startingDate, LocalDateTime endingDate){
        double totalSundayTime=0d;
        double initialTime=startingDate.getHour()+startingDate.getMinute()/60d+startingDate.getSecond()/3600d;
        double endTime = endingDate.getHour()+endingDate.getMinute()/60d+endingDate.getSecond()/3600d;

        if(startingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) && endingDate.getDayOfWeek().equals(DayOfWeek.MONDAY))
            totalSundayTime=24d-initialTime;
        else if (startingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) && endingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
            totalSundayTime=endTime-initialTime;
        else
            totalSundayTime=0;



        return totalSundayTime;
    }
    }



