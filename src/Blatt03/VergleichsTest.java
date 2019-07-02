package Blatt03;
public class VergleichsTest {

	public static void main(String[] args) {
		
		Person p1= new Person("Hans");
		Person p2= new Person("Hans");
		Person p3= new Person ("Peter");
		
		Student s1= new Student("Hans",123);
		Student s2= new Student("Hans", 123);
		Student s3= new Student("Peter", 1651615616);
		
		// reflexive
		System.out.println("Testing reflexive");
		System.out.println("P1  = P1 " + p1.equals(p1) + " Hash = " + p1.hashCode());
		System.out.println("P2  = P2 " + p2.equals(p2) + " Hash = " + p2.hashCode());
		System.out.println("P3  = P3 " + p3.equals(p3) + " Hash = " + p3.hashCode());
		System.out.println();
		
		// symmetric
		System.out.println("Testing symmetric");
		System.out.println("P1  = P2 " + p1.equals(p2) + " Hash = " + p1.hashCode());
		System.out.println("P2  = P1 " + p2.equals(p1) + " Hash = " + p2.hashCode());
		System.out.println("P1 != P3 " + !p1.equals(p3) + " Hash = " + p1.hashCode());
		System.out.println("P3 != P1 " + !p3.equals(p1) + " Hash = " + p3.hashCode());
		System.out.println("P2 != P3 " + !p2.equals(p3) + " Hash = " + p2.hashCode());
		System.out.println("P3 != P2 " + !p3.equals(p2) + " Hash = " + p3.hashCode());
		System.out.println();
		
		//transitive
		System.out.println("Tsting transitive");
		System.out.println("P1  = P2 " + p1.equals(p2));
		System.out.println("P1 != P3 " + !p1.equals(p3));
		System.out.println("P2 != P2 " + !p2.equals(p3));
		System.out.println();
		
		//consistent
		System.out.println("Testing consistet");
		System.out.println("P1  = P1 " + (p1.equals(p1)&&p1.equals(p1)) );
		System.out.println("P2  = P2 " + (p2.equals(p2)&&p2.equals(p2)) );
		System.out.println("P3  = P3 " + (p3.equals(p3)&&p3.equals(p3)) );
		System.out.println();
		
		//Null
		System.out.println("Testing Null");
		System.out.println("P1  = 0 " + p1.equals(null));
		System.out.println("P2  = 0 " + p2.equals(null));
		System.out.println("P3  = 0 " + p3.equals(null));
		
		System.out.println();
		System.out.println();
		
		
		// reflexive
		System.out.println("Testing reflexive");
		System.out.println("S1  = S1 " + s1.equals(s1) + " Hash = " + s1.hashCode());
		System.out.println("S2  = S2 " + s2.equals(s2) + " Hash = " + s2.hashCode());
		System.out.println("S3  = S3 " + s3.equals(s3) + " Hash = " + s3.hashCode());
		System.out.println();
		
		// Student
		// symmetric
		System.out.println("Testing symmetric");
		System.out.println("S1  = S2 " + s1.equals(s2) + " Hash = " + s1.hashCode());
		System.out.println("S2  = S1 " + s2.equals(s1) + " Hash = " + s2.hashCode());
		System.out.println("S1 != S3 " + !s1.equals(s3) + " Hash = " + s1.hashCode());
		System.out.println("S3 != S1 " + !s3.equals(s1) + " Hash = " + s3.hashCode());
		System.out.println("S2 != S3 " + !s2.equals(s3) + " Hash = " + s2.hashCode());
		System.out.println("S3 != S2 " + !s3.equals(s2) + " Hash = " + s3.hashCode());
		System.out.println();
		
		//transitive
		System.out.println("Tsting transitive");
		System.out.println("S1  = S2 " + s1.equals(s2));
		System.out.println("S1 != S3 " + !s1.equals(s3));
		System.out.println("S2 != S2 " + !s2.equals(s3));
		System.out.println();
		
		//consistent
		System.out.println("Testing consistet");
		System.out.println("S1  = S1 " + (s1.equals(s1)&&s1.equals(s1)) );
		System.out.println("S2  = S2 " + (s2.equals(s2)&&s2.equals(s2)) );
		System.out.println("S3  = S3 " + (s3.equals(s3)&&s3.equals(s3)) );
		System.out.println();
		
		//Null
		System.out.println("Testing Null");
		System.out.println("S1  = 0 " + s1.equals(null));
		System.out.println("S2  = 0 " + s2.equals(null));
		System.out.println("S3  = 0 " + s3.equals(null));
		System.out.println();
		
		System.out.println("Vergleich Student Person");
		System.out.println(s1.equals(p2));
		System.out.println(p2.equals(s1));
		System.out.println(p2.hashCode() + " "+ s1.hashCode());
		

	}

}
