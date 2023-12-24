package com.example.springredisdistributedlock.service;

import com.example.springredisdistributedlock.config.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class CronLockService {

    private final RedisDistributedLock lock;
    private final String LOCK_KEY = "lock-key";

    @Autowired
    public CronLockService(RedisDistributedLock lock) {
        this.lock = lock;
    }

    @Scheduled(fixedDelay = 15000L)
    public void cronMethod() throws InterruptedException {
        if(lock.acquireLock(LOCK_KEY, 15000, TimeUnit.MILLISECONDS)){
            log.info("Lock is Acquired... Operation started");

            Thread.sleep(200);
            log.info("Operation Complete... ");
            // if you want, you can release lock.
            // lock.releaseLock(lockKey);
        } else {
            log.info("Failed to acquire the lock .. Resource is Busy");
        }
    }
}
