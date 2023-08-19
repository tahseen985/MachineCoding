package SnakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameService {
    Map<Integer,Integer> snakeMapping;
    Map<Integer,Integer> ladderMapping;
    ArrayList<String> playersName;
    ArrayList<Integer> position;
    Boolean isGameEnd;
    String winnerName;

    public GameService() {
        snakeMapping = new HashMap<Integer,Integer>();
        ladderMapping = new HashMap<Integer,Integer>();
        playersName = new ArrayList<String>();
        position = new ArrayList<Integer>();
        isGameEnd = false;
        winnerName = "";
    }

    public void setSnakeMapping(Integer tail, Integer head) {
        snakeMapping.put(head, tail);
    }

    public void setLadderMapping(Integer tail, Integer head) {
        ladderMapping.put(tail, head);
    }

    public void setPlayersName(String name) {
        playersName.add(name);
    }

    private Integer rollDice() {
        int max = 6;
        int min = 1;
        return (int)(Math.random()*(max-min+1)+min);
    }

    public void playGame() {

        Integer numberOfPlayers = playersName.size();
        for(int i=0; i<numberOfPlayers; i++) {
            position.add(0);
        }

        while (isGameEnd == false) {

            for(int i=0; i<numberOfPlayers; i++) {
                int diceOutput = rollDice();
                Integer nextPosition = position.get(i)+diceOutput;
                if(snakeMapping.containsKey(nextPosition) == true) {
//                    System.out.println("snake bites");
                    nextPosition = snakeMapping.get(nextPosition);
                }
                if(ladderMapping.containsKey(nextPosition) == true) {
//                    System.out.println("gets a ladder");
                    nextPosition = ladderMapping.get(nextPosition);
                }
                System.out.println(playersName.get(i) + " rolled a " + diceOutput + " and moved from " +
                        position.get(i) + " to " + nextPosition);
                if(nextPosition > 100) continue;
                position.add(i, nextPosition);
                if(nextPosition == 100) {
                    winnerName = playersName.get(i);
                    isGameEnd = true;
                    break;
                }
            }
        }

        System.out.println(winnerName + " wins the match");
    }
}
