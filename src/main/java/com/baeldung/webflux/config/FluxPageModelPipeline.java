package com.baeldung.webflux.config;

import com.baeldung.webflux.model.NewStock;
import lombok.SneakyThrows;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.FluxSink;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;


public class FluxPageModelPipeline<T> implements PageModelPipeline<T> {

    public FluxSink handler;

    public FluxPageModelPipeline(){
    }

    public FluxPageModelPipeline(FluxSink fluxSink){
        handler = fluxSink;
    }

    @Override
    public void process(T o, Task task) {
        if(handler == null){
            System.exit(-1);
        }
        if (o != null) {
//            System.out.println(o.toString());
            NewStock newStock = (NewStock)o;
            newStock.setTimestamp(System.currentTimeMillis());
            handler.next(newStock);
        }
    }
}
