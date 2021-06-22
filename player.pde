
class Player {
  PVector[] position;
  PVector[] velocity;
  PVector[] acceleration;
  int move;
  boolean dead;
  
  Player() {
     dead = false;
     move = 0;
     position = new PVector[1000];
     position[move] = new PVector(width/2, height/2);
     velocity = new PVector[1000];
     velocity[move] = new PVector(0,0);
     acceleration = new PVector[1000];
     acceleration[move] = new PVector(0,0);
  }
  
  void show() {
    fill(0, 255, 0); 
    if (dead == true) {
       text(move, position[move - 1].x + 30, position[move - 1].y);
       
     } else {
       ellipse(position[move].x, position[move].y, 5, 5);
     } 
}
  void move() {
    if (position[move].x<2 || position[move].y < 2 || position[move].x > width-2 || position[move].y > width-2 || move > 999) {
        dead = true;
        move = 999;
    } else {
      move++;
      acceleration[move] = new PVector();
      acceleration[move].x = random(-5,5);
      acceleration[move].y = random(-5,5);
      velocity[move] = velocity[move - 1];
      velocity[move].add(acceleration[move]);
      velocity[move].limit(5);
      position[move] = position[move - 1];
      position[move].add(velocity[move]);
    }
    
  }
}
