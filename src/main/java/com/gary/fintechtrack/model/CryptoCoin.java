package com.gary.fintechtrack.model;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Data
public class CryptoCoin {

    private String id;
    private String symbol;
    private String name;
    private double current_price;
    private long market_cap;
    private String image;

    //This all is to make the response of the market cap more readable
    public String getFormattedMarketCap() {
        return formatLargePrice(market_cap);
    }

    public String getFormattedCurrentPrice() {
        return formatLargePrice((long) current_price);
    }

    private String formatLargePrice(long number) {
        //Billion
        if (number >= 1_000_000_000) {
            return NumberFormat.getNumberInstance().format(number / 1_000_000_000) + "B";
        }
        //Million
        else if (number >= 1_000_000) {
            return NumberFormat.getNumberInstance().format(number / 1_000_000) + "M";
        }
        //Thousand
        else if (number >= 1_000) {
            return NumberFormat.getNumberInstance().format(number / 1_000) + "K";
        }
        //Regular
        else {
            return NumberFormat.getNumberInstance().format(number);
        }


    }

}


