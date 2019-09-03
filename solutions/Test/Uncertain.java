package Test;

public class Uncertain {

    private int i = 1;

    public int un1(){
        try{
            System.out.println("un 1 try " +i);
            return i++;
        }catch (RuntimeException e){
            i++;
        }finally {
            System.out.println("un 1 finaly vor " +i);
            i++;
            System.out.println("un 1 finaly nach " +i);
        }
        return i++;
    }

    public int un2(){
        try{
            System.out.println("un 2 try " + i);
            throw new IllegalArgumentException();
        }catch (RuntimeException e){
            System.out.println("Werde ich");
            i++;
            throw e;
        }finally {
            System.out.println("un 2 finaly " +i);
            return i++;
        }
    }

    public static void main(String[] args) {
        for(int l = 1;l<3;l++){
            int res = 0;
            Uncertain un = new Uncertain();
            try {
                switch (l){
                    case 1: res = un.un1();break;
                    case 2: res = un.un2();break;
                }
            }catch (Exception e){
                System.out.print("Ex!");
            }finally {
                System.out.println("res = " + res + " i = " + un.i);
            }
        }
    }
}
