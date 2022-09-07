import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  HomeState createState() => HomeState();
}

class HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Home")
      ),
      body: ListView(
        children: const <Widget>[
          Center(
              child: Padding(
                padding: EdgeInsets.symmetric(vertical: 30.0),
                child: Text(
                  "Welcome, [User]",
                  style: TextStyle(fontSize: 40, fontWeight: FontWeight.bold)
              )
              )
          ),
          Text("My appointments"),
          Text("My medication"),
          Text("Book an appointment"),
          Text("Chat with a doctor"),
          Text("Appointment history"),
          Text("Manage appointments"),
          Text("Account settings")
        ]
      )
    );
  }
}