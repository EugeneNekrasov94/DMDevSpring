package com.example.listener.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WriteEntityListener {
    @EventListener(condition = "#root.args[0].accessType.name() == 'CREATE'")
    @Order(1000000)
    public void acceptEntityWrite(EntityEvent event) {
        log.info("Entity created " + event);
    }
}
