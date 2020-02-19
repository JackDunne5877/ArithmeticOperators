public class Loop implements Executable{
  /** Comparison instance that holds the condition for the loop */
  private Comparison condition;
  
  /** Executable instance that holds the value for the loop body */
  private Executable loop;
  
  /**constructor for a loop instance */
  public Loop(Comparison condition, Executable loop){
    this.condition = condition;
    this.loop = loop;
  }
  
  /** method for executing the loop */
  public void execute(State s){
    Boolean active = condition.value(s);
    while(active == true){
      loop.execute(s);
      active = condition.value(s);
    }
  }
  
  /** returns a string of a while loop and our conditional statement */
  public String toString(){
    StringBuilder sb1 = new StringBuilder();
    sb1.append("while (" + condition.toString() + ") \n" + loop.toStringTabbed(1));
    return sb1.toString();
  }
  
  /** returns string of while loop and conditional statement, prefaced by input number of tabs */
  public String toStringTabbed(int input){
    StringBuilder sb1 = new StringBuilder();
    for(int i = 0; i < input; i++){
      sb1.append("  ");
    }
    sb1.append(toString());
    return sb1.toString();
  }  
}