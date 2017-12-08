import java.io.*;
public class TestSudoku {
    public static void main(String[] args) throws IOException {
        Sudoku test = new Sudoku("src/beispiel.txt");
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test.print();
    }
}
