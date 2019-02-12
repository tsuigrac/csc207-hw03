package csc207.tsuigrac.layout;

public class CenteredBlock implements TextBlock {
  int width; 
  TextBlock line;
  
  
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
  
  public String row(int i) throws Exception {
    String word = " "; 
    int boxWidth = this.width;
    if(boxWidth < this.line.width()) {
      throw new Exception("Invalid row " + i);
    }else if(boxWidth== this.line.width()) {
      word = this.line.row(i);
    }else {
      int spaceLength = (boxWidth - this.line.width())/2 ;
      String firstSpaces = TBUtils.spaces(spaceLength);
      String secondSpaces = firstSpaces;
      word = (firstSpaces.concat(this.line.row(i))).concat(secondSpaces); 
    }
    return word;
  }
}
