import java.util.Scanner;
class ebill{
    public static void main(String args[]){
        Scanner g=new Scanner(System.in);
        System.out.print("Enter your name:");
        String name=g.nextLine();
        System.out.print("Enter your id:");
        int id=g.nextInt();
        System.out.print("1.Domestic,\n2.Comercial:\nEnter your choice:");
        int choice=g.nextInt();
        System.out.print("Enter your previous month reading:");
        int prev_read=g.nextInt();
        System.out.print("Enter your current month reading:");
        int curr_read=g.nextInt();
        int unit;
        unit=curr_read-prev_read;
        double n;
        if(choice==1){
          if(unit<=100){
            n=unit*1;
            System.out.println("your amount:"+n);
          }
          else if(unit>=101 && unit<=200){
            n=unit*2.50;
            System.out.println("your amount:"+n);
          }
          else if(unit>=201 && unit<=500){
            n=unit*4;
            System.out.println("your amount:"+n);
          }
          else{
            n=unit*6;
            System.out.println("your amount:"+n);
          }
        }
        else if(choice==2){
           if(unit<=100){
            n=unit*2;
            System.out.println("your amount:"+n);
          }
          else if(unit>=101 && unit<=200){
            n=unit*4.50;
            System.out.println("your amount:"+n);
          }
          else if(unit>=201 && unit<=500){
            n=unit*6;
            System.out.println("your amount:"+n);
          }
          else{
            n=unit*7;
            System.out.println("your amount:"+n);
          }
        }
        else{
             System.out.println("INVALID OPERATION");
      }
   }
 }
            
