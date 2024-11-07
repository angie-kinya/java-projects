package com.hamrosesuites.tenantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamrosesuites.tenantservice.model.Tenant;
import com.hamrosesuites.tenantservice.repository.TenantRepository;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
}
