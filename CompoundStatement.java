public class CompoundStatement implements Executable{
  Executable args[];
  int length;
  public CompoundStatement(Executable... args){
    this.length = args.length;
  }
  
  public void execute(State s){
    for(int i = 0; i < length() - 1; i++){
      args[i].execute(s);
      i++;
    }
  }
  
  public int length(){
    return this.length;
  }
  
  public String toString(){
    return "";
  }
  
  public String toStringTabbed(int input){
    return "";
  }
}