package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Endpoint {

    private static final AtomicLong INDEX=new AtomicLong(0);


    @GetMapping("/users")
    public ResponseEntity get(@RequestParam(defaultValue = "10",required = false) Integer a,@RequestParam(defaultValue = "1",required = false) Integer w,@RequestParam(defaultValue = "10",required = false) Integer b,@RequestParam(defaultValue = "10",required = false) Long k){

        long i = INDEX.incrementAndGet();
        if(Objects.equals(Long.MAX_VALUE,i)){
            INDEX.getAndSet(0);
        }
        double v =a* Math.sin(w * i + b) + k;
        long sleep=(long)v;
        Result result=new Result();
        result.setId(i);
        result.setSort(sleep);
        result.setUserName("user"+i);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(result);
    }


}
