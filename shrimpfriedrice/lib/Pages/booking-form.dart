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
    "description": "",
    "doctorId": -1,
  };

  handleSubmit() {
    print(_fields);
  }

  @override
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
          children: <Widget>[
            /* Describe how you feel */
            TextFormField(
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return "Please enter some text";
                }
                return null;
              },
              onChanged: (String value) {
                _fields["description"] = value;
              },
              decoration: const InputDecoration(
                labelText: "Describe how you feel"
              ),
            ),

            /* Submit button */
            ElevatedButton(
                onPressed: handleSubmit,
                child: const Text("Submit")
            )
          ],
        ),
    );
  }
}
