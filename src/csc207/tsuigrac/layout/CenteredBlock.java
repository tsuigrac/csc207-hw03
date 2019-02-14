package csc207.tsuigrac.layout;

public class CenteredBlock implements TextBlock {
  int width; 
  TextBlock line;
  
  /**
   * @param line, a TextBlock
   *        width, the width of the block
   *        
   *
   */
  public CenteredBlock(TextBlock line, int width) throws Exception {
    this.line = line; 
    this.width = width;
  }
  
  public int width() {
    return this.width;
  }
  
  public int height() {
    return this.line.height();
  }
  
  /**
   * @param - i, the row number
   * @return the original string centered according to the specified width
   *         
   * @preconditions i < height
   *                the original word length is smaller than the width of the block
   *
   */
  public String row(int i) throws Exception {
    String word = " "; 
    int boxWidth = this.width;
    //Throw error if the line length is too long
    if(boxWidth < this.line.width()) {
      throw new Exception("Invalid row " + i);
      //If the line length is equal to the box width, return original word
    }else if(boxWidth== this.line.width()) {
      word = this.line.row(i);
      //If the line length is smaller than the box width,
    }else {
      //Add spaces on either side of the word
      int spaceLength = (boxWidth - this.line.width())/2 ;
      String firstSpaces = TBUtils.spaces(spaceLength);
      String secondSpaces = firstSpaces;
      word = (firstSpaces.concat(this.line.row(i))).concat(secondSpaces); 
    }
    return word;
  }
}
