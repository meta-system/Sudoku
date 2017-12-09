import java.io.*;
public class TestSudoku {
    public static void main(String[] args) throws IOException {
        Sudoku mySudoku = new Sudoku("src/beispiel.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean victory = false;
        int zeile, spalte, wert;
        //boolean reverted = false;
        mySudoku.print();

        do {

            System.out.print("Zeile: ");
            zeile = Integer.parseInt(br.readLine());

            System.out.print("Spalte: ");
            spalte = Integer.parseInt(br.readLine());

            System.out.print("Wert: ");
            wert = Integer.parseInt(br.readLine());

            switch (mySudoku.setze(zeile, spalte, wert)){
                case 'p' : System.out.println("Als Zeilen und Spalten sind nur Werte zwischen 1 und 9 zulaessig!"); break;
                case 'w' : System.out.println("Der Wert muss zwischen 1 und 9 liegen !"); break;
                case 'b' : System.out.println("An der Stelle gibt's schon einen Wert, du Witzbold!"); break;
                case 'z' : System.out.println("In dieser Zeile kommt bereits eine " + wert + " vor!"); break;
                case 's' : System.out.println("In dieser Spalte kommt bereits eine " + wert + " vor!"); break;
                case 'q' : System.out.println("Der Quadrant enthaelt bereits eine " + wert + "!"); break;
                case 'f' :
                    mySudoku.print();
                    System.out.println("Gratuliere, Sie haben das Rätsel gelöst!");
                    victory =true; break;
                case 'l' :
                    mySudoku.print();
                    System.out.println("Letzten Zug widerrufen? (j fuer ja, n fuer nein)");
                    if (br.readLine().equals("j")) {
                        mySudoku.widerrufen();
                        mySudoku.print();
                    }
                    break;
                default: System.out.println("Fehler!");
            }

        } while (!victory);


    }

}
