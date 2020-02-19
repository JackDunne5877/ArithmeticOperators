public class ConditionalStatement implements Executable{
  
  
  private Comparison condition;
  private Executable thenStatement;
  private Executable elseStatement;
  
  public ConditionalStatement(Comparison condition, Executable thenStatement, Executable elseStatement){
    this.condition = condition;
    this.thenStatement = thenStatement;
    this.elseStatement = elseStatement;
  }
  
  public void execute(State s){
    if(condition.value(s) == true){
      thenStatement.execute(s);
    }
    else{
      elseStatement.execute(s);
    }
  }
  
  public String toString(){
    StringBuilder sb1 = new StringBuilder();
    sb1.append("if (" + condition.toString() + ")\n" + thenStatement.toStringTabbed(1) + "else\n"
                 + elseStatement.toStringTabbed(1));
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