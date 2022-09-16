import 'package:flutter/material.dart';
import 'package:shrimpfriedrice/Components/medicationList.dart';

class Medication extends StatefulWidget {
  const Medication({Key? key}) : super(key: key);

  @override
  MedicationState createState() => MedicationState();
}

class MedicationState extends State<Medication> {
  String name = "Ben";
  final textButtonStyle =
      TextButton.styleFrom(padding: const EdgeInsets.all(20.0));

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: ListView(padding: const EdgeInsets.all(50.0), children: <Widget>[
      Center(
          child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 30.0),
              child: Text("$name's current medication.",
                  style: const TextStyle(
                      fontSize: 25, fontWeight: FontWeight.bold)))),
      const MedicationList(),
      TextButton(
        style: textButtonStyle,
        onPressed: () {
          Navigator.pushNamed(context, 'login');
        },
        child: const Text("Medication"),
      ),
    ]));
  }
}
