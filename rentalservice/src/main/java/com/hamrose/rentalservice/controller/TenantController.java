package com.hamrose.rentalservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hamrose.rentalservice.model.Tenant;
import com.hamrose.rentalservice.service.TenantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {
    
    private final TenantService tenantService;

    @GetMapping("/{houseNumber}")
    public List<Tenant> getTenant(@PathVariable String houseNumber) {
        List<Tenant> tenant = tenantService.getTenantDetails(houseNumber);
        if (tenant != null) {
            return tenant;
        } else {
            return Collections.emptyList();
        }
    }
}
