package inventario;

import java.util.HashMap;
import java.util.Map;

public class InventarioTopDown {

    public static double knapsackTopDown(int[] pesos, int[] valores, double presupuesto, int capacidad, int n, Map<String, Double> memo) {
        if (n == 0 || capacidad == 0 || presupuesto <= 0) {
            return 0;
        }

        String key = n + "-" + capacidad + "-" + presupuesto;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (pesos[n - 1] > capacidad || valores[n - 1] > presupuesto) {
            memo.put(key, knapsackTopDown(pesos, valores, presupuesto, capacidad, n - 1, memo));
            return memo.get(key);
        }

        // Incluyendo el producto
        double incluir = valores[n - 1] + knapsackTopDown(
                pesos, valores, presupuesto - valores[n - 1], capacidad - pesos[n - 1], n - 1, memo);

        // Excluyendo el producto
        double excluir = knapsackTopDown(pesos, valores, presupuesto, capacidad, n - 1, memo);

        memo.put(key, Math.max(incluir, excluir));
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 5;
        double presupuesto = 10;

        Map<String, Double> memo = new HashMap<>();
        System.out.println("Beneficio máximo (top-down): " + knapsackTopDown(pesos, valores, presupuesto, capacidad, pesos.length, memo));
    }
}
