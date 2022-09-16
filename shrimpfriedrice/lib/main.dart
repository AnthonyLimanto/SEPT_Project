import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/Pages/home.dart';
import 'package:shrimpfriedrice/Pages/login.dart';
import 'package:shrimpfriedrice/Pages/register.dart';
import 'package:shrimpfriedrice/Pages/booking-form.dart';
import 'package:shrimpfriedrice/Pages/medication.dart';
import 'package:shrimpfriedrice/Components/appointmentList.dart';
import 'package:shrimpfriedrice/Components/medicationList.dart';

void main() {
  runApp(
    MaterialApp(
        debugShowCheckedModeBanner: false,
        initialRoute: 'login',
        routes: {
          'home': (context) => const Home(),
          'login': (context) => const Login(),
          'register': (context) => const Register(),
          'book': (context) => const AppointmentForm(),
          'medication': (context) => const Medication()
        }),
  );
}
