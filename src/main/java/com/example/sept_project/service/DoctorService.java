package com.example.sept_project.service;

import com.example.sept_project.exeception.DoctorNotFoundException;
import com.example.sept_project.model.Doctor;
import com.example.sept_project.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() ->
                new DoctorNotFoundException(
                        String.format("Doctor not found with id: %s", doctorId)
                )
        );
    }

    public Doctor updateDoctor(Long doctorId, Doctor doctor) {
        return doctorRepository.findById(doctorId).map(curDoctor -> {
            curDoctor.setName(doctor.getName());
            curDoctor.setClinic(doctor.getClinic());
            return doctorRepository.save(curDoctor);
        }).orElseGet(() -> addDoctor(doctor));
    }

    public void deleteDoctor(Long doctorId) {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
        } else {
            throw new DoctorNotFoundException(
                    String.format("Can't delete doctor with id: %s, doctor does not exist",
                            doctorId));
        }
    }
}
