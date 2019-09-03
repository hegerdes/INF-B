package Test;

public class Lindwurm extends Drache{
    public final String name;

    public Lindwurm(String name){
        super(name);
        this.name=name;
    }

    @Override
    public void sprechen() {
        System.out.println(getName());
    }
}
