import java.util.Hashtable;
public class State{
  Hashtable <String, Integer> table = new Hashtable<String, Integer>();
  // A method that updates a variables name and value
  public void update(String myString,Integer i){
    table.put(myString,i);
  }
   // a method that returns an integer given a variable name
  public Integer lookup(String myString){
    Integer n = table.get(myString);
    if (table.get(myString) == null){
      return 0;
    }
    else
      return n;
  }
}