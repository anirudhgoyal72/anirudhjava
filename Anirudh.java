import java.lang.Math;
import java.util/*;
public class anirudh{
  public static void main(String [] args)
  {
    int x=new int[5];
    x[0]=8;x[1]=9;x[2]=10;x[3]=15;x[4]=16;
    double y=new double[5];
    for(int i=0;i<5;i++)
    {
      y[i]=Math.sqrt(x[i]);
    }
    Vector<Integer> v1 = new Vector<Integer>();
    Vector<Float> v2 = new Vector<Float>();
    for(int i=0;i<5;i++)
    {
      double t=y[i];
      if(t-Math.floor(t)==0)
      {
        v1.add(int(t));
      }
      else{
         v2.add(t);
      
    }
    Collections.sort(v1);
    Collections.sort(v2);
    for(int i=0;i<v1.length();i++)
    {
      System.out.println(v1[i]+",")
      
    }
    for(int i=0;i<v2.length();i++)
    {
      System.out.println(v2[i]+",")
      
    }
      
  }
}
