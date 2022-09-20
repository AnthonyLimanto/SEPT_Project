import 'package:flutter/material.dart';

class MedicationList extends StatelessWidget {
  const MedicationList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: const <Widget>[
        Text("Current Medication:"),
        MedicationListItem(),
      ],
    );
  }
}

class MedicationListItem extends StatefulWidget {
  const MedicationListItem({Key? key}) : super(key: key);

  @override
  MedicationListItemState createState() => MedicationListItemState();
}

class MedicationListItemState extends State<MedicationListItem> {
  String medication = "Paracetamol (Panadol) 665mg Caplets";
  String dose = "Take 2 Caplets Three Times a Day.";
  String use = "For Arthritic Pain relief";
  String blank = "";
  String medication2 = "Perindopril (Coversyl) 10mg Tablet";
  String dose2 = "Take 1 Tablet in the morning.";
  String use2 = "To reduce Blood Pressure";

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        Text(medication),
        Text(dose),
        Text(use),
        Text(blank),
        Text(medication2),
        Text(dose2),
        Text(use2),
      ],
    );
  }
}
