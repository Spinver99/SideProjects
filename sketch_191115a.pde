Group a;
int round;

void setup() {
  size(800,800);
  a = new Group(100);
  round = 0;
}

void draw() {
  background(255);
  text("Round " + round, 400,400);
  a.move();
  round++;
}
