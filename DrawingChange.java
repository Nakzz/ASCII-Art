public class DrawingChange{

public final int x; // x coordinate for a change
public final int y; // y coordinate for a change
public final char prevChar; // previous character in the (x,y)
public final char newChar; // new character in the (x,y)

/**
 * Constructor method that initializes object values
 * 
 * @param init initial value
 * @param size number of elements in the sequence
 */
public DrawingChange(int x, int y, char prevChar, char newChar) { 
//set the instance fields
  this.x=x;
  this.y =y;
  this.prevChar = prevChar;
  this.newChar = newChar;
  
}

}