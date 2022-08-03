package com.co.ias.application.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.co.ias.application.utils.GetTime.*;

public class GetTimeTest {
    @Test
    public void return_total_normal_time_if_hours_between_7_and_20(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,7,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,00,00);
        Assert.assertEquals(13, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_hours_between_19_and_20(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,00,00);
        Assert.assertEquals(1, getNormalTime(startDate,endDate),0);
    }

    @Test
    public void return_total_normal_time_if_hours_between_19_30_and_20_30(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,19,30,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,30,00);
        Assert.assertEquals(0.5, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_hours_between_6_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,8,00,00);
        Assert.assertEquals(1, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_hours_between_12_and_22(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,12,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,22,00,00);
        Assert.assertEquals(8, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_hours_between_6_and_22(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,22,00,00);
        Assert.assertEquals(13, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_sunday(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,16,22,00,00);
        Assert.assertEquals(0, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_different_day_and_hours_between_23_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,23,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(0, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_different_day_and_hours_between_20_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,20,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(0, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_different_day_and_hours_between_19_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(1, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_different_day_and_hours_between_16_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,16,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(4, getNormalTime(startDate,endDate),0);
    }
    @Test
    public void return_total_normal_time_if_different_day_and_hours_between_22_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,22,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,8,00,00);
        Assert.assertEquals(1, getNormalTime(startDate,endDate),0);
    }


    @Test
    public void return_total_night_time_if_hours_between_7_and_20(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,7,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,00,00);
        Assert.assertEquals(0, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_hours_between_19_and_20(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,00,00);
        Assert.assertEquals(0, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_hours_between_6_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,8,00,00);
        Assert.assertEquals(1, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_hours_between_12_and_22(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,12,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,22,00,00);
        Assert.assertEquals(2, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_hours_between_6_and_22(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,22,00,00);
        Assert.assertEquals(3, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_sunday(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,16,22,00,00);
        Assert.assertEquals(0, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_different_day_and_hours_between_23_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,23,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(2, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_different_day_and_hours_between_20_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,20,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,1,00,00);
        Assert.assertEquals(5, getNightTime(startDate,endDate),0);
    }
    @Test
    public void return_total_night_time_if_different_day_and_hours_between_23_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,23,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,8,00,00);
        Assert.assertEquals(8, getNightTime(startDate,endDate),0);
    }
   @Test
    public void return_total_night_time_if_different_day_and_hours_between_19_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,11,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,8,00,00);
        Assert.assertEquals(11, getNightTime(startDate,endDate),0);
    }


    @Test
    public void return_total_sunday_time_if_hours_between_7_and_20_and_not_sunday(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,12,7,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,12,20,00,00);
        Assert.assertEquals(0, getSundayTime(startDate,endDate),0);
    }
    @Test
    public void return_total_sunday_time_if_hours_between_19_and_20(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,19,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,16,20,00,00);
        Assert.assertEquals(1, getSundayTime(startDate,endDate),0);
    }
    @Test
    public void return_total_sunday_time_if_hours_between_6_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,6,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,16,8,00,00);
        Assert.assertEquals(2, getSundayTime(startDate,endDate),0);
    }


    @Test
    public void return_total_sunday_time_if_different_day_and_hours_between_23_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,23,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,17,1,00,00);
        Assert.assertEquals(1, getSundayTime(startDate,endDate),0);
    }
    @Test
    public void return_total_sunday_time_if_different_day_and_hours_between_20_and_1(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,20,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,17,1,00,00);
        Assert.assertEquals(4, getSundayTime(startDate,endDate),0);
    }
    @Test
    public void return_total_sunday_time_if_different_day_and_hours_between_23_and_8(){
        LocalDateTime startDate=LocalDateTime.of(2022,1,16,0,00,00);
        LocalDateTime endDate=LocalDateTime.of(2022,1,17,5,00,00);
        Assert.assertEquals(24, getSundayTime(startDate,endDate),0);
    }

}