package com.hamrose.rentalservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hamrose.rentalservice.model.Tenant;
import com.hamrose.rentalservice.repository.TenantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;

    public List<Tenant> getTenantDetails(String houseNumber) {
        return tenantRepository.findByHouseNumber(houseNumber);
    }
    //mock data for testing

}
