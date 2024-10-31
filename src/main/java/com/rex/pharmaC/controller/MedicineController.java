package com.rex.pharmaC.controller;

import com.rex.pharmaC.entity.Medicine;
import com.rex.pharmaC.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public String addMedicine(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }

    @GetMapping
    public List<Medicine> getMedicineList(){
        return medicineService.getMedicineList();
    }

    @GetMapping("/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable long id){
        return medicineService.getMedicineById(id);
    }

    @PutMapping
    public String updateMedicine(@RequestBody Medicine medicine){
        return medicineService.updateMedicine(medicine);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable long id){
        return medicineService.deleteMedicine(id);
    }
}
