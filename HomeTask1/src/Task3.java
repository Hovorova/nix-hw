public class Task3 {
	public static void main(String[] args) {
		Task3 task3 = new Task3();
		task3.timeDiff(1, 1, 1, 2, 2, 2);
		task3.timeDiff(1, 2, 30, 1, 3, 20);
	}
	
	public void timeDiff(int h1, int m1, int s1, int h2, int m2, int s2) {
		int t1 = s1 + m1 * 60 + h1 * 60 * 60;
		int t2 = s2 + m2 * 60 + h2 * 60 * 60;
		int diff = t2 - t1;
		System.out.println(diff);
	}
}
