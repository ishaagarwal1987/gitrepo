
public class PentagonalNumbers {

    public static void main(String[] args) {
       
        int old_number = 1;
        int new_number = 5;
        int difference;
        int count = 2;
        System.out.print(old_number + "\t" +new_number);
        
        for(int i=3;i<=50;i++)
        {
            difference = new_number - old_number;
            old_number = new_number;
            new_number = difference + 3 +old_number;
            System.out.print("\t" + new_number );
            count++;
            if(count==10)
            {
                System.out.print("\n" );
                count=0;
            }
        }
        
    }
    
}
