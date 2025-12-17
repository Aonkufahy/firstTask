package com.example.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;



public interface Warehouserepo extends JpaRepository<Warehouse,String> {
    boolean existsByUniqueId(String uniqueId);
}
