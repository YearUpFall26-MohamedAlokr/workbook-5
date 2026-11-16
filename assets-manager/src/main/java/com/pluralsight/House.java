package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset{
    private String address;
    int condition;
    int squareFoot;
    int lotSize;
    public House(String description, String dateAcquired, BigDecimal originalCost) {
       super(description, dateAcquired, originalCost);
       this.address = address;
       this.condition = condition;
       this.squareFoot = squareFoot;
       this.lotSize = lotSize;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setCondition(int condition) {
        this.condition = condition;
    }
    public int getCondition() {
        return condition;
    }
    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }
    public int getSquareFoot() {
        return squareFoot;
    }
    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    public int getLotSize() {
        return lotSize;
    }
    @Override
    public BigDecimal getValue() {
        // A house's value is determined as
        // $180.00 per square foot (excellent)
        // $130.00 per square foot (good)
        // $90.00 per square foot (fair)
        // $80.00 per square foot (poor)
        // PLUS  25 cents per square foot of lot size
        double valuePerSqFt;
        switch (condition) {
            case 1:
                valuePerSqFt = 180;
                break;
            case 2:
                valuePerSqFt = 130;
                break;
            case 3:
                valuePerSqFt = 90;
                break;
            case 4:
                valuePerSqFt = 80;
                break;
            default:
                valuePerSqFt = 0;
        }

        BigDecimal houseValue = BigDecimal.valueOf(squareFoot * valuePerSqFt);

        BigDecimal lotValue = BigDecimal.valueOf(lotSize * 0.25);

        return (houseValue.add(lotValue));
    }

}
