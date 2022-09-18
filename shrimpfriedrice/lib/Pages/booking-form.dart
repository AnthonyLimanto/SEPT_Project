import 'package:flutter/material.dart';

class AppointmentForm extends StatefulWidget {
  const AppointmentForm({Key? key}) : super(key: key);

  @override
  AppointmentFormState createState() => AppointmentFormState();
}

class AppointmentFormState extends State<AppointmentForm> {
  final _formKey = GlobalKey<AppointmentFormState>();

  /* Contains the form values */
  final _fields = {
    "symptoms": "",
    "description": "",
  };

  void onSubmit() {
    print(_fields);
  }

  Widget buildSymptoms() => TextFormField(
    decoration: const InputDecoration(
        labelText: "Symptoms"
    ),
    onChanged: (value) {setState(() {
      _fields["symptoms"] = value;
    });},
  );

  Widget buildDescription() => TextFormField(
    decoration: const InputDecoration(
      labelText: "Description"
    ),
    onChanged: (value) {setState(() {
      _fields["description"] = value;
      });
    },
  );

  Widget buildSubmit() => ElevatedButton(
    onPressed: onSubmit,
    child: const Text("Submit")
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(10.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: <Widget>[
              /* Symptoms */
              buildSymptoms(),

              /* Describe how you feel */
              buildDescription(),

              /* Submit button */
              buildSubmit(),
            ],
          ),
        ),
      ),
    );
  }
}
