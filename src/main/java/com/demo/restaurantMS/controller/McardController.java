package com.demo.restaurantMS.controller;

import com.demo.restaurantMS.entity.Mcard;
import com.demo.restaurantMS.service.McardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class McardController {
    private final McardService mcardService;

    public McardController(McardService mcardService) {
        this.mcardService = mcardService;
    }
    @GetMapping(path = "/mcards")
    public List<Mcard> getAllMcards(){
        return mcardService.getAllMcards();
    }
    @PostMapping(path = "/mcards")
    public Mcard createMcard(@RequestBody Mcard mcard){
        return mcardService.createMcard(mcard);
    }
    @PutMapping(path = "/mcards")
    public Mcard updateMcard(@RequestBody Mcard mcard){
        Mcard updatedMcard = mcardService.updateMcard(mcard);
        if (updatedMcard==null){
            return new Mcard();
        }
        return updatedMcard;
    }
    @DeleteMapping(path = "/mcards/{id}")
    public void deleteMcard(@PathVariable int id){
        mcardService.deleteMcard(id);
    }
    @GetMapping(path = "/mcards/{id}")
    public Mcard getMcard(@PathVariable int id){
        return mcardService.getMcard(id);
    }
}
