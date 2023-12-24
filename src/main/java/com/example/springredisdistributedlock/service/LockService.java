package com.example.springredisdistributedlock.service;

import com.example.springredisdistributedlock.config.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LockService {


    private final RedisDistributedLock lock;
    @Autowired
    public LockService(RedisDistributedLock lock) {
        this.lock = lock;
    }
    public void performWithLock(String lockKey) throws InterruptedException {
        if(lock.acquireLock(lockKey, 15000, TimeUnit.MILLISECONDS)){
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
