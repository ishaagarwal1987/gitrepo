
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author w-10
 */
public class UglyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        try{
        System.out.println("Enter a number : ");
        int num = Integer.parseInt(in.readLine());
        
        if(num%2==0 || num%3==0 || num%5==0 || num==1)
            System.out.println(num + " is not an ugly number.");
        else
            System.out.println(num + " is an ugly number.");
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println("Error found: "+e);
        }
    }
    
}
