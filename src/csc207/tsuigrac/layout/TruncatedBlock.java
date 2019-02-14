package csc207.tsuigrac.layout;

public class TruncatedBlock implements TextBlock{

  // +--------+------------------------------------------------------------     
  // | Fields |                                                                 
  // +--------+                                                                 

  TextBlock contents;
  int maxWidth;


  // +--------------+------------------------------------------------------     
  // | Constructors |                                                           
  // +--------------+                                                           
  /**
   * @param - _contents, a TextBlock
   *        - _maxWidth, the character width of the altered block
   */
  public TruncatedBlock(TextBlock _contents, int _maxWidth) {
    this.contents = _contents;
    this.maxWidth = _maxWidth;
  }


  // +---------+-----------------------------------------------------------     
  // | Methods |                                                                
  // +---------+                                                                
  /**
   * @param - _i, the row number
   * @return the original string of TextBlock truncated to the 
   *         specified length
   *         
   * @preconditions i < height
   * @postconditions - If the original word length is smaller than maxWidth,
   *                   the original string is returned. 
   *                  - If the original word length is longer, then
   *                    the first part of the word is returned with width maxWidth
   *
   */
  public String row(int i) throws Exception {
    String result = this.contents.row(i);
    if (this.contents.row(i).length() > this.maxWidth) {
      result = result.substring(0, maxWidth);
    }
    return result;
  }


  public int height() {
    return this.contents.height();
  }

  public int width() {                                         
    return this.maxWidth;
  }

}

