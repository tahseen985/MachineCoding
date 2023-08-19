package TicTacToeGame;

import java.util.Scanner;
public class TicTacToeService {
    Character charX;
    Character charO;
    String firstPlayer;
    String secondPlayer;
    Integer chance;
    Integer turn;
    char[][] array = new char[3][3];
    Scanner sc=new Scanner(System.in);
    Boolean isWinner;

    public TicTacToeService() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                array[i][j] = '-';
            }
        }
        this.charX = 'X';
        this.charO = 'O';
        this.chance = 0;
        this.turn = 0;
        this.isWinner = false;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Boolean checkValidMove(int x, int y) {
        if(x > 3 || x <= 0 || y > 3 || y <= 0 || this.array[x-1][y-1] != '-') {
            return false;
        }
        return true;
    }

    public void chanceImplement(int x, int y, char ch) {
        this.array[x-1][y-1] = ch;
    }

    public Boolean checkWinner(int x, int y, char ch) {
        //check row
        for(int i=0; i<3; i++) {
            if(this.array[x-1][i] != ch) break;
            if(i == 2) return true;
        }

        //check col
        for(int j=0; j<3; j++) {
            if(this.array[j][y-1] != ch) break;
            if(j == 2) return true;
        }

        //check diagonal
        if(x == y) {
            for(int i=0; i<3; i++) {
                if(this.array[i][i] != ch) break;
                if(i == 2) return true;
            }
        }

        //check anti-diagonal
        if((x+y) == 2) {
            for(int i=0; i<3; i++) {
                if(this.array[i][(2-i)] != ch) break;
                if(i == 2) return true;
            }
        }

        return false;
    }

    public void printStatus() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(this.array[i][j] + " ");
            }
            System.out.println('\n');
        }
    }

    public void makeMove(int x, int y, String player, char ch) {
        if(checkValidMove(x, y) == false) {
            System.out.println(player + " invalid move, try again");
            return;
        }
        chanceImplement(x, y, ch);
        if(checkWinner(x, y, ch) == true) {
            this.isWinner = true;
            System.out.println(player + " wins the game");
            return;
        }
        this.turn = 1 - this.turn;
        this.chance++;
    }

    public void playGame() {

        while (this.chance < 9) {
            printStatus();
            if(this.turn == 0) {
                System.out.println("Please " + this.firstPlayer + " make a move : ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                makeMove(x, y, this.firstPlayer, this.charX);
            } else if(this.turn == 1) {
                System.out.println("Please " + this.secondPlayer + " make a move : ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                makeMove(x, y, this.secondPlayer, this.charO);
            }
            if(this.isWinner == true) {
                printStatus();
                break;
            }
        }

        if(chance == 9) {
            printStatus();
            System.out.println("Game Draw");
        }
    }

//    public void gamePlay() {
//        while(chance < 9) {
//            printStatus();
//            if(turn == 0) {
//                System.out.println("Please " + firstPlayer + " make a move : ");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                if(checkValidMove(x, y) == false) {
//                    System.out.println(firstPlayer + " invalid move, try again");
//                    continue;
//                }
//                chanceImplement(x, y, 'X');
//                if(checkWinner(x, y, 'X') == true) {
//                    System.out.println(firstPlayer + " wins the game");
//                    break;
//                }
//                turn = 0;
//            }
//            if(turn == 1) {
//                System.out.println("Please " + secondPlayer + " make a move : ");
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                if(checkValidMove(x, y) == false) {
//                    System.out.println(secondPlayer + " invalid move, try again");
//                    continue;
//                }
//                chanceImplement(x, y, 'Y');
//                if(checkWinner(x, y, 'Y') == true) {
//                    System.out.println(firstPlayer + " wins the game");
//                    break;
//                }
//                turn = 1;
//            }
//            chance++;
//        }
//
//        if(chance == 9) {
//            System.out.println("Game Draw");
//        }
//    }
}
