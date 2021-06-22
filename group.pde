class Group { 
  Player[] a;
  
  Group(int size) {
    a = new Player[size];
    for (int i = 0; i < size; i++) {
      a[i] = new Player();
    }
  }
  
  void move() {
    for (int i = 0; i < a.length; i++) {
      a[i].move();
      a[i].show();
    }
  }
  
}
