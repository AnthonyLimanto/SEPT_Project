import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/Pages/home.dart';
import 'package:shrimpfriedrice/Pages/login.dart';
import 'package:shrimpfriedrice/Pages/register.dart';
import 'package:shrimpfriedrice/Pages/booking_form.dart';
import 'package:shrimpfriedrice/Pages/medication.dart';
import 'package:shrimpfriedrice/Components/appointment_list.dart';
import 'package:shrimpfriedrice/Components/medication_list.dart';

void main() {
  runApp(
    MaterialApp(
        debugShowCheckedModeBanner: false,
        initialRoute: 'login',
        routes: {
          'home': (context) => const Home(),
          'login': (context) => const Login(),
          'register': (context) => const Register(),
          'book': (context) => const BookingForm(),
          'medication': (context) => const Medication()
        }),
  );
}
