package csc207.tsuigrac.layout;
//Cite later

public class TruncatedBlock implements TextBlock{

  // +--------+------------------------------------------------------------     
  // | Fields |                                                                 
  // +--------+                                                                 

  TextBlock contents;
  int maxWidth;


  // +--------------+------------------------------------------------------     
  // | Constructors |                                                           
  // +--------------+                                                           

  public TruncatedBlock(TextBlock _contents, int _maxWidth) {
    this.contents = _contents;
    this.maxWidth = _maxWidth;
  }


  // +---------+-----------------------------------------------------------     
  // | Methods |                                                                
  // +---------+                                                                

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

