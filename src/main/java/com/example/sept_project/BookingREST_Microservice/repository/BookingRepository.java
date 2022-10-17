package com.example.sept_project.BookingREST_Microservice.repository;
import com.example.sept_project.BookingREST_Microservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
