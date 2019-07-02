package Test;

public class Drache {

    public final String name;

    public Drache(String name){
        this.name=name;
    }

    public void sprechen(){
        System.out.println(this.name);
    }

    public String getName(){
        return this.name;
    }
}
