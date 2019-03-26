package www.bite.java;


enum S{
    MALE,FEMALE
}

public class Test {
    public static void main(String[] args) {
        switch (S.FEMALE){
            case MALE:
                System.out.println("MAN");
                break;
            case FEMALE:
                System.out.println("WOMEN");
                break;
        }
    }
}
