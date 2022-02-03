package com.training.spring.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduleTest {

    int count = 0;

    @Scheduled(fixedDelay = 10_000)
    public void runHere() {
        System.out.println("Schedule " + this.count++);
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void runHere2() {
        System.out.println("Schedule " + this.count++);
    }

}
