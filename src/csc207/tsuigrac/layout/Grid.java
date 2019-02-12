package csc207.tsuigrac.layout;

public class Grid implements TextBlock{
    private int width;
    private int height;
    private char ch;
    
    public Grid(int width, int height, char ch) {
      this.width = width;
      this.height = height;
      this.ch = ch;
    }//Grid
    
    public int width() {
      return this.width;
    }
    
    public int height() {
      return this.height;
    }
    
    public String row(int i) {
      String word = "";
      for (int j = 0; j < this.width; j++) {
        word = word.concat((Character.toString(this.ch)));
      }
      return word;
    }
    
}
