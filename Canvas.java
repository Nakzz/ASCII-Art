public class Canvas{
  private final int width;  // width of the canvas
  private final int height; // height of the canvas
   
  private char [][] drawingArray; // 2D character array to store the drawing
   
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  public Canvas(int width, int height) { ... } // Constructor. Throws IllegalArgumentException if width or height is 0 or negative
  // A Canvas is initially blank (use the space ' ' character)

public void draw(int row, int col, char c) { ... } // Draw a character at the given position
  // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
  // If that position is already marked with a different character, overwrite it.
  // After making a new change, add a matching DrawingChange to the undoStack so that we can undo if needed.
  // After making a new change, the redoStack should be empty.

public boolean undo() { ... } // Undo the most recent drawing change. Return true if successful. False otherwise.
  // An undone DrawingChange should be added to the redoStack so that we can redo if needed.

public boolean redo() { ... } // Redo the most recent undone drawing change. Return true if successful. False otherwise.
  // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.

public String toString() { ... } // Return a printable string version of the Canvas.
/* Format example: [_ is blank. Use System.lineSeparator() to put a newline character between rows]
* X___X
* _X_X_
* __X__
* _X_X_
* X___X
*/


//additional (optional) public methods:
//
//Accessors and/or mutators for the private fields listed above.
//public void printDrawing() which prints the Canvas’s string representation to System.out.
//If you create this method, your driver class may call it. Otherwise, your driver will need to use your Canvas’s toString() method to display a drawing.
//public void printHistory() which prints a record of the changes that are stored on the undoStack.
//We have no specific requirements for this method, but you may find it helpful for understanding what your program is doing. We included some calls to this method in the sample run at the top of this page.
//

}