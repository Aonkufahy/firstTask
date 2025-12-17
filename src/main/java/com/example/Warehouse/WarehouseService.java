package com.example.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WarehouseService {
    @Autowired
    private final Warehouserepo warehouserepo;


    public WarehouseService(Warehouserepo warehouserepo) {
        this.warehouserepo = warehouserepo;
    }
    private static final Logger logger = LoggerFactory.getLogger(WarehouseService.class);



    public ResponseEnvilope addRequest(Warehouse warehouse){
        ResponseEnvilope responseEnvilope =new ResponseEnvilope<>() ;
        try {
            Objects.requireNonNull(warehouse.getUniqueId(), "Cannot add request: Unique ID must be specified.");
            Objects.requireNonNull(warehouse.getFromCurrency(), "Cannot add request: Ordering Currency must be specified.");
            Objects.requireNonNull(warehouse.getToCurrency(), "Cannot add request: To Currency must be specified.");
            Objects.requireNonNull(warehouse.getTimeStamp(), "Cannot add request: Time Stamp must be specified.");

            if (warehouserepo.existsByUniqueId(warehouse.getUniqueId())) {
                responseEnvilope.setStatus("Failed");
                responseEnvilope.setMessage("ID already exists");
                responseEnvilope.setData(warehouse);
                logger.info("ID already exists in Warehouse");
                return responseEnvilope;
            } else {
                responseEnvilope.setStatus("Success");
                responseEnvilope.setMessage("ID added successfully");
                responseEnvilope.setData(warehouse);
                warehouserepo.save(warehouse);
                logger.info("the warehouse has been saved successfully");
                return responseEnvilope;
            }
        }catch(NullPointerException e) {

            responseEnvilope.setStatus("Failed");
            responseEnvilope.setMessage("No NUll Values Allowed");
            responseEnvilope.setData(warehouse);
            logger.info("No NUll Values Allowed");
            return responseEnvilope;
        }
        }

    }







