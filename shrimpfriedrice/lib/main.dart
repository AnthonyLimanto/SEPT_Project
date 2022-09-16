import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/Pages/home.dart';
import 'package:shrimpfriedrice/Pages/login.dart';
import 'package:shrimpfriedrice/Pages/register.dart';
import 'package:shrimpfriedrice/Pages/booking-form.dart';

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
        }),
  );
}
