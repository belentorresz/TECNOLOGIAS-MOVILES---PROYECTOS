import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(const CalculadoraApp());
}

class CalculadoraApp extends StatelessWidget {
  const CalculadoraApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Calculadora',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Colors.pink,
        ),
      ),
      home: const CalculadoraScreen(),
    );
  }
}

class CalculadoraScreen extends StatefulWidget {
  const CalculadoraScreen({super.key});

  @override
  State<CalculadoraScreen> createState() => _CalculadoraScreenState();
}

class _CalculadoraScreenState extends State<CalculadoraScreen> {
  String display = "0";
  String expresion = "";

  double? numero1;
  String operacion = "";

  void agregarNumero(String valor) {
    setState(() {
      if (display == "0") {
        display = valor;
      } else {
        display += valor;
      }
    });
  }

  void agregarPunto() {
    if (!display.contains(".")) {
      setState(() {
        display += ".";
      });
    }
  }

  void limpiar() {
    setState(() {
      display = "0";
      expresion = "";
      numero1 = null;
      operacion = "";
    });
  }

  void seleccionarOperacion(String op) {
    numero1 = double.parse(display);

    setState(() {
      if (expresion.isEmpty) {
        expresion = "$display $op ";
      } else {
        expresion += "$display $op ";
      }

      operacion = op;
      display = "0";
    });
  }

  void calcularResultado() {
    if (numero1 == null) return;

    double numero2 = double.parse(display);
    double resultado = 0;

    switch (operacion) {
      case "+":
        resultado = numero1! + numero2;
        break;

      case "-":
        resultado = numero1! - numero2;
        break;

      case "×":
        resultado = numero1! * numero2;
        break;

      case "÷":
        resultado = numero1! / numero2;
        break;

      case "^":
        resultado = pow(numero1!, numero2).toDouble();
        break;
    }

    setState(() {
      expresion += "$numero2 =";
      display = resultado.toString();

      numero1 = null;
      operacion = "";
    });
  }

  void calcularRaiz() {
    double numero = double.parse(display);

    setState(() {
      expresion = "√($numero)";
      display = sqrt(numero).toString();
    });
  }

  Widget boton(
      String texto, {
        Color color = Colors.white,
        Color textoColor = Colors.black,
        VoidCallback? onTap,
      }) {
    return Padding(
      padding: const EdgeInsets.all(6),
      child: ElevatedButton(
        onPressed: onTap,
        style: ElevatedButton.styleFrom(
          backgroundColor: color,
          foregroundColor: textoColor,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20),
          ),
          minimumSize: const Size(80, 80),
          elevation: 5,
        ),
        child: Text(
          texto,
          style: const TextStyle(
            fontSize: 26,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    const rosa = Color(0xFFE91E63);
    const rosaClaro = Color(0xFFF8BBD0);

    return Scaffold(
      backgroundColor: const Color(0xFFFFF0F5),
      appBar: AppBar(
        title: const Text("Calculadora"),
        centerTitle: true,
        backgroundColor: rosa,
        foregroundColor: Colors.white,
      ),
      body: Column(
        children: [
          Expanded(
            child: Container(
              width: double.infinity,
              padding: const EdgeInsets.all(25),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.end,
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  Text(
                    expresion,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                    style: const TextStyle(
                      fontSize: 22,
                      color: Colors.grey,
                      fontWeight: FontWeight.w500,
                    ),
                  ),

                  const SizedBox(height: 10),

                  Text(
                    display,
                    style: const TextStyle(
                      fontSize: 48,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
          ),

          Container(
            decoration: const BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.vertical(
                top: Radius.circular(30),
              ),
            ),
            child: Column(
              children: [
                Row(
                  children: [
                    Expanded(
                      child: boton(
                        "C",
                        color: Colors.redAccent,
                        textoColor: Colors.white,
                        onTap: limpiar,
                      ),
                    ),
                    Expanded(
                      child: boton(
                        "√",
                        color: rosaClaro,
                        onTap: calcularRaiz,
                      ),
                    ),
                    Expanded(
                      child: boton(
                        "^",
                        color: rosaClaro,
                        onTap: () => seleccionarOperacion("^"),
                      ),
                    ),
                    Expanded(
                      child: boton(
                        "÷",
                        color: rosa,
                        textoColor: Colors.white,
                        onTap: () => seleccionarOperacion("÷"),
                      ),
                    ),
                  ],
                ),

                Row(
                  children: [
                    Expanded(
                        child: boton("7",
                            onTap: () => agregarNumero("7"))),
                    Expanded(
                        child: boton("8",
                            onTap: () => agregarNumero("8"))),
                    Expanded(
                        child: boton("9",
                            onTap: () => agregarNumero("9"))),
                    Expanded(
                      child: boton(
                        "×",
                        color: rosa,
                        textoColor: Colors.white,
                        onTap: () => seleccionarOperacion("×"),
                      ),
                    ),
                  ],
                ),

                Row(
                  children: [
                    Expanded(
                        child: boton("4",
                            onTap: () => agregarNumero("4"))),
                    Expanded(
                        child: boton("5",
                            onTap: () => agregarNumero("5"))),
                    Expanded(
                        child: boton("6",
                            onTap: () => agregarNumero("6"))),
                    Expanded(
                      child: boton(
                        "-",
                        color: rosa,
                        textoColor: Colors.white,
                        onTap: () => seleccionarOperacion("-"),
                      ),
                    ),
                  ],
                ),

                Row(
                  children: [
                    Expanded(
                        child: boton("1",
                            onTap: () => agregarNumero("1"))),
                    Expanded(
                        child: boton("2",
                            onTap: () => agregarNumero("2"))),
                    Expanded(
                        child: boton("3",
                            onTap: () => agregarNumero("3"))),
                    Expanded(
                      child: boton(
                        "+",
                        color: rosa,
                        textoColor: Colors.white,
                        onTap: () => seleccionarOperacion("+"),
                      ),
                    ),
                  ],
                ),

                Row(
                  children: [
                    Expanded(
                        child: boton("0",
                            onTap: () => agregarNumero("0"))),
                    Expanded(
                        child: boton(".",
                            onTap: agregarPunto)),
                    Expanded(
                      child: boton(
                        "=",
                        color: const Color(0xFF378A87),
                        textoColor: Colors.white,
                        onTap: calcularResultado,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}