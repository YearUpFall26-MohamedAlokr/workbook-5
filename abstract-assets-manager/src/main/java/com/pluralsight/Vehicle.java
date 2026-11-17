package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset{
    String makeModel;
    int year;
    int odometer;

    public Vehicle(String description, String dateAquired , BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description,dateAquired,originalCost);
        this.makeModel=makeModel;
        this.year=year;
        this.odometer=odometer;
    }
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    @Override
    public BigDecimal getValue() {
        // A car's value is determined as
        // 0-3 years old  - 3% reduced value of cost per year
        // 4-6 years old  - 6% reduced value of cost per year
        // 7-10 years old - 8% reduced value of cost per year
        // over 10 years old - $1000.00
        // MINUS  reduce final value by 25% if over 100,000 miles
        //     unless makeModel contains word Honda or Toyota
        int currentDate = LocalDate.now().getYear();
        int yearDifference = currentDate - this.year;
        BigDecimal value = super.getValue();
        boolean isHondaOrToyota = makeModel.contains("Honda") || makeModel.contains("Toyota");
        float reduceValue=0;
        if(yearDifference < 4){
            reduceValue= 1 - (yearDifference * 0.03f);
        }else if(yearDifference >= 4&&yearDifference < 7){
            reduceValue= 1 - (yearDifference * 0.06f);
        }else if(yearDifference >= 7&&yearDifference < 10){
            reduceValue= 1 - (yearDifference * 0.08f);
        }else if(yearDifference >= 10){
            value= BigDecimal.valueOf(1000);
        }if(odometer > 100000 && !isHondaOrToyota){
            reduceValue= reduceValue-0.25f;
        }
        value= value.multiply(BigDecimal.valueOf(reduceValue));
        return value;
    }
}
