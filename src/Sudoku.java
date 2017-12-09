import java.io.*;

public class Sudoku {
    private byte[][] spielfeld;
    private final int dim, quad;
    private int zeroCount;
    private int lastS, lastZ;

    // weitere Attribute !
    Sudoku(String file) throws IOException {
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
                if (temp.charAt(j) == '*') {
                    spielfeld[i][j] = 0;
                    zeroCount++;
                }
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
        if ((wert < 1)||(9 < wert)){
            return 'w';
        }
        zeile--;
        spalte--;
        if(!(spielfeld[zeile][spalte] == 0)){
            return 'b';
        }
        if (zCheck(zeile, wert)){
            return 'z';
        }
        if (sCheck(spalte, wert)){
            return 's';
        }
        if (qCheck(zeile, spalte , wert)){
            return 'q';
        }

        //wenn alle anderen checks wahr sind, dann ist l wahr,
        //man muss nur noch zeigen, dass nicht f wahr ist
        lastZ = zeile;
        lastS = spalte;
        spielfeld[zeile][spalte] = (byte) wert;
        zeroCount--;
        return (zeroCount <= 0) ? 'f' : 'l';

    }

    private boolean qCheck(int zeile, int spalte, int wert) {
        int zBase = zeile / quad;
        int sBase  = spalte / quad;
        int [] qZahlen = new int[dim];
        int i = 0;

        for (int z = 0; z < quad; z++){
            for (int s = 0; s < quad; s++){
                qZahlen[i] =(int) spielfeld[z+quad*zBase][s+quad*sBase];
                i++;
            }
        }

        for (int j : qZahlen){
            if (j==wert){
                return true;
            }
        }

        return false;
    }

    public void print (){
        System.out.print("  123 456 789\n");
        System.out.print("  --- --- ---\n");

        for (int z = 0; z < dim ; z++){
            System.out.print((z+1) + "|" );
            for(int s = 0; s< dim; s++){
                System.out.print(spielfeld [z][s]);
                if (((s+1) % quad)==0){
                    System.out.print("|");
                }
            }
            System.out.print("\n");
            if (((z+1) % quad)==0){
                System.out.print("  --- --- ---\n");
            }
        }
    }
    private boolean zCheck (int zeile, int wert){
        boolean erg = false;
        for (int i = 0; i < dim ; i++){
            if (spielfeld[zeile][i] == (byte) wert){
                erg = true;
            }
        }
        return erg;
    }
    private boolean sCheck (int spalte, int wert){
        boolean erg = false;
        for (int i = 0; i < dim ; i++){
            if (spielfeld[i][spalte] == (byte) wert){
                erg = true;
            }
        }
        return erg;
    }

    public void widerrufen() {
        spielfeld[lastZ][lastS] = 0;
    }

}
