package com.rex.pharmaC.service;

import com.rex.pharmaC.entity.Medicine;
import com.rex.pharmaC.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public String addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return "Medicine is added successfully to Service Class!";
    }


    public List<Medicine> getMedicineList() {
        return medicineRepository.findAll();
    }


    public Optional<Medicine> getMedicineById(long id) {
        return medicineRepository.findById(id);


    }


    public String updateMedicine(Medicine medicine) {
        Optional<Medicine> medicineDetails = medicineRepository.findById(medicine.getMedId());
        if(medicineDetails.isPresent()){
            medicineRepository.save(medicine);
            return "Medicine is updated in Service Class";
        }
        else {
            return "Medicine not  found";
        }
    }



    public String deleteMedicine(long id) {
        medicineRepository.deleteById(id);
        return "Medicine deleted successfully";

    }

}
