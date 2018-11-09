import java.util.Iterator;


// Since your DrawingStack will only contain DrawingChanges, DrawingStack must not be generic.

// Your DrawingStack should use this Node class to implement a stack using a chain-of-linked-nodes
// approach. Do not create an array or ArrayList based stack implementation.

public class DrawingStack implements StackADT<DrawingChange> {

  private Node<DrawingChange> top; // top of the linked list
  private int size;// size of the stack
  DrawingStackIterator iterator; // iterator of the object


  /**
   * Creates a new DrawingStack object
   * 
   */

  public DrawingStack() {

    this.top = null;
    this.size = 0;
    this.iterator = new DrawingStackIterator(top);
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // TODO: test with null element
    if (element == null)
      throw new IllegalArgumentException();


    Node<DrawingChange> node = new Node<DrawingChange>(element, this.top);


    // set new top
    this.top = node;

    // increment size
    this.size++;

  }

  /**
   * Remove the element on the stack top and return it
   * 
   * @return the element removed from the stack top
   */
  @Override
  public DrawingChange pop() {


    // set new top
    top = top.getNext();

    // decrement size
    size--;

    return null;
  }

  /**
   * Get the element on the stack top
   * 
   * @return the element on the stack top
   */
  @Override
  public DrawingChange peek() {
    // return top data
    return this.top.getData();
  }

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {

    if (this.size == 0)
      return true;
    else
      return false;
  }

  /**
   * Get the number of elements in the stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * 
   * @return iterator of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {

    return this.iterator;
  }


}
