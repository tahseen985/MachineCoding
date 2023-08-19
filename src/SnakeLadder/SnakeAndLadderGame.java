package SnakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        Scanner sc=new Scanner(System.in);

        System.out.println("Please give number of snakes : ");
        Integer numberOfSnakes= sc.nextInt();
        for(int i=0; i<numberOfSnakes; i++) {
            Integer head = sc.nextInt();
            Integer tail = sc.nextInt();
            gameService.setSnakeMapping(tail, head);
        }

        System.out.println("Please give number of Ladder : ");
        Integer numberOfLadder= sc.nextInt();
        for(int i=0; i<numberOfLadder; i++) {
            Integer tail = sc.nextInt();
            Integer head = sc.nextInt();
            gameService.setLadderMapping(tail, head);
        }

        System.out.println("Please give number of Players : ");
        Integer numberOfPlayers= sc.nextInt();
        for(int i=0; i<numberOfPlayers; i++) {
            String name = sc.nextLine();
            gameService.setPlayersName(name);
        }

        gameService.playGame();
    }
}

/*
Snakes
6
11 7
9 4
13 1
15 9
50 10
98 5

Ladder
5
1 22
4 11
5 26
10 19
12 27

players
2
tahseen ashish
 */
