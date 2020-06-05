public class Task4 {
	public static void main(String[] args) {
		Task4 task4 = new Task4();
		task4.auto(700, 750);
		task4.auto(700, 2100);
	}

	public void auto(int n, int m) {
		System.out.println(m / n + ((int) (Math.ceil(((double) m) % n / n))));
	}

}
