import 'package:flutter/material.dart';

class AppointmentForm extends StatefulWidget {
  const AppointmentForm({Key? key}) : super(key: key);

  @override
  AppointmentFormState createState() => AppointmentFormState();
}

class AppointmentFormState extends State<AppointmentForm> {
  final _formKey = GlobalKey<FormState>();

  /* Contains the form values */
  final _fields = {
    "symptoms": "",
    "description": "",
  };

  void onSubmit() {
    final isValid = _formKey.currentState!.validate();

    if (isValid) {
      print(_fields);
    }
  }

  Widget buildSymptoms() => TextFormField(
    decoration: const InputDecoration(
        labelText: "Symptoms"
    ),
    onChanged: (value) {
      setState(() {_fields["symptoms"] = value;});
    },
    validator: (value) {
      if (value == null || value.isEmpty) {
        return "Please provide symptoms";
      }
      return null;
    },
  );

  Widget buildDescription() => TextFormField(
    decoration: const InputDecoration(
      labelText: "Description"
    ),
    onChanged: (value) {
      setState(() {_fields["description"] = value;});
    },
    validator: (value) {
      if (value == null || value.isEmpty) {
        return "Please provide a brief description of how you are feeling";
      }
      return null;
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
              // Todo: Add a date selector

              // Symptoms field
              buildSymptoms(),

              // Description field
              buildDescription(),

              // Todo: Add a doctor dropdown selector

              /* Submit button */
              buildSubmit(),
            ],
          ),
        ),
      ),
    );
  }
}
