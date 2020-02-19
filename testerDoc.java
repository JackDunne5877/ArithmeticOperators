import org.junit.*;
import static org.junit.Assert.*;
public class testerDoc{
  /**tests the lookup and update methods of state */
  @Test
  public void testLookupandUpdate(){
    State newState = new State();
    newState.update("lookthisup",1);
    assertEquals(new Integer(1), newState.lookup("lookthisup"));
  }
  
  /**tests the values method for the different classes */
  @Test
  public void testValue(){
    State myState = new State();
    myState.update("x",3);
    Variable x = new Variable("x");
    assertEquals(new Integer(3), x.value(myState));
    Number n = new Number(10);
    myState.update("10",10);
    assertEquals(new Integer(10), n.value(myState));
    
    /*Tests value method in AritmeticOperation
     * tests Add,Sub,Mult,Div,Rem */
    ArithmeticOperation aotest1 = new ArithmeticOperation(ArithmeticOperation.Operator.Add,n,x);
    assertEquals(new Integer(13),aotest1.value(myState));
    ArithmeticOperation aotest2 = new ArithmeticOperation(ArithmeticOperation.Operator.Sub,n,x);
    assertEquals(new Integer(7),aotest2.value(myState));
    ArithmeticOperation aotest3 = new ArithmeticOperation(ArithmeticOperation.Operator.Mult,n,x);
    assertEquals(new Integer(30),aotest3.value(myState));
    ArithmeticOperation aotest4 = new ArithmeticOperation(ArithmeticOperation.Operator.Div,n,x);
    assertEquals(new Integer(3),aotest4.value(myState));
    ArithmeticOperation aotest5 = new ArithmeticOperation(ArithmeticOperation.Operator.Rem,n,x);
    assertEquals(new Integer(1),aotest5.value(myState));
    
    /* Tests the value method in Comparison */
    Comparison cotest1 = new Comparison(Comparison.Operator.LT,n,x);
    assertFalse(cotest1.value(myState));
    Comparison cotest2 = new Comparison(Comparison.Operator.LTE,n,x);
    assertFalse(cotest2.value(myState));
    Comparison cotest3 = new Comparison(Comparison.Operator.GT,n,x);
    assertTrue(cotest3.value(myState));
    Comparison cotest4 = new Comparison(Comparison.Operator.GTE,n,x);
    assertTrue(cotest4.value(myState));
    Comparison cotest5 = new Comparison(Comparison.Operator.EQ,n,x);
    assertFalse(cotest5.value(myState));
    Comparison cotest6 = new Comparison(Comparison.Operator.NEQ,n,x);
    assertTrue(cotest6.value(myState));
    
    /* Tests the value method in BooleanOperation */
    BooleanOperation botest1 = new BooleanOperation(BooleanOperation.Operator.AND,cotest3,cotest4);
    assertTrue(botest1.value(myState));
    BooleanOperation botest2 = new BooleanOperation(BooleanOperation.Operator.AND,cotest1,cotest4);
    assertFalse(botest2.value(myState));
    BooleanOperation botest3 = new BooleanOperation(BooleanOperation.Operator.OR,cotest1,cotest2);
    assertFalse(botest3.value(myState));
    BooleanOperation botest4 = new BooleanOperation(BooleanOperation.Operator.OR,cotest3,cotest1);
    assertTrue(botest4.value(myState));
  }
  
  
  /**tests the get name method in Variable */
  @Test
  public void testGetName(){
    Variable x = new Variable("x");
    assertEquals("x", x.getName());
  }
  
  @Test
  public void testToString(){
    Variable x = new Variable("x");
    assertEquals("x", x.toString());
    Number n = new Number(2);
    assertEquals("2", n.toString());
    State s = new State();
    s.update("x",5);
    s.update("2",2);
    
    ArithmeticOperation aotest1 = new ArithmeticOperation(ArithmeticOperation.Operator.Add,n,x);
    assertEquals("2 add x",aotest1.toString());
    ArithmeticOperation aotest2 = new ArithmeticOperation(ArithmeticOperation.Operator.Sub,n,x);
    assertEquals("2 sub x",aotest2.toString());
    ArithmeticOperation aotest3 = new ArithmeticOperation(ArithmeticOperation.Operator.Mult,n,x);
    assertEquals("2 mult x",aotest3.toString());
    ArithmeticOperation aotest4 = new ArithmeticOperation(ArithmeticOperation.Operator.Div,n,x);
    assertEquals("2 div x",aotest4.toString());
    ArithmeticOperation aotest5 = new ArithmeticOperation(ArithmeticOperation.Operator.Rem,n,x);
    assertEquals("2 rem x",aotest5.toString());
    
    /* Tests for the toString method in Comparison
     * all possible comparison operators are tested with a number and variable */
    Comparison cotest1 = new Comparison(Comparison.Operator.LT,n,x);
    assertEquals("2 less than x", cotest1.toString());
    Comparison cotest2 = new Comparison(Comparison.Operator.LTE,n,x);
    assertEquals("2 less than or equal to x", cotest2.toString());
    Comparison cotest3 = new Comparison(Comparison.Operator.GT,n,x);
    assertEquals("2 greater than x", cotest3.toString());
    Comparison cotest4 = new Comparison(Comparison.Operator.GTE,n,x);
    assertEquals("2 greater than or equal to x", cotest4.toString());
    Comparison cotest5 = new Comparison(Comparison.Operator.EQ,n,x);
    assertEquals("2 equal to x", cotest5.toString());
    Comparison cotest6 = new Comparison(Comparison.Operator.NEQ,n,x);
    assertEquals("2 not equal to x", cotest6.toString());
    
    /* Tests toString method in the BooleanOperation class  */
    BooleanOperation botest1 = new BooleanOperation(BooleanOperation.Operator.AND,cotest1,cotest2);
    assertEquals("2 less than x AND 2 less than or equal to x", botest1.toString());
    BooleanOperation botest2 = new BooleanOperation(BooleanOperation.Operator.OR,cotest1,cotest2);
    assertEquals("2 less than x OR 2 less than or equal to x", botest2.toString());
  }
  @Test
  public void testExecute(){
    State s = new State();
    Assignment x = new Assignment(new Variable("x"), new Number(19));
    Assignment y = new Assignment(new Variable("y"), new Number(16));
    Assignment z = new Assignment(new Variable("z"), new Number(14));
    x.execute(s);
    assertEquals("19", "" + s.lookup("x"));
    x = new Assignment(new Variable("x"), new Number(18));
    CompoundStatement a = new CompoundStatement(x);
    a.execute(s);
    assertEquals("18", "" + s.lookup("x"));
    x = new Assignment(new Variable("x"), new Number(17));
    CompoundStatement b = new CompoundStatement(x, y);
    b.execute(s);
    assertEquals("17", "" + s.lookup("x"));
    assertEquals("16", "" + s.lookup("y"));
    x = new Assignment(new Variable("x"), new Number(16));
    y = new Assignment(new Variable("y"), new Number(15));
    CompoundStatement c = new CompoundStatement(x, y, z);
    c.execute(s);
    assertEquals("16", "" + s.lookup("x"));
    assertEquals("15", "" + s.lookup("y"));
    assertEquals("14", "" + s.lookup("z"));
    x = new Assignment(new Variable("x"), new Number(10));
    y = new Assignment(new Variable("y"), new Number(20));
    Comparison nottrue = new Comparison(Comparison.Operator.LT, new Number(2), new Number(1));
    Comparison notfalse = new Comparison(Comparison.Operator.LT, new Number(3), new Number(4));
    ConditionalStatement m =  new ConditionalStatement(nottrue, x, y);
    m.execute(s);
    assertEquals("16", "" + s.lookup("x"));
    assertEquals("20", "" + s.lookup("y"));
    m =  new ConditionalStatement(notfalse, x, y);
    m.execute(s);
    assertEquals("10", "" + s.lookup("x"));
    Assignment u = new Assignment(new Variable("u"), new Number(1));
    u.execute(s);
    ArithmeticOperation n = new ArithmeticOperation(ArithmeticOperation.Operator.Add, new Number(u.value(s)), new Number(1));
    Assignment t = new Assignment(new Variable("u"), new Number(n.value(s) + 1));
    CompoundStatement comp = new CompoundStatement(t);
    notfalse = new Comparison(Comparison.Operator.LT, new Number(u.value(s)), new Number(4));
    Loop loop = new Loop(notfalse, comp);
    loop.execute(s);
    assertEquals("10", "" + s.lookup("x"));
  }
  @Test
  public void testToStringTabbed(){
    Variable x = new Variable("x");
    assertEquals("x", x.getName());
  }
}