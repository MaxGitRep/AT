package JavaLearn;

public class JavaList {
    private JavaHomo[] list = new JavaHomo[5];
    private int i = 0;

    public void add(JavaHomo per){
        if (i < list.length){
            list[i] = per;
            System.out.println("Added person in order " + i);
            i++;
        }
    }

}
