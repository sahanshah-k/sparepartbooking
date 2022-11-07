package com.ford.sparepartbooking.service.impl;

import com.ford.sparepartbooking.entity.SparePart;
import com.ford.sparepartbooking.repository.SparePartRepository;
import com.ford.sparepartbooking.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartServiceImpl implements SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    @Override
    public void addSparePart(List<SparePart> sparePartList) {
        sparePartRepository.insert(sparePartList);
    }

    @Override
    public List<SparePart> getAllSpareParts() {
        return sparePartRepository.findAll();
    }

    @Override
    public void deleteItem(String id) {
        sparePartRepository.deleteById(id);
    }

    @Override
    public void updateItem(SparePart sparePart) {
        sparePartRepository.save(sparePart);
    }

    @Override
    public void updateStock(String id, int stock) {
        sparePartRepository.findById(id)
                .ifPresent(sparePart -> {
                    sparePart.setStock(stock);
                    sparePartRepository.save(sparePart);
                });
    }
}
