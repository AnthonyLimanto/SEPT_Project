import 'package:flutter/material.dart';

class AppointmentList extends StatelessWidget {
  const AppointmentList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: const <Widget>[
        Text("My appointments"),
        AppointmentListItem(),
        AppointmentListItem(),
        AppointmentListItem(),
      ],
    );
  }
}

class AppointmentListItem extends StatefulWidget {
  const AppointmentListItem({Key? key}) : super(key: key);

  @override
  AppointmentListItemState createState() => AppointmentListItemState();
}

class AppointmentListItemState extends State<AppointmentListItem> {
  DateTime time = DateTime.utc(2022, 11, 1);
  String doctor = "Dr Bob";
  String where = "Online";

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        Text("${time.hour}:${time.minute}"),
        Text("With $doctor"),
        Text(where),
      ],
    );
  }

}