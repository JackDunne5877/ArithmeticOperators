public class Comparison{
  // an enum class that represents all possible comparison operations
  public enum Operator {
    LT, LTE, GT, GTE, EQ, NEQ;
  }
  // a variable that stores the first variable value
  private Variable obj1;
  // a variable that stores the second variable value
  private Variable obj2;
  // a variable that stores the operator
  private Operator op;
  // a constructor that creats a comparison with an operator and two variables or numbers
  public Comparison(Operator op, Variable obj1 , Variable obj2){
    this.op = op;
    this.obj1 = obj1;
    this.obj2 = obj2; 
  }
  public Comparison(){
  }
  // a method that returns wether a given comparison is true or false
  //doesnt work return type isnt right, cant make it return boolean
  public Boolean value(State s){
    Boolean result = false;
    if (this.op == Operator.LT){
      result = obj1.value(s) < obj2.value(s);
    }
    if (this.op == Operator.LTE){
      result = obj1.value(s) <= obj2.value(s);
    }
    if (this.op == Operator.GT){
      result = obj1.value(s) > obj2.value(s);
    }
    if (this.op == Operator.GTE){
      result = obj1.value(s) >= obj2.value(s);
    }
    if (this.op == Operator.EQ){
      result = obj1.value(s) == obj2.value(s);
    }
    if (this.op == Operator.NEQ){
      result = obj1.value(s) != obj2.value(s);
    }
    return result;
  } 
  //a method that converts comparison operators into strings
  public String coToString(){
    StringBuilder sb = new StringBuilder();
    if (this.op == Operator.LT){
      sb.append("less than");
    }
    if (this.op == Operator.LTE){
      sb.append("less than or equal to");
    }
    if (this.op == Operator.GT){
      sb.append("greater than");
    }
    if (this.op == Operator.GTE){
      sb.append("greater than or equal to");
    }
    if (this.op == Operator.EQ){
      sb.append("equal to");
    }
    if (this.op == Operator.NEQ){
      sb.append("not equal to");
    }
    return sb.toString();
  }
  //a method that returns a given Comparison in a String representation
  public String toString(){
    StringBuilder sb1 = new StringBuilder();
    sb1.append(obj1.toString() + " ");
    sb1.append(this.coToString() + " ");
    sb1.append(obj2.toString());
    return sb1.toString();
  }
}
