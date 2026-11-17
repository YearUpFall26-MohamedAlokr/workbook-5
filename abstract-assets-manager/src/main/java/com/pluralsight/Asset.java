package com.pluralsight;

import java.math.BigDecimal;

public class Asset {
    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;
    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }
    public String getDateAcquired() {
        return dateAcquired;
    }
    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }
    public BigDecimal getValue() {
        return originalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Description: "+description+"\n");
        sb.append("Date Acquired: "+dateAcquired+"\n");
        sb.append("Original Cost: $"+originalCost+"\n");
        sb.append("Current Value: $"+getValue());
        return sb.toString();
    }
}
