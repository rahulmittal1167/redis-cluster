package com.example.springredisdistributedlock.controller;

import com.example.springredisdistributedlock.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockController {

    @Autowired
    private LockService lockService;

    @GetMapping("/perform/{lockKey}")
    public String performOperation(@PathVariable String lockKey) throws InterruptedException{
        lockService.performWithLock(lockKey);
        return "Operation Complete";
    }

}
