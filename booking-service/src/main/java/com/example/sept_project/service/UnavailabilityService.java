package com.example.sept_project.service;

import com.example.sept_project.exeception.DoctorNotFoundException;
import com.example.sept_project.model.Unavailability;
import com.example.sept_project.repository.DoctorRepository;
import com.example.sept_project.repository.UnavailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnavailabilityService {

    private final DoctorRepository doctorRepository;
    private final UnavailabilityRepository unavailabilityRepository;

    public UnavailabilityService(DoctorRepository doctorRepository, UnavailabilityRepository unavailabilityRepository) {
        this.doctorRepository = doctorRepository;
        this.unavailabilityRepository = unavailabilityRepository;
    }

    public List<Unavailability> getUnavailabilitiesByDoctorId(Long doctor_id) {
        if (doctorRepository.existsById(doctor_id)) {
            return unavailabilityRepository.findAllByDoctor_Id(doctor_id);
        } else {
            throw new DoctorNotFoundException(
                    String.format("No doctor with id: %s",
                            doctor_id));
        }
    }

    public Unavailability addUnavailability(Unavailability unavailability, Long doctor_id) {
        if (doctorRepository.existsById(doctor_id)) {
            unavailability.setDoctor(doctorRepository.findById(doctor_id).get());
            return unavailabilityRepository.save(unavailability);
        } else {
            throw new DoctorNotFoundException(
                    String.format("No doctor with id: %s",
                            doctor_id));
        }
    }
}
