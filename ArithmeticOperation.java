public class ArithmeticOperation extends Number{
  //a set of enum classes that represent all arithmetic operations
  public enum Operator {
    Add, Sub, Mult, Div, Rem;
  }
  
  /**a variable that holds the first number or variable */
  private Variable first;
  
  /**a variable that holds the second number or variable */
  private Variable second;
  
  /**variable that holds the chooses operator */
  private Operator myOperator;
  /**constructor requiring an operator and two numbers or variables */
  public ArithmeticOperation(Operator myOperator ,Variable first ,Variable  second){
    this.myOperator = myOperator;
    this.first = first;
    this.second = second;
  }
  
  /** empty constructor */
  public ArithmeticOperation() {
  }
  
  /**method that returns the value of a given arithmatic operation */
  public Integer value(State s){
    Integer result = 0;
    if (this.myOperator == Operator.Add){
      result = first.value(s) + second.value(s);
    }
    if (this.myOperator == Operator.Sub){
      result = first.value(s) - second.value(s);
    }
    if (this.myOperator == Operator.Mult){
      result = first.value(s) * second.value(s);
    }
    if (this.myOperator == Operator.Div){
      result = first.value(s) / second.value(s);
    }
    if (this.myOperator == Operator.Rem){
      result = first.value(s) % second.value(s);
    }
    return result;
  } 
  /**method that converts the operator values into strings */
  public String aoToString(){
    StringBuilder str = new StringBuilder();
    if (this.myOperator == Operator.Add){
      str.append("add");
    }
    if (this.myOperator == Operator.Sub){
      str.append("sub");
    }
    if (this.myOperator == Operator.Mult){
      str.append("mult");
    }
    if (this.myOperator== Operator.Div){
      str.append("div");
    }
    if (this.myOperator == Operator.Rem){
      str.append("rem");
    }
    return str.toString();
  }
  /**method that returns an arithmatic operation in a string representation  */
  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append(first.toString() + " ");
    str.append(this.aoToString() + " ");
    str.append(second.toString());
    return str.toString();
  }
}