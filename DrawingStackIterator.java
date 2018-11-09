import java.util.Iterator;

// The DrawingStackIterator you create must implement Iterator<DrawingChange> 
//and must be a direct iterator over your stack.
//Its constructor should take a Node<DrawingChange> as a parameter, and
// your DrawingStack’s iterator() method should return a new DrawingStackIterator 
//that starts at the top of the stack of DrawingChanges.

public class DrawingStackIterator implements Iterator<DrawingChange>{
  private Node<DrawingChange> node; // top of the linked list
  
  public DrawingStackIterator(Node<DrawingChange> node){
this.node = node;
  }
  @Override
  public boolean hasNext() {
    if(this.node.getNext()==null) return false;
    else return true;
  }

  @Override
  public DrawingChange next() {
    return this.node.getNext().getData();
  }
  
}