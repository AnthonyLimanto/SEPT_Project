import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/Components/appointment_list.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  HomeState createState() => HomeState();
}

class HomeState extends State<Home> {
  String name = '<User>';
  final textButtonStyle =
  TextButton.styleFrom(padding: const EdgeInsets.all(20.0));

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView(
        padding: const EdgeInsets.all(50.0),
        children: <Widget>[
          Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 30.0),
              child: Text(
                "Welcome, $name Book your next appointment.",
                style:
                const TextStyle(fontSize: 28, fontWeight: FontWeight.bold),
              ),
            ),
          ),
          const AppointmentList(),
          TextButton(
            style: textButtonStyle,
            onPressed: () {
              Navigator.pushNamed(context, 'medication');
            },
            child: const Text("My medication"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {
              Navigator.pushNamed(context, 'book');
            },
            child: const Text("Book an appointment"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {},
            child: const Text("Chat with a doctor"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {},
            child: const Text("Appointment history"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {},
            child: const Text("Manage appointments"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {
              Navigator.pushNamed(context, 'settings');
            },
            child: const Text("Account settings"),
          ),
          TextButton(
            style: textButtonStyle,
            onPressed: () {
              Navigator.pushNamed(context, 'login');
            },
            child: const Text("Start"),
          ),
        ],
      ),
    );
  }
}