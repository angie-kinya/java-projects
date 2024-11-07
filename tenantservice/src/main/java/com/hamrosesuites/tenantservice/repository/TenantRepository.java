package com.hamrosesuites.tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamrosesuites.tenantservice.model.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long>{

}
