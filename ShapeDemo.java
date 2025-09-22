import java.util.Scanner;
abstract class Shape{
    int dim1,dim2;
    Shape(int d1,int d2){
         dim1=d1;
         dim2=d2;
    }
    abstract void printArea();
}
class Rectangle extends Shape{
      Rectangle(int length ,int breadth){
          super(length,breadth);
      }
      void printArea(){
           int area=dim1*dim2;
           System.out.println("Area of Rectangle="+area);
      }       
}
class Triangle extends Shape{
      Triangle(int base ,int height){
          super(base,height);
      }
      void printArea(){
           double area=0.5*dim1*dim2;
           System.out.println("Area of Triangle ="+area);
      }       
}   
class Circle extends Shape{
      Circle(int radius){
           super(radius,0);
      }
      void printArea(){
          double area =3.14159*dim1*dim1;
          System.out.println("Area of circle ="+area);
      }
}
public class ShapeDemo{
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         //int choice;
        /* do {
              System.out.println("\n Area calculation "); 
              System.out.println("1. Rectangle");
              System.out.println("2.Triangle ");
              System.out.println("3.Circle");
              System.out.println("4.Exit");  
              System.out.println("ENTER YOUR CHOICE:");
              choice=sc.nextInt();
              switch(choice){
                 case 1: */                                                                
                    System.out.println("Enter length of Rectangle:");
                    int l=sc.nextInt();
                    System.out.println("Enter breadth of Rectangle:");
                    int b=sc.nextInt();
                    Rectangle r=new Rectangle(l,b);
                    r.printArea();
                   // break;
                // case 2:
                    System.out.println("Enter base of triangle:");
                    int base=sc.nextInt();
                    System.out.println("enter height of triangle:");
                    int h=sc.nextInt();
                    Triangle t=new Triangle(base,h);
                    t.printArea();
                   // break;
                 //case 3: 
                    System.out.println("Enter radius of circle:");
                    int rad=sc.nextInt();
                    Circle c=new Circle(rad);
                    c.printArea();
                    //break;
                 //case 4:
                    System.out.println("exiting.....");
                    //break;
                 /*default:
                    System.out.println("invalid choice!");
                 }
             } while (choice!=4);*/
               sc.close();
           }
        }   
                      
                    
