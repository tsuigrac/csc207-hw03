package csc207.tsuigrac.layout;
//Cite later 

public class RightJustified implements TextBlock {
//+--------+------------------------------------------------------------        
 // | Fields |                                                                  
 // +--------+                                                                  

 TextBlock contents;
 int width;


 // +--------------+------------------------------------------------------      
 // | Constructors |                                                            
 // +--------------+                                                            
 /**
  * @param line, a TextBlock 
  *        width, the width of the block   
  *
  */
 public RightJustified(TextBlock _contents, int _width) {
   this.contents = _contents;
   this.width = _width;
 }


 /**
  * @param i, the row number
  * @return the original string, with spaces on the left to make
  *         it right-justified in box of specified width
  *        
  *@throws Exception if the original string is longer than the specified width
  *
  *@preconditions: the original string must be shorter than the specified width
  */
  public String row(int i) throws Exception {
    String result = this.contents.row(i);
    int length = this.contents.row(i).length();
    if(length > this.width) {
      System.out.println("Error");
      throw new Exception("Length too long");
    }else{
      //Add the correct amount of spaces on the left to make it right-justified
      for(int j = 0; j < this.width - length; j++) {
        result = " ".concat(result);
      } 
    }
    return result;
  }


  public int height() {
    return this.contents.height();
  }

  public int width() {                                      
    return this.width;
  }


}


