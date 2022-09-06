package com.example.sept_project.service;

import com.example.sept_project.model.Doctor;
import com.example.sept_project.repository.DoctorRepository;
import com.example.sept_project.service.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DoctorServiceImp implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
