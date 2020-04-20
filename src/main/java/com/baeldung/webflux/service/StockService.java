package com.baeldung.webflux.service;

import com.baeldung.webflux.config.FluxPageModelPipeline;
import com.baeldung.webflux.config.SpiderFlux;
import com.baeldung.webflux.model.NewStock;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;
import sun.security.provider.ConfigFile;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;

@Service
public class StockService {


    public Flux<NewStock> streamStock() {
        System.setProperty("selenuim_config", "/Users/njuics/workspace/Spring-WebFlux/spring-webflux-streaming/config.ini");
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        FluxProcessor events = DirectProcessor.create().serialize();
        FluxSink sink = events.sink();
//        SpiderFlux<NewStock> stockSpiderFlux = new SpiderFlux<>();
//        Flux<NewStock> events = Flux.create(tFluxSink -> stockSpiderFlux.handler = tFluxSink);
//        Flux<NewStock> events = stockSpiderFlux.create();
//        events.subscribe(value -> {
//            System.out.println(ToStringBuilder.reflectionToString(value));
//        });
//        if(stockSpiderFlux.handler == null){
//            System.out.println("error hander");
//            System.exit(-1);
//        }
//        events.subscribe(value -> {
//            System.out.println(ToStringBuilder.reflectionToString(value));
//        });
        
        OOSpider.create(Site.me().setSleepTime(1000)
                , new FluxPageModelPipeline<NewStock>(sink), NewStock.class)
                .addUrl("http://quote.eastmoney.com/sh600600.html")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new DuplicateRemover() {
                    @Override
                    public boolean isDuplicate(Request request, Task task) {
                        return false;
                    }

                    @Override
                    public void resetDuplicateCheck(Task task) {

                    }

                    @Override
                    public int getTotalRequestsCount(Task task) {
                        return 0;
                    }
                }))
                .setDownloader(new SeleniumDownloader("/Users/njuics/Downloads/chromedriver")).thread(5).start();

        return events;
    }
}
