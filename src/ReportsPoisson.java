import java.util.*;
import java.time.OffsetTime;
public class ReportsPoisson extends CustomerOrder
{
    public static void main(String[] args) 
    {
       int a;
       ReportsPoisson c=new ReportsPoisson();
       System.out.println("Hi welcome to resturant queue management system");
       Scanner sc=new Scanner(System.in);
       
       while ( true)
       {
           System.out.println("1.CUSTOMER ORDER ");
           System.out.println("2.EXIT ");
           a=sc.nextInt();
          switch(a)
          {
              case 1: c.customerorder();break;
              case 2:System.exit(0);
          }
       
       }
    }
}
 