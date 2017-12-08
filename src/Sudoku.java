import java.io.*;

public class Sudoku {
    private byte[][] spielfeld;
    private final int dim, quad;
    private int zeroCount;

    // weitere Attribute !
    public Sudoku(String file) throws IOException {
        // Initialisierung des Spielfeldes
        dim = 9;
        quad =(int) Math.sqrt(dim);
        spielfeld = new byte[dim][dim];
        zeroCount = 0;
        // Laden der Werte aus der Datei file und ...
        BufferedReader in = new BufferedReader(new FileReader(file));
        String temp;
        for (int i = 0; i < dim; i++) {
            temp = in.readLine();
            // ... speichern dieser Werte in das Spielfeld
            for (int j = 0; j < dim; j++) {
                if (temp.charAt(j) == '*') spielfeld[i][j] = 0;
                zeroCount++;
                else {
                    spielfeld[i][j] = (byte) (temp.charAt(j)-'0');

                }
            }
        }
    }

    public char setze (int zeile, int spalte, int wert ){
        if ((zeile < 1 || 9 < zeile) || (spalte < 1 || 9 < spalte)){
            return 'p';
        }
        if ((1< wert)||(wert<9)){
            return 'w';
        }

        if (zCheck(zeile-1, wert)){
            return 'z';
        }
        if (sCheck(spalte-1, wert)){
            return 's';
        }
        if (qCheck(zeile-1, spalte-1 , wert)){
            return 'q';
        }
        //wenn alle anderen checks wahr sind, dann ist l wahr,
        //man muss nur noch zeigen, dass nicht f wahr ist
        return (zeroCount <= 0) ? 'f' : 'l';

    }

    private boolean qCheck(int zeile, int spalte, int wert) {
        int qZeile  = zeile % quad;
        int zBase = zeile / quad;
        int qSpalte = spalte % quad;
        int sBase  = spalte / quad;
        int [] qZahlen = new int[9];
        int i = 0;
        for (int z = 0; z < quad; z++){
            for (int s = 0; s < quad; s++){
                qZahlen[i] =
            }
        }


        return false;
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
    private boolean zCheck (int zeile, int wert){
        boolean erg = false;
        for (int i = 0; i < dim ; i++){
            if (spielfeld[zeile][i] == wert){
                erg = true;
            }
        }
        return erg;
    }
    private boolean sCheck (int spalte, int wert){
        boolean erg = false;
        for (int i = 0; i < dim ; i++){
            if (spielfeld[i][spalte] == wert){
                erg = true;
            }
        }
        return erg;
    }
    private boolean checkGame (){
        for (int z = 0; z < dim ; z++){
            for(int s = 0; s< dim; s++){
                if (spielfeld[z][s] == 0){
                    return false;
                }
            }
        }
    }
    private boolean
}
