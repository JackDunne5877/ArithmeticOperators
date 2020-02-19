public class Assignment extends Number implements Executable{
  private Variable variable;
  private Variable expression;
  
  public Assignment(Variable variable, Variable expression){
    this.variable = variable;
    this.expression = expression;
  }
  
  /**empty assignment constructor */
  public Assignment() {
  }
  
  public void execute(State s){
    s.update(variable.getName(), expression.value(s));
  }
  
  public Integer value(State s){
    s.update(variable.getName(), expression.value(s));
    return s.lookup(variable.getName());
  }
  
  public String toString(){
    StringBuilder sb1 = new StringBuilder();
    sb1.append(variable.getName() + " := ");
    sb1.append(expression.toString() + "\n");
    return sb1.toString();
  }
  
  public String toStringTabbed(int input){
    StringBuilder sb1 = new StringBuilder();
    for(int i = 0; i < input; i++){
      sb1.append("  ");
    }
    sb1.append(toString());
    return sb1.toString();
  }
}
    
  
  
    
    