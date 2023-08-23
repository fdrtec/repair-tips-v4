package com.api.repairtips.domain.service.util;

import java.time.Duration;
import java.time.LocalDateTime;


import lombok.Data;

@Data
public class DateCalcService {

    LocalDateTime start;
    LocalDateTime finish;
    double basicPayment;    
    final double pricePerHour = 10.00; 
    final double pricePerDay = 120.00;

    public void calculateBetweenDate(){
        double minutes = Duration.between(getStart(), getFinish()).toMinutes();
        double hours = minutes / 60;
        
        if (hours <= 12) {                      
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            basicPayment = pricePerDay * Math.ceil(hours/ 24.0);
        }
    }
}

    

