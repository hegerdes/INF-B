package Blatt02;
public class Fraglich_ML {

	static int s = 1;

	static int a;

	public static void main(String argv[]) {
		System.out.printf("   |  a  |  b  | c[0]| c[1]| c[2]| c[3]|%n");
		System.out.printf("---+-----+-----+-----+-----+-----+-----+%n");

		int a = 5;
		int[] c = {
            16, 4, 2, 9 };

		System.out.printf("%3d|%5d| n/a |%5d|%5d|%5d|%5d|%n", s++, a, c[0],
				c[1], c[2], c[3]);

		initialize();

		System.out.printf("%3d|%5d| n/a |%5d|%5d|%5d|%5d|%n", s++, a, c[0],
				c[1], c[2], c[3]);

		for (int b = -1; b < 1; b += 3) {

			System.out.printf("%3d|%5d|%5d|%5d|%5d|%5d|%5d|%n", s++, a, b,
					c[0], c[1], c[2], c[3]);
			a /= 2;
			c[b + 2] -= c[b + 2];
		}

		System.out.printf("%3d|%5d| n/a |%5d|%5d|%5d|%5d|%n", s++, a, c[0],
				c[1], c[2], c[3]);

		for (a = 2; a < 3; a++) {

			int b = 2;
			c[a] -= c[b];

			System.out.printf("%3d|%5d|%5d|%5d|%5d|%5d|%5d|%n", s++, a, b,
					c[0], c[1], c[2], c[3]);
		}

		System.out.printf("%3d|%5d| n/a |%5d|%5d|%5d|%5d|%n", s++, a, c[0],
				c[1], c[2], c[3]);

		int b = method(a + c[a - 3]);

		System.out.printf("%3d|%5d|%5d|%5d|%5d|%5d|%5d|%n", s++, a, b, c[0],
				c[1], c[2], c[3]);

		b = 7 + method(++a, c);

		System.out.printf("%3d|%5d|%5d|%5d|%5d|%5d|%5d|%n", s++, a, b, c[0],
				c[1], c[2], c[3]);

		a = method(method(method(a), new int[] { b, a, c[0], c[2], c[3], c[1] }));

		System.out.printf("%3d|%5d|%5d|%5d|%5d|%5d|%5d|%n", s++, a, b, c[0],
				c[1], c[2], c[3]);
	}

	static void initialize() {

		int b = 0;

		a = 23;

		System.out.printf("%3d|%5d|%5d| n/a | n/a | n/a | n/a |%n", s++, a, b);
	}

	protected static int method(int b) {

		System.out.printf("%3d|%5d|%5d| n/a | n/a | n/a | n/a |%n", s++, a, b);

		return a;
	}

	private static int method(int a, int[] c) {

		a++;
		c[0] /= 2;
		c[0] = c[0] + c[1];
		c = new int[4];

		System.out.printf("%3d|%5d| n/a |%5d|%5d|%5d|%5d|%n", s++, a, c[0],
				c[1], c[2], c[3]);

		return a;
	}

}
