
public class AsciiTest {

  public static void main(String[] args) {
    
    int test = 1;

    if (testStackPushPeek())
      test--;
    else
      System.out.println("testStackPushPeek failed!");

//    if (testCanvas())
//      test--;
//    else
//      System.out.println("testCanvas failed!");

//    if (DigitProductSequenceGeneratorTest())
//      test--;
//    else
//      System.out.println("DigitProductSequenceGeneratorTest failed!");


    System.out.println(test + " tests failed!");

  }


  // This test should create a stack, push a DrawingChange onto the stack, and then use peek to verify
  // that the correct item is at the top of the stack. You will notice that we don’t actually have a
  // DrawingChange class yet– go ahead and do that next.
  public static boolean testStackPushPeek() {
DrawingStack testStack = new DrawingStack();
DrawingChange testChange1 = new DrawingChange(1,1,'x', 'y');
DrawingChange testChange2 = new DrawingChange(2,2,'c', 'k');

testStack.push(testChange1);

if(testStack.size() != 1) return false;

if(!testStack.peek().equals(testChange1)) return false;

testStack.push(testChange2);

if(!testStack.peek().equals(testChange2)) return false;

testStack.pop();

if(!testStack.peek().equals(testChange1)) return false;

    return true;
  }

  // This test method, like your main methods from previous assignments, should run multiple other
  // test methods. runStackTestSuite should return false if any of its component tests fail, and true
  // if they all succeed. We will run this specific test method against several StackADT
  // implementations (some working, some broken)

  public static boolean runStackTestSuite() {
    return false;
  }
  
  
  public static boolean testCanvas() {
    
    Canvas testCanvas = new Canvas(3,3);
    
    testCanvas.draw(0, 0, 'x');
    testCanvas.draw(1, 1, 'x');
    testCanvas.draw(2, 2, 'x');
//    testCanvas.draw(3, 3, 'x');
    
    String testDraw = testCanvas.toString();
    
    System.out.println(testDraw);
    
    testCanvas.undo();
    
 testDraw = testCanvas.toString();
    
    System.out.println(testDraw);
    
    testCanvas.redo();
//    
 testDraw = testCanvas.toString();
//    
    System.out.println(testDraw);
    
    return false;
  }
}
