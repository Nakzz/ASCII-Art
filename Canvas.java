public class Canvas{
  private final int width;  // width of the canvas
  private final int height; // height of the canvas
   
  private char [][] drawingArray; // 2D character array to store the drawing
   
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  
  
  /**
   * Constructor method that initializes object values
   * 
   * @param width width of the canvas
   * @param height height of the canvas
   */
  public Canvas(int width, int height) { 

    if(width < 1 || height < 1) throw new IllegalArgumentException();
    
    this.width = width;
    this.height = height;
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
    
    drawingArray = new char[height][width];
    
  } // Constructor. Throws IllegalArgumentException if width or height is 0 or negative
  // A Canvas is initially blank (use the space ' ' character)

public void draw(int row, int col, char c) { 

  if(width <= row || height <= col) throw new IllegalArgumentException();
  
  char currentChar = drawingArray[row][col];
  

    DrawingChange change = new DrawingChange(row, col, currentChar, c);
    undoStack.push(change);   
  
  
  drawingArray[row][col] = c;
  
 

} // Draw a character at the given position
  // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
  // If that position is already marked with a different character, overwrite it.
  // After making a new change, add a matching DrawingChange to the undoStack so that we can undo if needed.
  // After making a new change, the redoStack should be empty.

public boolean undo() { 
  
  DrawingChange change =undoStack.peek();
  
  
  redoStack.push(undoStack.peek());
  
  draw(change.x, change.y, change.prevChar);
  
  if(drawingArray[change.x][change.y] == change.prevChar) {

    //TODO: undo should pop a change correct?
    return true;
  } else return false;
  
  
} // Undo the most recent drawing change. Return true if successful. False otherwise.
  // An undone DrawingChange should be added to the redoStack so that we can redo if needed.

public boolean redo() { 
  
  DrawingChange change =redoStack.peek();
  
  undoStack.push(redoStack.peek());
  
  draw(change.x, change.y, change.newChar);
  
  if(drawingArray[change.x][change.y] == change.prevChar) {

    //TODO: redo should pop a change correct?
    return true;
  } else return false;
  
} // Redo the most recent undone drawing change. Return true if successful. False otherwise.
  // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.

public String toString() {
  
  String output = "";
  
  for(int i=0; i < height; i++) {
    for(int j=0; j < width; j++) {
      if(drawingArray[i][j] == '\u0000') {
        output += " ";
      } else {
        output += Character.toString(drawingArray[i][j]); 
      }
      //System.out.print(drawingArray[i][j]);
    }
    output += System.lineSeparator();
  }
  
  return output; 

} // Return a printable string version of the Canvas.
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