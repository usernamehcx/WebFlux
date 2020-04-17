package com.baeldung.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.function.Consumer;
import java.util.function.LongConsumer;


public class SpiderFlux<T> {
    T[] buffer;

    public FluxSink handler;

    public SpiderFlux() {
    }

    public Flux<T> create(){
        return Flux.create(tFluxSink -> handler = tFluxSink);
    }

    public void addMessage(T msg){
        handler.next(msg);
    }

    public void subscribe(CoreSubscriber coreSubscriber) {

    }

    public Flux<T> create(PageModelPipeline<T> pipeline, Class<?> classz, String entryUrl){
        OOSpider.create(Site.me().setSleepTime(1000)
                , new FluxPageModelPipeline(handler), classz)
                .addUrl(entryUrl).thread(5).run();
        return null;
    }
}
