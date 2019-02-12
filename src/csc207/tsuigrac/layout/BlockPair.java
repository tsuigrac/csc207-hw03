package csc207.tsuigrac.layout;

public class BlockPair implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock contents;
  int width;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BlockPair(TextBlock _contents) {
    this.contents = _contents;
    this.width = this.contents.width() * 2;
  }



  public String row(int i) throws Exception {
    String original = this.contents.row(i);
    String pair = original.concat(original);
    return pair;
  }


  public int height() {
    return this.contents.height();
  }

  public int width() {
    return this.width;
  }


}


