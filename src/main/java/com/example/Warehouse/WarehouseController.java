package com.example.Warehouse;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class WarehouseController {
    private final WarehouseService warehouseService; // Declare the dependency
    private static final Logger logger = LoggerFactory.getLogger(WarehouseService.class);

    // Inject the service via constructor
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping("/own")
    public ResponseEnvilope<String> addRequest(@RequestBody Warehouse warehouse) {
        return warehouseService.addRequest(warehouse);








    }

}
