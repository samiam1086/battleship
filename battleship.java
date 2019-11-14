
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class battleship{
  
  // le global variables
  private static String inputString = "X3";
  private static JTextField inputField;
  private static int diff = 0;
  
  // lets make the computer board 
  public static int[][] setupCompBoard(int[][] compboard){
    compboard = new int[12][10];
    int err = 0;
    // make the battleship
     // will it be horizontal or vertical?
    int hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
    if(hov == 1){
      // if its a 1 then its horizontal 
      int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
      int x = (int)(Math.random() * ((5 - 4) + 1)) + 4; // left and right
      compboard[y][x] = 5;
      for(int i = x + 1; i <= x + 4; i++){
        compboard[y][i] = 5;
      }
    }else{
      // if its a 2 then its vertical
      int y = (int)(Math.random() * ((5 - 4) + 1)) + 4; // up and down
      int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
      compboard[y][x] = 5;
      // add the battleship to the array
      for(int i = y + 1; i <= y + 4; i++){
        compboard[i][x] = 5;
      }
    }
    
    
   // make the cruizers
    boolean usec = true;
    for(int j = 1; j <= 2; j++){
      usec = true;
      restartc:
      while(usec == true){
        // will the cruizers be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
       
        if(hov == 1){
          
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((6 - 3) + 1)) + 3; // left and right
          // check to see if the origion spot is already occupied
          if(compboard[y][x] > 0){
            j--;
            break restartc;
          // if its not occupied build the ship
          }else if(compboard[y][x] == 0){
            compboard[y][x] = 3;
          }
          // check to see if any of the other spots are taken if so delete to ship and give an error in the err var
          for(int i = x + 1; i <= x + 2; i++){
            if(compboard[y][i] > 0){
              for(int r = i - 1; r >= x - 1; r--){
                compboard[y][i] = 0;
              }
              err++;
              j--;
              compboard[y][x] = 5;
              break restartc;
            }else if(compboard[y][i] == 0){
              compboard[y][i] = 3;
            }
          }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((6 - 3) + 1)) + 3; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(compboard[y][x] > 0){
            j--;
            break restartc;
          }else if(compboard[y][x] == 0){
            compboard[y][x] = 3;
          }
          for(int i = y + 1; i <= y + 2; i++){
            if(compboard[i][x] > 0){
              for(int r = i - 1; r >= y - 1; r--){
                compboard[i][x] = 0;
              }
              err++;
              j--;
              compboard[y][x] = 5;
              break restartc;
            }else if(compboard[i][x] == 0){
              compboard[i][x] = 3;
            }
          }
        }
      usec = false;
     } 
    }
    
    
     // make the submarines
    boolean uses = true;
    for(int l = 1; l <= 2; l++){
      uses = true;
      restarts:
      while(uses == true){
        // will the cruizers be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
       
        if(hov == 1){
          
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((5 - 4) + 1)) + 4; // left and right
          if(compboard[y][x] > 0){
            l--;
            break restarts;
          }else if(compboard[y][x] == 0){
            compboard[y][x] = 4;
          }
          for(int i = x + 1; i <= x + 3; i++){
            if(compboard[y][i] > 0){
              for(int r = i - 1; r >= x - 1; r--){
                compboard[y][i] = 0;
              }
              err++;
              l--;
              compboard[y][x] = 0;
              break restarts;
            }else if(compboard[y][i] == 0){
              compboard[y][i] = 4;
            }
          }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((5 - 4) + 1)) + 4; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(compboard[y][x] > 0){
            l--;
            break restarts;
          }else if(compboard[y][x] == 0){
            compboard[y][x] = 4;
          }
          for(int i = y + 1; i <= y + 3; i++){
            if(compboard[i][x] > 0){
              for(int r = i - 1; r >= y - 1; r--){
                compboard[i][x] = 0;
              }
              err++;
              l--;
              compboard[y][x] = 0;
              break restarts;
            }else if(compboard[i][x] == 0){
              compboard[i][x] = 4;
            }
          } // jeez thats a lot of brackets
        }
      uses = false;
     } 
    }

    
    
    // make the tugboats
    boolean uset = true;
    for(int k = 1; k <= 3; k++){
      uset = true;
      restartt:
      while(uset == true){
        // will the tugboats be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
        
        if(hov == 1){
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((7 - 2) + 1)) + 2; // left and right
        
        if(compboard[y][x] > 0){ // if the origin spot is taken restart the ship build
          k--;
          break restartt;
        }
        // building the origin spot
        compboard[y][x] = 2;
        // building the rest of the boat
        for(int i = x; i <= x + 2; i++){
          // check to see if the rest of the spots are taken and build the boat
          if(compboard[y][i] > 0){
            for(int r = i - 1; r >= x; r--){
              compboard[y][i] = 0;
            }
            break restartt;
          }
          compboard[y][i] = 2;
        }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((7 - 2) + 1)) + 2; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(compboard[y][x] > 0){
            break restartt;
          }
          compboard[y][x] = 2;
          for(int i = y; i <= y + 2; i++){
            if(compboard[i][x] > 0){
              for(int r = i - 1; r >= y; r--){
                compboard[i][x] = 0;
              }
              break restartt;
            }
            compboard[i][x] = 2;
          }
        }
      uset = false;
     }
    }
    
    if(err >= 1){
      compboard[11][0] = 1;
      return compboard;
    }else{
      compboard[11][0] = 0;
      return compboard;
    }
  }
  
  
  public static int[][] setupPlrBoard(int[][] playerboard){
    playerboard = new int[12][10];
    int err = 0;
    // make the battleship
     // will it be horizontal or vertical?
    int hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
    if(hov == 1){
      // if its a 1 then its horizontal 
      int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
      int x = (int)(Math.random() * ((5 - 4) + 1)) + 4; // left and right
      playerboard[y][x] = 5;
      for(int i = x + 1; i <= x + 4; i++){
        playerboard[y][i] = 5;
      }
    }else{
      // if its a 2 then its vertical
      int y = (int)(Math.random() * ((5 - 4) + 1)) + 4; // up and down
      int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
      playerboard[y][x] = 5;
      for(int i = y + 1; i <= y + 4; i++){
        playerboard[i][x] = 5;
      }
    }
    
    
   // make the cruizers
    boolean usec = true;
    for(int j = 1; j <= 2; j++){
      usec = true;
      restartc:
      while(usec == true){
        // will the cruizers be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
       
        if(hov == 1){
          
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((6 - 3) + 1)) + 3; // left and right
          if(playerboard[y][x] > 0){
            j--;
            break restartc;
          }else if(playerboard[y][x] == 0){
            playerboard[y][x] = 3;
          }
          for(int i = x + 1; i <= x + 2; i++){
            if(playerboard[y][i] > 0){
              for(int r = i - 1; r >= x - 1; r--){
                playerboard[y][i] = 0;
              }
              err++;
              j--;
              playerboard[y][x] = 5;
              break restartc;
            }else if(playerboard[y][i] == 0){
              playerboard[y][i] = 3;
            }
          }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((6 - 3) + 1)) + 3; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(playerboard[y][x] > 0){
            j--;
            break restartc;
          }else if(playerboard[y][x] == 0){
            playerboard[y][x] = 3;
          }
          for(int i = y + 1; i <= y + 2; i++){
            if(playerboard[i][x] > 0){
              for(int r = i - 1; r >= y - 1; r--){
                playerboard[i][x] = 0;
              }
              err++;
              j--;
              playerboard[y][x] = 5;
              break restartc;
            }else if(playerboard[i][x] == 0){
              playerboard[i][x] = 3;
            }
          }
        }
      usec = false;
     } 
    }
    
    
     // make the submarines
    boolean uses = true;
    for(int l = 1; l <= 2; l++){
      uses = true;
      restarts:
      while(uses == true){
        // will the cruizers be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
       
        if(hov == 1){
          
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((5 - 4) + 1)) + 4; // left and right
          if(playerboard[y][x] > 0){
            l--;
            break restarts;
          }else if(playerboard[y][x] == 0){
            playerboard[y][x] = 4;
          }
          for(int i = x + 1; i <= x + 3; i++){
            if(playerboard[y][i] > 0){
              for(int r = i - 1; r >= x - 1; r--){
                playerboard[y][i] = 0;
              }
              err++;
              l--;
              playerboard[y][x] = 0;
              break restarts;
            }else if(playerboard[y][i] == 0){
              playerboard[y][i] = 4;
            }
          }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((5 - 4) + 1)) + 4; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(playerboard[y][x] > 0){
            l--;
            break restarts;
          }else if(playerboard[y][x] == 0){
            playerboard[y][x] = 4;
          }
          for(int i = y + 1; i <= y + 3; i++){
            if(playerboard[i][x] > 0){
          
              for(int r = i - 1; r >= y - 1; r--){
                playerboard[i][x] = 0;
              }
              err++;
              l--;
              playerboard[y][x] = 0;
              break restarts;
            }else if(playerboard[i][x] == 0){
              playerboard[i][x] = 4;
            }
          }
        }
      uses = false;
     } 
    }

    
    
    // make the tugboats
    boolean uset = true;
    for(int k = 1; k <= 3; k++){
      uset = true;
      restartt:
      while(uset == true){
        // will the tugboats be h or v
        hov = (int)(Math.random() * ((1 - 0) + 1)) + 0;
        
        if(hov == 1){
          // if its a 1 then its horizontal 
          int y = (int)(Math.random() * ((9 - 0) + 1)) + 0; // up and down
          int x = (int)(Math.random() * ((7 - 2) + 1)) + 2; // left and right
        
        if(playerboard[y][x] > 0){ // if the origin spot is taken restart the ship build
          k--;
          break restartt;
        }
        // building the origin spot
        playerboard[y][x] = 2;
        // building the rest of the boat
        for(int i = x; i <= x + 2; i++){
          // check to see if the rest of the spots are taken and build the boat
          if(playerboard[y][i] > 0){
            for(int r = i - 1; r >= x; r--){
              playerboard[y][i] = 0;
            }
            break restartt;
          }
          playerboard[y][i] = 2;
        }
        }else{
          // if its a 2 then its vertical
          int y = (int)(Math.random() * ((7 - 2) + 1)) + 2; // up and down
          int x = (int)(Math.random() * ((9 - 0) + 1)) + 0; // left and right
          if(playerboard[y][x] > 0){
            break restartt;
          }
          playerboard[y][x] = 2;
          for(int i = y; i <= y + 2; i++){
            if(playerboard[i][x] > 0){
              for(int r = i - 1; r >= y; r--){
                playerboard[i][x] = 0;
              }
              break restartt;
            }
            playerboard[i][x] = 2;
          }
        }
      uset = false;
     }
    }
    
    if(err >= 1){
      playerboard[11][0] = 1;
      return playerboard;
    }else{
      playerboard[11][0] = 0;
      return playerboard;
    }
  }
  
  
  public static int[][] compAtk(int[][] playerboard){
    
    if(diff == 1){
      // pick a random row and column
      int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
      int column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
      // check to see if the computer has shot there already
      while(playerboard[row][column] == 8){
        // if it has shot there get a new row column
        row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
      }
      // check to see if its a hit or miss
      if(playerboard[row][column] > 0 && playerboard[row][column] < 7){
        playerboard[row][column] = 9;
        playerboard[11][1] = 1;
      }else{
        playerboard[row][column] = 8;
        playerboard[11][1] = 0;
      }
    }else if(diff == 2){
      // the chance to guarentee a shot
      int shotch = (int)(Math.random() * ((15 - 1) + 1)) + 1;
      // if the shotch num is a 2 then the shot is guarenteed to hit
      if(shotch == 2){
        //get a row and column
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        // check to see if it will hit
        while(playerboard[row][column] < 2 || playerboard[row][column] > 7){
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        }
        // update playerboard
        playerboard[row][column] = 9;
        playerboard[11][1] = 1;
      }else{
        // pick a random row and column
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        // check to see if the computer has shot there already
        while(playerboard[row][column] == 8){
          // if it has shot there get a new row column
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        }
        // check to see if its a hit or miss
        if(playerboard[row][column] > 0 && playerboard[row][column] < 7){
          playerboard[row][column] = 9;
          playerboard[11][1] = 1;
        }else{
          playerboard[row][column] = 8;
          playerboard[11][1] = 0;
        }
      }
    }else if(diff == 3){
      
      int shotch = (int)(Math.random() * ((10 - 1) + 1)) + 1;
      // if the shotch num is a 2 then the shot is guarenteed to hit
      if(shotch == 2){
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        
        while(playerboard[row][column] < 2 || playerboard[row][column]  > 7){
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        }
        playerboard[row][column] = 9;
        playerboard[11][1] = 1;
        // else its just a random shot that goes 
      }else{
        // pick a random row and column
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        // check to see if the computer has shot there already
        while(playerboard[row][column] == 8){
          // if it has shot there get a new row column
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        }
        // check to see if its a hit or miss
        if(playerboard[row][column] > 0 && playerboard[row][column] < 7){
          playerboard[row][column] = 9;
          playerboard[11][1] = 1;
        }else{
          playerboard[row][column] = 8;
          playerboard[11][1] = 0;
        }
      }
    }else if(diff == 4){
      
      int shotch = (int)(Math.random() * ((4 - 1) + 1)) + 1;
      if(shotch == 2){
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        
        while(playerboard[row][column] < 2 || playerboard[row][column] > 7){
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        }
        playerboard[row][column] = 9;
        playerboard[11][1] = 1;
      }else{
        // pick a random row and column
        int row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        int column = (int)(Math.random() * ((9 - 0) + 1)) + 0;
        // check to see if the computer has shot there already
        while(playerboard[row][column] == 8){
          // if it has shot there get a new row column
          row = (int)(Math.random() * ((9 - 0) + 1)) + 0;
          column = (int)(Math.random() * ((9 - 0) + 1)) + 0; 
        }
        // check to see if its a hit or miss
        if(playerboard[row][column] > 0 && playerboard[row][column]  < 7){
          playerboard[row][column] = 9;
          playerboard[11][1] = 1;
        }else{
          playerboard[row][column] = 8;
          playerboard[11][1] = 0;
        }
      }
    }
    return playerboard;
  }

  
  public static String shipsTxt(int[][] compboardpcs, int[][] playerboard, String plrAreaTxt){
    // Scan through all the necessary arrays and take the assosiated number in the array to a 
    // letter in the below if else chains and add it to the plrAreaTxt string to be displayed in plyArea
    plrAreaTxt = "\n";
    plrAreaTxt = plrAreaTxt + "\t   Comp board\t \t \tYour board \n";
    plrAreaTxt = plrAreaTxt + "\t   +|0|1|2|3|4|5|6|7|8|9|\t \t+|0|1|2|3|4|5|6|7|8|9| \n";
    for(int i = 0; i <= 9; i++){
      plrAreaTxt = plrAreaTxt + "\t   " +((char)(65 + i)) + "|";
      for(int j = 0; j <= 9; j++){
        if(compboardpcs[i][j] == 0){
          plrAreaTxt = plrAreaTxt + " |";
        }else if(compboardpcs[i][j] == 8){
          plrAreaTxt = plrAreaTxt + "M|";
        }else if(compboardpcs[i][j] == 9){
          plrAreaTxt = plrAreaTxt + "X|";  
        }
      }
      
      plrAreaTxt = plrAreaTxt + "\t \t";
      plrAreaTxt = plrAreaTxt + ((char)(65 + i)) + "|";
      for(int k = 0; k <= 9; k++){
        if(playerboard[i][k] == 0){
          plrAreaTxt = plrAreaTxt + " |";
        }else if(playerboard[i][k] == 2){
          plrAreaTxt = plrAreaTxt + "T|";
        }else if(playerboard[i][k] == 3){
          plrAreaTxt = plrAreaTxt + "C|";
        }else if(playerboard[i][k] == 4){
          plrAreaTxt = plrAreaTxt + "S|";
        }else if(playerboard[i][k] == 5){
          plrAreaTxt = plrAreaTxt + "B|";
        }else if(playerboard[i][k] == 8){
          plrAreaTxt = plrAreaTxt + "M|";
        }else if(playerboard[i][k] == 9){
          plrAreaTxt = plrAreaTxt + "X|";
        }
      }
      plrAreaTxt = plrAreaTxt + "\n";
    }
  return plrAreaTxt;
  }
  
  // sleep method to create delays in between turns
  public static void sleep(int seconds){
  
    try{        
      Thread.sleep(seconds);
    }catch(InterruptedException ex){  
      //Thread.currentThread().interrupt();
    }
  }
  
  
  public static void main(String args[]){
    String plrAreaTxt = "";
    // the fonts I use
    Font font = (new Font(Font.MONOSPACED, Font.BOLD, 14));
    Font font1 = new Font("Garamond", Font.BOLD, 17);
    Font font2 = new Font("Arial", Font.PLAIN, 25);
    Font font3 = (new Font(Font.MONOSPACED, Font.BOLD, 24));
    
    // main page text
    JTextPane beginPane = new JTextPane();
    beginPane.setText("Pick a difficulty");
    beginPane.setBounds(330, 90, 125, 25);
    beginPane.setEditable(false);
    beginPane.setFont(font1);
    beginPane.setForeground(Color.BLACK);
    
    // the easy button
    JButton eBtn = new JButton("Easy");
    eBtn.setBounds(205, 290, 90, 25);
    eBtn.setFont(font);
    
    // the normal button
    JButton nBtn = new JButton("Normal");
    nBtn.setBounds(305, 290, 90, 25);
    nBtn.setFont(font);
    
    // the hard button
    JButton hBtn = new JButton("Hard");
    hBtn.setBounds(405, 290, 90, 25);
    hBtn.setFont(font);
    
    // the stupid hard button
    JButton fBtn = new JButton("gg");
    fBtn.setBounds(505, 290, 90, 25);
    fBtn.setFont(font);

    // the button to attack 
    JButton atkButton = new JButton("Attack"); 
    atkButton.setVisible(false);
    atkButton.setBounds(410, 160, 100, 60); 
    
    //turn area aka textbox that tells you weather or not its your turn or the computers
    JTextPane turnArea = new JTextPane();
    turnArea.setText("It's now your turn.");
    turnArea.setVisible(false);
    turnArea.setEditable(false);
    turnArea.setBounds(270, 90, 200, 50);
    turnArea.setFont(font1);
    turnArea.setForeground(Color.BLACK);
    
    JTextPane title = new JTextPane();
    title.setText("BattleShip by Daniel");
    title.setEditable(false);
    title.setBounds(274, 40, 235, 35);
    title.setFont(font2);
    title.setForeground(Color.BLACK);
    
    JTextPane plyArea = new JTextPane();
    plyArea.setEditable(false);
    plyArea.setVisible(false);
    plyArea.setBounds(70, 260, 640, 285);
    plyArea.setFont(font);
    plyArea.setForeground(Color.BLACK);
    
    inputField = new JTextField("K9");
    inputField.setVisible(false);
    inputField.setFont(font2);
    inputField.setBounds(230, 165, 160, 45);
    
    JFrame window = new JFrame("BattleShip");
    window.setVisible(true);
    window.setSize(800,650);
    window.setResizable(false);
    window.add(title);
    window.add(turnArea);
    window.add(inputField);
    window.add(atkButton);
    window.add(eBtn);
    window.add(nBtn);
    window.add(hBtn);
    window.add(fBtn);
    window.add(beginPane);
    window.add(plyArea, BorderLayout.CENTER);
    window.setLayout(null);
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    atkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        inputString = "";
        inputString = inputField.getText();
        if(inputString.length() > 2){
          inputString = inputString.substring(0,2);
        }
        inputField.setText("");
      }
    });
    
    // easy button action listener
    eBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        diff = 1;
        title.setVisible(false);
        beginPane.setVisible(false);
        eBtn.setVisible(false);
        nBtn.setVisible(false);
        hBtn.setVisible(false);
        fBtn.setVisible(false);
        inputField.setVisible(true);
        plyArea.setVisible(true);
        turnArea.setVisible(true);
        atkButton.setVisible(true);
      }
    });
    
    // normal button action listener
    nBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        diff = 2;
        title.setVisible(false);
        beginPane.setVisible(false);
        eBtn.setVisible(false);
        nBtn.setVisible(false);
        hBtn.setVisible(false);
        fBtn.setVisible(false);
        inputField.setVisible(true);
        plyArea.setVisible(true);
        turnArea.setVisible(true);
        atkButton.setVisible(true);
      }
    });
    
    // hard button action listener
    hBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        diff = 3;
        title.setVisible(false);
        beginPane.setVisible(false);
        eBtn.setVisible(false);
        nBtn.setVisible(false);
        hBtn.setVisible(false);
        fBtn.setVisible(false);
        inputField.setVisible(true);
        plyArea.setVisible(true);
        turnArea.setVisible(true);
        atkButton.setVisible(true);
      }
    });
    
    // stupid hard button action listener
    fBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        diff = 4;
        title.setVisible(false);
        beginPane.setVisible(false);
        eBtn.setVisible(false);
        nBtn.setVisible(false);
        hBtn.setVisible(false);
        fBtn.setVisible(false);
        inputField.setVisible(true);
        plyArea.setVisible(true);
        turnArea.setVisible(true);
        atkButton.setVisible(true);
      }
    });
    
    // all the variables used throughout the game
    boolean game = true;
    boolean cbt = true;
    int turn = 1;
    String row = ""; // This is the variable for the row string
    String column = ""; // Same as the row string but for the columns
    char colCh = 'a'; // takes the column var in char form
    char rowCh = 'a'; // takes the row var in char form
    int introw = 0; // takes the rowCh var from char to int
    int intcol = 0; // takes the colCh var from char to int
    int plrShips = 22;
    int compShips = 22;
    int[][] playerboard = new int[12][10]; // players board array
    int[][] compboardpcs = new int[12][10]; // computers board array that the player can see
    int[][] compboard = new int[12][10]; // computers board player cannot see
   
    // build the computer board
    compboard = setupCompBoard(compboard);
    
    // check to see if it built correctly if not remake it
    while(compboard[11][0] == 1){
      compboard = setupCompBoard(compboard);
    } 
    
    // build the players board
    playerboard = setupPlrBoard(playerboard);
    // check to see if it built correctly or remake it
    while(playerboard[11][0] == 1){
      playerboard = setupPlrBoard(playerboard);
    } 
    
    // take the board info and make it into a string to be displayed in plyArea
    plrAreaTxt = shipsTxt(compboardpcs, playerboard, plrAreaTxt);
    // display the string in plyArea
    plyArea.setText(plrAreaTxt);
    
    // begin the game 
    while(game == true){
    liner: // break point used if the player reenters a posistion theyve already shot at to get back to here
      while(cbt == true){
      if(turn == 1){
        turnArea.setText("Enter a location player A-J & 0-9 ie. A1, B4, C2");
        row = inputString;
        // make sure the input is 2 digits
        while(row.length() != 2){
          row = inputString;// here is where i need the string to go
          sleep(1);
        }
        
        row = inputString;
        // check to see if the strings length is 2 if so convert it through to integers
        if(row.length() == 2){
          column = row.substring(1);
          row = row.substring(0,1);
          rowCh = row.charAt(0);
          rowCh = Character.toLowerCase(rowCh);
          introw = (int)rowCh - 'a';
          colCh = column.charAt(0);
          colCh = Character.toLowerCase(colCh);
          intcol = (int)colCh - '0';
        }
        
        // the checks to ensure nothing gets through
        while((intcol > 9 || intcol  < 0) || (introw > 9 || introw < 0)){
         // turnArea.setText("Enter a location player A-J & 0-9 ie. A1, B4, C2");
          sleep(300);
          row = inputString;
          // while loop to get the program stuck if the input is not the correct length
          while(row.length() != 2){
            row = inputString;// here is where i need the string to go
          }
          
          // make sure its good
          if(row.length() == 2){ 
            column = row.substring(1);
            row = row.substring(0,1);
            rowCh = row.charAt(0);
            rowCh = Character.toLowerCase(rowCh);
            introw = (int)rowCh - 'a';
            colCh = column.charAt(0);
            colCh = Character.toLowerCase(colCh);
            intcol = (int)colCh - '0';            
          }
        }
        // ensure they havent shot there before
        if(compboardpcs[introw][intcol] > 7){
          sleep(300);
          break liner;
        }
        
        // check to see if the shot was a hit otherwise its a miss
        if(compboard[introw][intcol] > 0 && compboardpcs[introw][intcol] < 7){
          compboardpcs[introw][intcol] = 9;
          compboard[introw][intcol] = 9;
          compShips--;
        }else{
         compboardpcs[introw][intcol] = 8;
        }
        // update the board accordingly
        plrAreaTxt = shipsTxt(compboardpcs, playerboard, plrAreaTxt);
        plyArea.setText(plrAreaTxt);
        
        // see if you won
        if(compShips <= 0){
          turnArea.setText("You win!");
          game = false;
          cbt = false;
          break;
        }
        // change turns
        turnArea.setText("It's now the computers turn.");
        inputString = "";
        turn = 2;
      }else{
        // have to computer do its attack
        playerboard = compAtk(playerboard);
        if(playerboard[11][1] == 1){
          plrShips--;
        }
        
        // update the board accordingly
        sleep(1500); // make the text stay up for a bit for astetic ya know
        plrAreaTxt = shipsTxt(compboardpcs, playerboard, plrAreaTxt);
        plyArea.setText(plrAreaTxt);
        // check to see if the computer has won
        if(plrShips <= 0){
          turnArea.setText("The computer wins!");
          game = false;
          cbt = false;
          break;
        }
        // change turns
        turnArea.setText("It's now your turn.");
        turn = 1;
       }
      }
    }
  }
}
