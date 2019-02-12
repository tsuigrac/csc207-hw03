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

 public RightJustified(TextBlock _contents, int _width) {
   this.contents = _contents;
   this.width = _width;
 }



  public String row(int i) throws Exception {
    String result = this.contents.row(i);
    int length = result.length();
    if(length < this.width) {
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


