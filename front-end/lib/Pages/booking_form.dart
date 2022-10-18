import 'package:flutter/material.dart';

class BookingForm extends StatefulWidget {
  const BookingForm({Key? key}) : super(key: key);

  @override
  BookingFormState createState() => BookingFormState();
}

class BookingFormState extends State<BookingForm> {
  final _formKey = GlobalKey<FormState>();

  DateTime dateTimeField = DateTime.now();
  String symptomsField = "";
  String descriptionField = "";

  void onSubmit() {
    // Validate the form
    final isValid = _formKey.currentState!.validate();

    if (isValid) {
      // Todo: API request
      return;
    }
  }

  // Date picker function - Opens popup
  Future<DateTime?> chooseDate() => showDatePicker(
    context: context,
    initialDate: dateTimeField,
    firstDate: DateTime.now(),
    lastDate: DateTime(dateTimeField.year + 1),
  );

  // Time picker function - Opens popup
  Future<TimeOfDay?> chooseTime() => showTimePicker(
      context: context,
      initialTime: TimeOfDay.fromDateTime(dateTimeField),
  );
  
  String getDateTimeToString() {
    return "${dateTimeField.day}/${dateTimeField.month}/${dateTimeField.year} "
        "${dateTimeField.hour.toString().padLeft(2, "0")}:${dateTimeField.minute.toString().padLeft(2, "0")}";
  }

  // Date picker button
  Widget buildDateSelector() => ElevatedButton(
      onPressed: () async {
        // Open date picker window
        final date = await chooseDate();
        if (date == null) {
          return; // User clicked cancel
        }

        // Open time picker window
        final time = await chooseTime();
        if (time == null) {
          return;
        }

        // Construct new dateTime
        DateTime newDateTime = DateTime(
          date.year,
          date.month,
          date.day,
          time.hour,
          time.minute
        );

        // Update dateTime
        setState(() => dateTimeField = newDateTime);
      },
      child: Text(getDateTimeToString())
  );

  Widget buildSymptoms() => TextFormField(
    decoration: const InputDecoration(
        labelText: "Symptoms"
    ),
    onChanged: (value) {
      setState(() {
        symptomsField = value;
      });
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
      setState(() {
        descriptionField = value;
      });
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
              // Date and time selector
              Row(
                children: <Widget>[
                  const Text("Date and time of appointment: "),
                  buildDateSelector(),
                ],
              ),

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
