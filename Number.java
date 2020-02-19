  public class Number extends Variable{
    /**a variable that holds a numbers Integer Value  */
    private Integer value;
    
    /** a variable that holds a numbers name */
    private String name;
    
    /** a constructor that gives a number and an integer value */
    public Number(Integer value){
      this.value = value;
      this.name = value + "";
    }
    
    /** empty number constructor */
    public Number() {
    }
    
    /** a method that returns the corresponding integer value to the hashtable in state */
    public Integer value(State s){
      s.update(this.name, this.value);
      return s.lookup(this.name);
    }
    
    /**a method that returns a number's integer as a string  */
    public String toString(){
      return this.name;
    }
  }