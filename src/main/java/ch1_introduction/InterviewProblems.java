package ch1_introduction;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class InterviewProblems {
    //public static int divisionWithoudOperands(int x, int y){
    //
    //    return x >>  Integer.toBinaryString(y).length()-1 ;

    //}

    // Note: This only works for positive values!
    static int divide(int numerator, int denominator) {
        int quotient = 0;

        while(numerator >= denominator) {
            numerator -= denominator;
            quotient++;
        }

        return quotient;
    }
}
