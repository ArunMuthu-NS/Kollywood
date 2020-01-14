import java.util.Arrays;
import java.util.Scanner;

public class Kollywood {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Player 1 : Enter the movie name");
        String movieName = s.nextLine();

        char result[] = new char[movieName.length()];
        int chances = 9, moves = 0;
        boolean isSolved = true;
        Arrays.fill(result, '_');

        System.out.println("Player 2 start guessing ");
        System.out.print("Movie name : ");
        print(result);
        while(moves < chances){
            char nextChar = s.nextLine().charAt(0);
            boolean isFound = false;
            isSolved = true;
            for(int i = 0;i < movieName.length();i++){
                if(nextChar == movieName.charAt(i)) {
                    result[i] = nextChar;
                    isFound = true;
                }

                if(result[i] == '_')
                    isSolved = false;
            }

            if(isSolved) break;

            System.out.print("Movie name : ");
            print(result);
            System.out.println("Chances remaining " + (chances - moves));
            moves += (isFound) ? 0 : 1;
        }

        if(isSolved)
            System.out.println("Player 2 has found the movie name " + movieName);
        else
            System.out.println("Player 1 has won and the movie is " + movieName);
    }

    public static void print(char arr[]) {
        for(char x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
