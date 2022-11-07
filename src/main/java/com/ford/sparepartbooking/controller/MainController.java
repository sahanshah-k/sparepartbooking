package com.ford.sparepartbooking.controller;

import com.ford.sparepartbooking.entity.SparePart;
import com.ford.sparepartbooking.model.CommonResponseMessage;
import com.ford.sparepartbooking.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/")
public class MainController {

    @Autowired
    private SparePartService sparePartService;

    @RolesAllowed("ROLE_ADMIN")
    @PostMapping("sparePart/addItems")
    public ResponseEntity<CommonResponseMessage> addSparePartsItem(@RequestBody List<SparePart> sparePartList) {
        sparePartService.addSparePart(sparePartList);
        return ResponseEntity.ok(new CommonResponseMessage(0, "Success"));
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("sparePart/viewAllItems")
    public ResponseEntity<List<SparePart>> getAllSpareParts() {
        return ResponseEntity.ok(sparePartService.getAllSpareParts());
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping("sparePart/deleteItem/{id}")
    public ResponseEntity<CommonResponseMessage> deleteItem(@PathVariable("id") String id) {
        sparePartService.deleteItem(id);
        return ResponseEntity.ok(new CommonResponseMessage(0, "Success"));
    }

    @RolesAllowed("ROLE_ADMIN")
    @PutMapping("sparePart/updateItem")
    public ResponseEntity<CommonResponseMessage> updateItem(@RequestBody SparePart sparePart) {
        sparePartService.updateItem(sparePart);
        return ResponseEntity.ok(new CommonResponseMessage(0, "Success"));
    }

    @RolesAllowed("ROLE_ADMIN")
    @PutMapping("sparePart/updateStock/{id}/{stock}")
    public ResponseEntity<CommonResponseMessage> updateStock(@PathVariable("id") String id, @PathVariable("stock") int stock) {
        sparePartService.updateStock(id, stock);
        return ResponseEntity.ok(new CommonResponseMessage(0, "Success"));
    }

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<CommonResponseMessage> handleException() {
        return ResponseEntity.ok(new CommonResponseMessage(1, "One of the SparePart(s) is already present in database"));
    }

}
