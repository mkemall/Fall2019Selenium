package warmup;

public class Test {
   int test_a , test_b;

    Test(int a, int b) {
        test_a=a;
        test_b=b;

    }
    public static void main (String args []){
        Test test = new Test(10,20);
        System.out.println(test.test_a + " " + test.test_b);
    }
}
class Main{

    public static void main (String args[]){

        final int i ;
        i=20;
        System.out.println(i);
    }

}


