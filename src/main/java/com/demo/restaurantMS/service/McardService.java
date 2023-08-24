package com.demo.restaurantMS.service;

import com.demo.restaurantMS.entity.Mcard;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface McardService {
    List<Mcard> getAllMcards();
    Mcard createMcard(Mcard mcard);
    Mcard updateMcard(Mcard mcard);
    void deleteMcard(int id);
    Mcard getMcard(int id);
}
