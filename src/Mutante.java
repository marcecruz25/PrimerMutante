import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marce on 9/13/17.
 */
public class Mutante {
    public static void main(String args[])
    {
        StringBuilder cadena =new StringBuilder();

        // Deberias sobre escribir input para evaluar si es mutante o no
        // estan separadas por filas, la primera fila arreglo contiene las 6 columnas y asi sucesivamente. ATGCGA .

        String[] input = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        for (String in : input) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");


        int totalElementos = matriz.length;
        int matrizNxN = (int) Math.sqrt(matriz.length);
        int mutantes = 0;
        boolean isMutante = false;

        for (int i = 0; i < totalElementos; i++) {
            if (mutantes < 2) {
                int fila = i / matrizNxN;
                // Horizontal
                if (((((fila * matrizNxN) + matrizNxN ) - i) > 3) && ((i + 3) < totalElementos) && matriz[i].equals(matriz[i + 3])) {
                    if (matriz[i].equals(matriz[i + 2])) {
                        if (matriz[i].equals(matriz[i + 1])) {
                            mutantes++;
                        }
                    }
                }

                // Vertical
                if (((i + (matrizNxN * 3)) < totalElementos) && matriz[i].equals(matriz[(i + (matrizNxN * 3))])) {
                    if (matriz[i].equals(matriz[(i + (matrizNxN * 2))])) {
                        if (matriz[i].equals(matriz[i + matrizNxN])) {
                            mutantes++;
                        }
                    }
                }

                // Oblicuo derecha
                if (((i + 3) < ((fila * matrizNxN) + matrizNxN )) && ((i + (matrizNxN * fila)) < totalElementos) ) {
                    // Verifica diagonal
                    if (matriz[i].equals(matriz[(i + matrizNxN + 1)])) {
                        if (matriz[i].equals(matriz[(i + (matrizNxN * 2) + 2)])) {
                            if (matriz[i].equals(matriz[(i + (matrizNxN * 3) + 3)])) {
                                mutantes++;
                            }
                        }
                    }
                }

                // Oblicuo izquierda
                if ((i > 3) && ((i - 3) >= (fila * matrizNxN) ) && ((i + (matrizNxN * fila)) < totalElementos) ) {
                    // Verifica diagonal
                    if (matriz[i].equals(matriz[(i + matrizNxN - 1)])) {
                        if (matriz[i].equals(matriz[(i + (matrizNxN * 2) - 2)])) {
                            if (matriz[i].equals(matriz[(i + (matrizNxN * 3) - 3)])) {
                                mutantes++;
                            }
                        }
                    }
                }

            } else {
                isMutante = true;
                break;
            }
        }

        if (isMutante) {
            System.out.println("La combinacion ingresada pertenece a un mutante -- " + "Mutante is --> " + isMutante);
        } else {
            System.out.println("La combinacion ingresada no pertenece a un mutante -- " + "Mutante is --> " + isMutante);
        }
    }
}
