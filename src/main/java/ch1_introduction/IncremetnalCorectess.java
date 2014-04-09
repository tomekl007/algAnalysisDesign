package ch1_introduction;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class IncremetnalCorectess {
    public static int increment(int y){
        if( y == 0) return 1;
        else if(y % 2 == 1) return 2 * increment(y/2);
        /*
        //given y = odd number => 2m + 1
        2 * increment([2m + 1 / 2]) = 2 * increment ([ m + 1 / 2])   // every (m + 1 / 2 ) % 2 == 0 (is even nr)
                                    = 2 * increment (m) // m is now even nr
                                    = 2 * ( m + 1 ) //last else
                                    = 2m + 2 = y + 1
        //example :
        y = 5, then m = 2
        2 * inc([ 2 * 2 + 1 / 2]) = 2 * inc ( 5 / 2)
                                  = 2 * inc (2)
                                  = 2 * ( 2 + 1)
                                  = 2 + 3 = y + 1  => 6
         */
        else return (y + 1);       //if(y % 2 == 0)
    }

    public static void main(String[] args) {
        System.out.println(increment(5));
    }
}
