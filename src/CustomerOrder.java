import java.util.*;
import java.time.OffsetTime;
public class CustomerOrder  extends FirstComeFirstServe
{
    public int qty1=0,qty2=0,qty3=0;
    float b=8,f=6,c=2,tst=0,qty=0; /*b-:time to make burger  c-:time to make coke f-:time to make fries tst-:Total service time*/
    int opt,con;
    int loopstat=0;
    Scanner sc=new Scanner(System.in);
    int bc=3,fc=4,cc=5;/*bc-:no of burgers at a time fc-:no of fries at a time cc-:no of cokes at a time*/
    float stockb=0,stockf=0,stockc=0;
    OffsetTime offset;
    void initialize(int a,int b ,int c)
    {
        bc=1;fc=b;cc=c;
    }
    float testb(int qty)
    {
        System.out.println(+stockb);
        if(stockb>=qty)
        {
            stockb-=qty;
            return 0;
        }
        else if(stockb<qty)
        {
            float x=qty-stockb;  
            float a=(float) (Math.ceil((x/bc))*b);/*time*/
            stockb=(float) ((Math.ceil((x/bc))*bc)-x);
            return  a;
        }
        return 0;
    }
    void customerorder()
    {   
        while(loopstat==0)
       {
        System.out.println("ENTER THE ITEM TO BE PURCHASED");
        System.out.println("1:BURGER 2:fries 3:coke 4:CONFIRM ORDER 5:REPORTS 6:EXIT");
        opt=sc.nextInt();
        switch(opt)
        { 
            case 1:System.out.println("Enter the quantity OF BURGERS");
                   qty1=sc.nextInt();
                   tst+=testb((int) qty);
                   break;
            case 2:System.out.println("Enter the quantity FRIES");
                   qty=sc.nextInt();
                   tst+=f*qty;
                   break;
            case 3:System.out.println("Enter the quantity COKE");
                   qty=sc.nextInt();
                   tst+=c*qty;
                   break;
            case 4:System.out.println("CONFIRMING ORDER (1 or 0)");
                   con=sc.nextInt();
                   if(con==0){tst=0;break;}
                   else
                   { 
                       if(nci==0)
                       {  
                           offset = OffsetTime.now();
                           basem=offset.getMinute();
                           bases=offset.getSecond();
                           System.out.println("order minute and second "+(basem+(bases/60)));
                           System.out.println("service time"+tst);
                           aat[aati]=(basem+(bases/60));
                           at[ati]=0;
                           wt[wti]=0;
                           st[sti]=tst/60;
                           ati++;
                           wti++;
                           sti++;
                           aati++;
                           tst=0;
                       }
                       if(nci>=1)
                       {
                           offset = OffsetTime.now();  
                           float currm=offset.getMinute();
                           float currs=offset.getSecond();
                           at[ati]=(currm-basem)+((currs-bases)/60);
                           wt[wti]=st[sti-1]+wt[wti-1]-at[ati]+at[ati-1];
                           if(wt[wti]<=0){wt[wti]=0;}
                           st[sti]=tst/60;
                           aat[aati]=(currm+(currs/60));
                           System.out.println(""+wt[wti]);/*change*/
                           System.out.println(""+tst);
                           ati++;
                           wti++;
                           sti++;
                           tst=0;
                           aati++;  
                       }
                       nci++;
                       break;
                   }
                 case 5: System.out.println("REPORTS");
                         {
                            float mu,lam;
                            mu= (nci/(aat[0]-aat[aati]));
                            mu=mu*60;
                            lam=(nci/((aat[0]-aat[aati])+wt[wti]));
                            lam=lam*60;
                            System.out.println("lambda-:"+lam);        
                            System.out.println("mu-:"+mu);
                         } 
                 case 6: loopstat=1;              
        }
       } 
       loopstat=0;  
    }
}
