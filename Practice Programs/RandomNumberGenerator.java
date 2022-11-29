
public class RandomNumberGenerator {

    public static void main(String[] args) {
        
        int min = 10;
        int max = 100;
        
        int randNum = (int) (Math.random() * (max - min + 1) + min) ;
        
        System.out.println("Random Number = "+randNum);
        
    }
    
}
