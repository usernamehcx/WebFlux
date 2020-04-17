package com.baeldung.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.time.LocalDateTime;

@HelpUrl("http://so.eastmoney.com/web/s?keyword=%E9%9D%92%E5%B2%9B%E5%95%A4%E9%85%92")
@TargetUrl("http://quote.eastmoney.com/sh600600.html")
public class NewStock {
    @ExtractBy(value = "/html/body/div[10]/h2/text()")
    private String stockName;

    @ExtractBy(value = "/html/body/div[10]/b/text()")
    private String stockCode;

    @ExtractBy(value = "/html/body/div[11]/div[1]/div[2]/strong/text()")
    private String price;
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[2]/text()")
//    private String toadyStartPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[2]/text()")
//    private String yestodayEndPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[4]/text()")
//    private String highestPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[4]/text()")
//    private String lowestPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[6]/text()")
//    private String limitUpPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[6]/text()")
//    private String limitDownPrice;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[8]/text()")
//    private String turnoverRate;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[8]/text()")
//    private String ratio;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[10]/text()")
//    private String volume;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[10]/text()")
//    private String turnOver;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[12]/text()")
//    private String priceToEarningsRatio;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[12]/text()")
//    private String priceToBookRatio;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[1]/td[14]/text()")
//    private Double marketCap;
//
//    @ExtractBy(value = "/html/body/div[11]/div[3]/table/tbody/tr[2]/td[14]/text()")
//    private String circulationMarketCap;
}
