import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/login.dart';
import 'package:shrimpfriedrice/register.dart';

void main() {
  runApp(
    MaterialApp(
        debugShowCheckedModeBanner: false,
        initialRoute: 'login',
        routes: {
          'login': (context) => const Login(),
          'register': (context) => const Register(),
        }),
  );
}
