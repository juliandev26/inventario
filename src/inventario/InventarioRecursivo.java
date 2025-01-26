package inventario;

public class InventarioRecursivo {

    public static double knapsackRecursivo(int[] pesos, int[] valores, double presupuesto, int capacidad, int n) {
        if (n == 0 || capacidad == 0 || presupuesto <= 0) {
            return 0;
        }

        if (pesos[n - 1] > capacidad || valores[n - 1] > presupuesto) {
            return knapsackRecursivo(pesos, valores, presupuesto, capacidad, n - 1);
        }

        // Incluyendo el producto
        double incluir = valores[n - 1] + knapsackRecursivo(
                pesos, valores, presupuesto - valores[n - 1], capacidad - pesos[n - 1], n - 1);

        // Excluyendo el producto
        double excluir = knapsackRecursivo(pesos, valores, presupuesto, capacidad, n - 1);

        return Math.max(incluir, excluir);
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 5;
        double presupuesto = 10;

        int n = pesos.length;
        System.out.println("Beneficio máximo (recursivo): " + knapsackRecursivo(pesos, valores, presupuesto, capacidad, n));
    }
}
