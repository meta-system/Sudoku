import java.io.*;

public class Sudoku {
    private byte[][] spielfeld;
    private final int dim, quad;

    // weitere Attribute !
    public Sudoku(String file) throws IOException {
        // Initialisierung des Spielfeldes
        dim = 9;
        quad =(int) Math.sqrt(dim);
        spielfeld = new byte[dim][dim];
        // Laden der Werte aus der Datei file und ...
        BufferedReader in = new BufferedReader(new FileReader(file));
        String temp;
        for (int i = 0; i < dim; i++) {
            temp = in.readLine();
            // ... speichern dieser Werte in das Spielfeld
            for (int j = 0; j < dim; j++) {
                if (temp.charAt(j) == '*') spielfeld[i][j] = 0;
                else {
                    spielfeld[i][j] = (byte) (temp.charAt(j)-'0');

                }
                System.out.println(spielfeld[i][j]);
            }
        }
        // weitere Initialisierungen !
    }

    public void print (){
        System.out.print(" 123 456 789\n");
        System.out.print(" ___ ___ ___\n");
        for (int z = 0; z < dim ; z++){

            System.out.print((z+1) + "|" );
            for(int s = 0; s< dim; s++){
                System.out.print(spielfeld [z][s]);
                if (((s+1) % quad)==0){
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        System.out.print("  ___ ___ ___\n");
    }
}
