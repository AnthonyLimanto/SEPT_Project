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
  DateTime time = DateTime.utc(2022, 11, 1);
  String medication = "Paracetamol 665mg Caplets";
  String dose = "Take 2 Caplets Three Times a Day.";

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        Text(medication),
        Text(dose),
      ],
    );
  }
}
