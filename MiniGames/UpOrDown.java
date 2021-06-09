import DLibX.*;
import java.awt.Color;
import java.util.Random;

public class UpOrDown implements MiniGame{
  public int playGame(DConsole dc){
    dc.setOrigin(DConsole.ORIGIN_CENTER);//setup
    Random ran = new Random();

    int playerX = dc.getWidth() / 2;//player setup
    int playerY = dc.getHeight() - 50;

    int lives = 1;//score and lives setup
    int score = 0;

    int block1x = 600;//bottom obstacle setup
    int block1y = dc.getHeight() - 35;

    int block2x = 900;//top obstacle setup
    int block2y = 10;

    dc.clear();

    dc.drawString("PRESS SPACE TO DODGE!!", dc.getWidth() / 2, dc.getHeight() / 2);//game start instructions
    dc.redraw();
    dc.pause(1000);

    while (lives > 0){//main game code
      dc.clear();

      playerY = dc.getHeight() - 50;//player movement
      if(dc.isKeyPressed(' ')) {
        playerY = 50;
      }

      block1x -= 5;//block movement
      block2x -= 5;

      if(block1x <= -50){//obstacle respawn
        block1x = (600 + ran.nextInt(201));
        score++;
      }
      if(block2x <= -50){
        block2x = (801 + ran.nextInt(200));
        score++;
      }

      boolean done = false;//check to see if obstacles are too close
      while(!done){
        int xDiff = block1x - block2x;
        double dist = Math.sqrt(xDiff * xDiff);

        if(dist > 150) {
          done = true;
        }else{
          block2x = 600 + ran.nextInt(201);
        }
      }

      int xDiff3 = playerX - block1x;//calculate dist of player to obstacle
      int yDiff3 = playerY - block1y;
      double dist3 = Math.sqrt(xDiff3 * xDiff3 + yDiff3 * yDiff3);

      if(dist3 < 30) {//collision check
        lives--;
      }

      int xDiff4 = playerX - block2x;//calculate dist of player to obstacle
      int yDiff4 = playerY - block2y;
      double dist4 = Math.sqrt(xDiff4 * xDiff4 + yDiff4 * yDiff4);

      if(dist4 < 50) {//collision check
        lives--;
      }

      dc.fillEllipse(playerX, playerY, 20, 20);//player

      dc.fillRect(block1x, block1y, 50, 200);//bottom obstacle
      dc.fillRect(block2x, block2y, 50, 200);//top obstacle

      dc.drawString(score, 20, 20);//score display

      dc.redraw();
      dc.pause(20);
    }
    return score;
  }
}