package inventario;

public class InventarioBottomUp {

    public static double knapsackBottomUp(int[] pesos, int[] valores, double presupuesto, int capacidad) {
        int n = pesos.length;
        double[][] dp = new double[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (pesos[i - 1] <= w && valores[i - 1] <= presupuesto) {
                    dp[i][w] = Math.max(
                            valores[i - 1] + dp[i - 1][w - pesos[i - 1]], // Incluyendo el producto
                            dp[i - 1][w] // Excluyendo el producto
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 5;
        double presupuesto = 10;

        System.out.println("Beneficio máximo (bottom-up): " + knapsackBottomUp(pesos, valores, presupuesto, capacidad));
    }
}

