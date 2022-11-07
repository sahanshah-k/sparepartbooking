package com.ford.sparepartbooking.service;

import com.ford.sparepartbooking.entity.SparePart;

import java.util.List;

public interface SparePartService {

    void addSparePart(List<SparePart> sparePartList);

    List<SparePart> getAllSpareParts();

    void deleteItem(String id);

    void updateItem(SparePart sparePart);

    void updateStock(String id, int stock);

}
