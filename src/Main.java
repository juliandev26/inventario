import inventario.InventarioBottomUp;
import inventario.InventarioRecursivo;
import inventario.InventarioTopDown;

import java.util.HashMap;
import java.util.Map;

public class Main {
//    ComparacionRendimiento
public static void main(String[] args) {
    int[] pesos = {2, 3, 4, 5};
    int[] valores = {3, 4, 5, 6};
    int capacidad = 5;
    double presupuesto = 10;

    long start, end;

    // Recursivo
    start = System.nanoTime();
    double resultadoRecursivo = InventarioRecursivo.knapsackRecursivo(pesos, valores, presupuesto, capacidad, pesos.length);
    end = System.nanoTime();
    System.out.println("Recursivo: " + resultadoRecursivo + " Tiempo: " + (end - start) + " ns");

    // Bottom-Up
    start = System.nanoTime();
    double resultadoBottomUp = InventarioBottomUp.knapsackBottomUp(pesos, valores, presupuesto, capacidad);
    end = System.nanoTime();
    System.out.println("Bottom-Up: " + resultadoBottomUp + " Tiempo: " + (end - start) + " ns");

    // Top-Down
    start = System.nanoTime();
    Map<String, Double> memo = new HashMap<>();
    double resultadoTopDown = InventarioTopDown.knapsackTopDown(pesos, valores, presupuesto, capacidad, pesos.length, memo);
    end = System.nanoTime();
    System.out.println("Top-Down: " + resultadoTopDown + " Tiempo: " + (end - start) + " ns");
}
}