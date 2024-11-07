package com.hamrosesuites.tenantservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.hamrosesuites.tenantservice.model.Tenant;
import com.hamrosesuites.tenantservice.service.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @PostMapping
    public Tenant saveTenant(@RequestBody Tenant tenant) {
        return tenantService.saveTenant(tenant);
    }
}
