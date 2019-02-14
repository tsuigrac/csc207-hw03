package csc207.tsuigrac.layout;

public class Grid implements TextBlock{
    private int width;
    private int height;
    private char ch;
    
    /**
     * @param - width, the width of the grid
     *        - height, the height of the grid
     *        - ch, the character that the grid should be made out of
     */
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
    
    /**
     * @param i, the row number
     * @return the character repeated 'width' number of times with lines on both sides
     * @preconditions: i < height
     */
    public String row(int i) {
      String word = "";
      for (int j = 0; j < this.width; j++) {
        word = word.concat((Character.toString(this.ch)));
      }
      return word;
    }
    
}
