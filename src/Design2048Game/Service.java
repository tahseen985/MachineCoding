package Design2048Game;

import java.util.Scanner;

public class Service {
    Integer[][] game = new Integer[4][4];
    Boolean isGameEnd;
    Scanner sc=new Scanner(System.in);
    public Service() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                this.game[i][j] = 0;
            }
        }
        this.isGameEnd = false;
        randomlyAddTwo();
        randomlyAddTwo();
    }

    public void printStatus() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(this.game[i][j] + " ");
            }
            System.out.println('\n');
        }
    }

    public int random() {
        int max = 3;
        int min = 0;
        return (int)(Math.random()*(max-min+1)+min);
    }

    public Boolean checkWinner() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(this.game[i][j] == 2048) {
                    this.isGameEnd = true;
                    return true;
                }
            }
        }
        return false;
    }

    public void randomlyAddTwo() {
        int x = this.random();
        int y = this.random();

        while(this.game[x][y] != 0) {
            x = this.random();
            y = this.random();
        }

        this.game[x][y] = 2;
    }

    public void isSpaceLeft() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(this.game[i][j] == 0) return;
            }
        }
        this.isGameEnd = true;
    }

    public void leftSettle() {
        for(int i=0; i<4; i++) {
            for(int j=2; j>=0; j--) {
                if(this.game[i][j] == this.game[i][j+1]) {
                    this.game[i][j] += this.game[i][j+1];
                    this.game[i][j+1] = 0;
                }
            }
        }
    }

    public void rightSettle() {
        for(int i=0; i<4; i++) {
            for(int j=1; j<=3; j++) {
                if(this.game[i][j] == this.game[i][j-1]) {
                    this.game[i][j] += this.game[i][j-1];
                    this.game[i][j-1] = 0;
                }
            }
        }
    }

    public void upSettle() {
        for(int j=0; j<4; j++) {
            for(int i=2; i>=0; i--) {
                if(this.game[i][j] == this.game[i+1][j]) {
                    this.game[i][j] += this.game[i+1][j];
                    this.game[i+1][j] = 0;
                }
            }
        }
    }

    public void downSettle() {
        for(int j=0; j<4; j++) {
            for(int i=1; i<4; i++) {
                if(this.game[i][j] == this.game[i-1][j]) {
                    this.game[i][j] += this.game[i-1][j];
                    this.game[i-1][j] = 0;
                }
            }
        }
    }

    public void move(int direction) {

        for(int i=0; i<4; i++) {
            Integer[] rowOrColumn = new Integer[4];
            Integer index = 0;
            for(int j=0; j<4; j++) {
                if (direction == 0) {
                    rowOrColumn[index++] = this.game[i][j];
                } else if (direction == 1) {
                    rowOrColumn[index++] = this.game[i][3 - j];
                } else if (direction == 2) {
                    rowOrColumn[index++] = this.game[j][i];
                } else if (direction == 3) {
                    rowOrColumn[index++] = this.game[3 - j][i];
                } else {
                    System.out.println("Invalid input, Please retry");
                }
            }

            mergeTiles(rowOrColumn);
            index = 0;

            for(int j=0; j<4; j++) {
                if (direction == 0) {
                    this.game[i][j] = rowOrColumn[index++];
                } else if (direction == 1) {
                    this.game[i][3 - j] = rowOrColumn[index++];
                } else if (direction == 2) {
                    this.game[j][i] = rowOrColumn[index++];
                } else if (direction == 3) {
                    this.game[3 - j][i] = rowOrColumn[index++];
                } else {
                    System.out.println("Invalid input, Please retry");
                }
            }

        }
    }

    private void mergeTiles(Integer[] rowOrColumn) {
        // Slide the tiles and merge if necessary
        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (rowOrColumn[i] != 0) {
                if (index > 0 && rowOrColumn[i] == rowOrColumn[index - 1]) {
                    rowOrColumn[index - 1] *= 2;
                    rowOrColumn[i] = 0;
                } else {
                    if (i != index) {
                        rowOrColumn[index] = rowOrColumn[i];
                        rowOrColumn[i] = 0;
                    }
                    index++;
                }
            }
        }
    }

    public void gamePlay() {
        while (isGameEnd == false) {
            printStatus();
            System.out.println("Please make a move");
            Integer input = sc.nextInt();
            move(input);
            checkWinner();
            isSpaceLeft();
            if(this.isGameEnd == true) continue;
            randomlyAddTwo();
        }
    }
}

/*
0 denotes left
1 denotes right
2 denotes top
3 denotes bottom
 */
