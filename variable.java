public class Variable{
  /** variable that holds the name of the Variable */
  private String stringName;
  
  /** constructor that creates a variable with a name */
  public Variable(String stringName){
    this.stringName = stringName;
  }

  /**empty constructor for variable */
  public Variable() {
  }
  
  //returns the Integer value corresponding to the variable name in the Hastable in State
  public Integer value(State s){
    return s.lookup(this.stringName);
  }
  //returns the name of the variable
  public String getName(){
    return this.stringName;
  }
  //returns the variable as a string
  public String toString(){
    return this.stringName;
  }
}