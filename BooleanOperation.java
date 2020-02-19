// dont really understand what this class is asking for doesnt work
public class BooleanOperation extends Comparison{
  // an enum class that represents all possible boolean operations
  public enum Operator {
    AND, OR;
  }
  private Comparison obj1;
  // a variable that stores the second variable value
  private Comparison obj2;
  // a variable that stores the operator
  private Operator op;
  
  public BooleanOperation(Operator op, Comparison obj1, Comparison obj2){
    this.obj1 = obj1;
    this.obj2 = obj2;
    this.op = op;
  }
  
  public BooleanOperation(){
  }
  
  public Boolean value(State s){
    Boolean result = false;
    if(this.op == Operator.AND){
      result = obj1.value(s) && obj2.value(s);
    }
    if(this.op == Operator.OR){
      result = obj1.value(s) || obj2.value(s);
    }
    return result;
  }
  public String coToString(){
    StringBuilder sb = new StringBuilder();
    if (this.op == Operator.AND){
      sb.append("AND");
    }
    if (this.op == Operator.OR){
      sb.append("OR");
    }
    return sb.toString();
  }
    
  public String toString(){
    StringBuilder sb1 = new StringBuilder();
    sb1.append(obj1.toString() + " ");
    sb1.append(this.coToString() + " ");
    sb1.append(obj2.toString());
    return sb1.toString();
  }
}