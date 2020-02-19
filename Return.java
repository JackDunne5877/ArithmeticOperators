public class Return extends Variable implements Executable{
  private Variable expression;
  
  /**constructor for the return class  */
  public Return(Variable expression){
    super("Return");
    this.expression = expression;
   
  }
  
  /** empty return constructor */
  public Return()  {
  }
  
  /**updates return in the state to be expression */
  public void execute(State s){
    s.update("Return", expression.value(s));
  }
  
  /**returns expression as a string */
  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append(super.toString() + " " + expression.toString() + "\n");
    return str.toString();
  }
  
  /**returns expression prefixed by input number of tabs */
  public String toStringTabbed(int input){
    StringBuilder sb1 = new StringBuilder();
    for(int i = 0; i < input; i++){
      sb1.append("  ");
    }
    sb1.append(toString());
    return sb1.toString();
  }
}