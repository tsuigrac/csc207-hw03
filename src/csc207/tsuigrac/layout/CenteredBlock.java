package csc207.tsuigrac.layout;

public class CenteredBlock implements TextBlock {
  int width; 
  TextBlock line;
  
  
  public CenteredBlock(TextBlock line, int width) throws Exception {
    this.line = line; 
    this.width = width;
  }
  
  public int width() {
    int addWidth = this.line.width() - this.width;
    this.width = this.width + addWidth;
    return this.width;
  }
  
  public int height() {
    return this.line.height();
  }
  
  public String row(int i) throws Exception {
    String word = " "; 
    
    if(this.width() < line.width()) {
      throw new Exception("Invalid row " + i);
    }else if(this.width() == line.width()) {
      word = line.row(i);
    }else {
      int spaceLength = (this.width() - line.width())/2 ;
      String firstSpaces = TBUtils.spaces(spaceLength);
      String secondSpaces = firstSpaces;
      word = (firstSpaces.concat(line.row(i))).concat(secondSpaces); 
    }
    return word;
  }
}
