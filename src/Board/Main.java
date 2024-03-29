package Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alr
 */
public class Main {

    public static boolean checkBoard(List<Integer> record, List<Integer> user, List<Integer> prog, int input, int turn){
        // System.out.println(input);
        int i = 0;
        boolean copy = true;
        for(int r: record){
            if (r == input){
                // System.out.println(">");
                i++; 
                break;
            } else {
                // System.out.println(">");
            }
        }
        if(i > 0){
            copy = true;
        }else {
            record.add(input);
            copy = false;
            if(turn == 0){
                user.add(input);
            } else  if(turn == 1){
                prog.add(input);
            }
        }        
        // System.out.println(copy);
        // System.out.println(record);
        return copy;
    }

    public static void updateBoard(String[][] board, int position, String key){
        switch (position) {
            case 1:
                board[0][0] = key;
                break;
             case 2:
                board[0][2] = key;
                break;
                case 3:
                board[0][4] = key;
                break;
                case 4:
                board[2][0] = key;
                break;
                case 5:
                board[2][2] = key;
                break;
                case 6:
                board[2][4] = key;
                break;
                case 7:
                board[4][0] = key;
                break;
                case 8:
                board[4][2] = key;
                break;
                case 9:
                board[4][4] = key;
                break;
 
            default:
                // throw new AssertionError();
        }
    }

    public static void getBoard(String[][] input){
        for(String[] s: input){
            for(String ss: s){
                System.out.print(ss);
            }
            System.out.println();
        }
    }

    public static boolean showBoard(List<Integer> record, List<Integer> user, List<Integer> prog) {
        boolean carryon = true;

        List<List> board = new ArrayList<>();
        List one = Arrays.asList(1,2,3);
        List two = Arrays.asList( 4,5,6);
        List three = Arrays.asList(7,8,9);
        List four = Arrays.asList(  1,4,7);
        List five = Arrays.asList(   2,5,8);
        List six = Arrays.asList(3,6,9);
        List seven = Arrays.asList(1,5,9);
        List eight = Arrays.asList( 3,5,7);
        board.add(one);
        board.add(two );
        board.add(three);
        board.add(four);
        board.add(five);
        board.add(six);
        board.add(seven);
        board.add(eight );

        // System.out.print(">>>" + record);
        // System.out.print(">>>" + user);

        for(List b: board) {
            if(user.containsAll(b)){
                System.out.println("\n> You win !\n");
                carryon = false;
            } else if(prog.containsAll(b)){
                System.out.println("\n> Program win !\n");
                carryon = false;
            }
        }
        // System.out.println(record);


        return carryon;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random(10);
        String[][] board = {{" ", "|", " ", "|", " "},{"-", "+", "-", "+", "-"},{" ", "|", " ", "|", " "},{"-", "+", "-", "+", "-"},{" ", "|", " ", "|", " "}};

        List<Integer> record = new ArrayList<>();
        record.add(0);
        List<Integer> user = new ArrayList<>();
        user.add(0);
        List<Integer> prog = new ArrayList<>();
        prog.add(0);
        int position = 0;
        // int point = 0;
        int turn = 0;
        
        getBoard(board);
        while(showBoard(record, user, prog) && record.size() <= 9){
                    
            switch (turn) {
                case 0: 
                    System.out.println("\n> Your turn, Key in a number(1-9)..\n1");
                    position =  scan.nextInt();
                    while(checkBoard(record, user, prog, position, turn)){
                        System.out.println("\n> Select an empty slot..\n");
                        position =  scan.nextInt();
                    }
                    updateBoard(board, position, "X");
                    turn = 1;
                    break;
                case 1: 
                    System.out.println("\n> Program turn..\n");
                    int point = ran.ints(1, 9).findFirst().getAsInt();
                    while(checkBoard(record, user, prog, point, turn)){
                        point = ran.ints(1, 9).findFirst().getAsInt();
                    }
                    updateBoard(board, point, "O");
                    turn = 0;
                    break;
                // default throw new AssertionError();
            }
            getBoard(board);
        }








     
    }
}

