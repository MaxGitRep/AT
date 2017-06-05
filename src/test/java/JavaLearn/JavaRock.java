package JavaLearn;

public class JavaRock {

    private int day;
    private int month;
    private int year;

    public JavaRock(int d, int m, int y){
        day = d;
        month = m;
        year = y;
        System.out.printf("Birthday Rick - %s\n", this);
    }

    public String toString(){
        return String.format("%d/%d/%d", day, month, year);
    }

    public enum Rock{
        Any("chinese","sexy"),
        Fry("fool","lazy"),
        Rick("drunker","genius"),
        Spider("fat", "black"),
        Batman("steel", "evil"),
        Superman("red", "cool");

        private final String desc1;
        private final String desc2;

        Rock(String d1, String d2){
            desc1 = d1;
            desc2 = d2;
        }
        public String getDesc1(){
            return desc1;
        }
        public String getDesc2(){
            return desc2;
        }
    }

    private String fname;
    private String lname;
    private static int count = 0;

    public JavaRock(String fn, String ln){
        fname = fn;
        lname = ln;
        count++;
        System.out.printf("%s %s: in film - %d characters. \n", fname, lname, count);
    }
    public JavaRock(){
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public static int getCount(){
        return count;
    }

    public void mult(){
        System.out.println("Im method Mult");
    }

/*    private int sum;
    private final int numb;

    public JavaRock(int n){
        numb = n;
    }

    public void add(){
        sum += numb;
    }

    public String toString(){
        return String.format("Sum of values = %s\n", sum);
    }*/

}
