//package com.example.sept_project.controller;
//
//import com.example.sept_project.model.Doctor;
//import com.example.sept_project.service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/doctor")
//public class DoctorController {
//    @Autowired
//    private DoctorService doctorService;
//
//    @PostMapping("/add")
//    public String add(@RequestBody Doctor doctor) {
//        doctorService.saveDoctor(doctor);
//        return "New Doctor is added";
//    }
//}
