import DLibX.*;
import MiniGames.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

  public static void main(String[] args) {


    // credit to DiRamio and respective classmates for a portion of this code
    DConsole dc = new DConsole(600,400);
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    Random r = new Random();

    ArrayList<MiniGame> game = new ArrayList<>();
    //add games here vvvvv
    //basic format game.add(new ______());
    // game.add(new FlappyBird());
      
      MiniGame sg = new Boss2();
      sg.playGame(dc);
    
    
    /*
    //sorting MiniGames
    ArrayList<MiniGame> games = new ArrayList<>();
    int arraySize = game.size();
    for(int i = 0; i < arraySize; i++){
      MiniGame temp = game.get(r.nextInt(game.size()));
      games.add(temp);
      game.remove(temp);
    }
    // play games FOREVER!
    int level = 0;
    while(true) {
      
      MiniGame toPlay = games.get(level); // randomly choose a game
      int score = toPlay.playGame(dc); // play the game

      // display how they did in the current game
      dc.clear();
      dc.drawString("You got " + score, dc.getWidth() / 2, dc.getHeight() / 2);
      dc.redraw();

      dc.pause(2000);
      level++;
      
      
    }
    */

  }


}