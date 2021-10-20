import java.io.*;
import java.lang.*;
import java.util.*;
class User{
    int id;
    String name;
    int salary;
    public User(int id,String name,int salary)
    {
      this.id=id;
      this.name=name;
      this.salary=salary;
      
    }
    public String toString()
    {
     return this.id+" "+this.name+" "+this.salary; 
    }
    class Sortbysalary implements Comparator<User> {
    
    public int compare(User a, User b)
    {
        return a.salary - b.salary;
    }
}
  
  
  
  
  
  
}





class Anirudh1{
  public static void main(String[] args)
  {
   ArrayList<User> ar = new ArrayList<User>();
        ar.add(new User(1, "bbbb", 1000));
        ar.add(new User(2, "aaaa", 400));
        ar.add(new User(3, "cccc", 600));
  Collections.sort(ar, new Sortbysalary());
  
       
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    
    
  }
}
