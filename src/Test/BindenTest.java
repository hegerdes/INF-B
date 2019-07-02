package Test;

public class BindenTest {

    public static void main(String[] args) {
        Drache d = new Drache("Fuchur");
        Drache l = new Lindwurm("Fafnir");

        d.sprechen();
        l.sprechen();
        System.out.println(l.name);
        System.out.println(((Lindwurm) d).name);
    }
}
