/**
 * @about: Clase para implementar Dijkstra's algorithm
 */
    import java.util.*;
    class AlgoritmoDJ{
        public int[] distancia = new int[10];
        public int[][] valores = new int[10][10];
    /**@about:
     * En este metodo se incia el algoritmo
     */
    public void dista(int nodos, int origen){
        int[] flag = new int[nodos + 1];
        int i, minpos = 1, j, x, min;
        for (i = 1; i <= nodos; i++){
            flag[i] = 0;
            this.distancia[i] = this.valores[origen][i];
        }
        x = 2;
        while(x <= nodos){
            min = 999;
            for (j = 1; j <= nodos; j++){
                if (this.distancia[j] < min && flag[j] !=1){
                    min = this.distancia[i];
                    minpos = j;
                }
            }
            flag[minpos] = 1;
            x++;
            for (j = 1; j <= nodos; j++){
                if (this.distancia[minpos] + this.valores[minpos][j] < this.distancia[j] && flag[j] !=1){
                    this.distancia[j] = this.distancia[minpos] + this.valores[minpos][j];
                }
            }
        }
        }
    public static void main(String args[]) {
        int nodos, posicion, i, k;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de nodos:");
        nodos = sc.nextInt();
        AlgoritmoDJ d = new AlgoritmoDJ();
        System.out.println("Ingrese los pesos de la matriz de valores:");
        for (i = 1; i <= nodos; i++) {
            for (k = 1; k <= nodos; k++) {
                d.valores[i][k] = sc.nextInt();
                if (d.valores[i][k] == 0) {
                    d.valores[i][k] = 999;
                }
            }
        }
        System.out.println("Ingrese la posicion de origen :");
        posicion = sc.nextInt();
    
        d.dista(nodos, posicion);
        System.out.println("El camino mas corto desde la posicion " + posicion + " a todos los demas nodos son : \n");
        for (i = 1; i <= nodos; i++) {
            if (i != posicion) {
                System.out.println("posicion :" + posicion + " destino :" + i + " Valor minimo es :" + d.distancia[i] + "\t");
            }
        }
    
      }
}