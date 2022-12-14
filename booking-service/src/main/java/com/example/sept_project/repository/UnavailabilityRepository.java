package com.example.sept_project.repository;
import com.example.sept_project.model.Unavailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnavailabilityRepository extends JpaRepository<Unavailability, Long>{

    List<Unavailability> findAllByDoctor_Id(Long doctor_id);
}
