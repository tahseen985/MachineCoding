package TicTacToeGame;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please give name of the players : ");
        String firstPlayer = sc.nextLine();
        String secondPlayer = sc.nextLine();

        System.out.println(firstPlayer + " chooses X");
        System.out.println(secondPlayer + " chooses O");

        TicTacToeService ticTacToeService = new TicTacToeService();
        ticTacToeService.setFirstPlayer(firstPlayer);
        ticTacToeService.setSecondPlayer(secondPlayer);

        ticTacToeService.playGame();

//        while (chance < 9) {
//            ticTacToeService.printStatus();
//            System.out.println(turn);
//            System.out.println(chance);
//            if(turn == 0) {
//                System.out.println("Please " + firstPlayer + " make a move : ");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                ticTacToeService.playGame(x, y, firstPlayer, 'X', turn, chance);
//            }
//            if(turn == 1) {
//                System.out.println("Please " + secondPlayer + " make a move : ");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                ticTacToeService.playGame(x, y, secondPlayer, 'O', turn, chance);
//            }
//        }

//        if(chance == 9) {
//            System.out.println("Game Draw");
//        }
    }
}
