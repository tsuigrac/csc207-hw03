package csc207.tsuigrac.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);
    
    /*
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*')));
    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new CenteredBlock(block, 11));
    TBUtils.print(pen, block2);
    
    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock block3 = new BoxedBlock(new VComposition(top,bottom));
    TBUtils.print(pen, block3);
    
    TextBlock block4 = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block5 = new TruncatedBlock(block4, 3);
    TBUtils.print(pen, block4);
    TBUtils.print(pen, block5);
    
    TextBlock block4 = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TBUtils.print(pen, block4);
    TextBlock blockPair = new BlockPair(block4);
    TBUtils.print(pen, blockPair);
  */
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new CenteredBlock(tb1, 15);
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb1.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
