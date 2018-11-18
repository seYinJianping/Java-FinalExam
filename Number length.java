import java.util.Scanner;

public class numberlenth {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("input a number:");
        int number=input.nextInt();
        String s=Integer.toString(number);
        int length=s.length();
        System.out.print(length);
    }
}
