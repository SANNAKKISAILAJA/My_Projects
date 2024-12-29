import java.util.*;
class Calculator{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("\t****Instructions****\n 1:Multiplication\n 2:division\n 3:Addition\n 4:subtraction\n 5:power\n 'X' or 'x': exit");
        do{  
            String ch= sc.next();
            if(ch.equalsIgnoreCase("X") ){
                return;
            }
            int choice = Integer.parseInt(ch);
            switch(choice){
                case 1:{
                    System.out.println("enter two integers:");
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    System.out.println(a+"*"+b+"="+a*b);
                    break;
                }
                case 2:{
                    System.out.println("enter two integers:");
                    float a=sc.nextInt();
                    float b=sc.nextInt();
                    System.out.println(a+"/"+b+"="+a/b);
                    break;
                }
                case 3:{
                    System.out.println("enter two integers:");
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    int sum=a+b;
                    System.out.println(a+"+"+b+"="+sum);
                    break;
                }
                case 4:{
                    System.out.println("enter two integers:");
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    int sub=a-b;
                    System.out.println(a+"-"+b+"="+sub);
                    break;
                }
                case 5:{
                    System.out.println("enter an integers:");
                    int a=sc.nextInt();
                    System.out.println(a+"^2 ="+a*a);
                    break;
                }
                default:
            }
            System.out.println("enter your choice:");
            
        }while(true);
    }
}
