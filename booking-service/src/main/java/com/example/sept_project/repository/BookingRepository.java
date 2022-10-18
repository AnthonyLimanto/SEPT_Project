package com.example.sept_project.repository;
import com.example.sept_project.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
