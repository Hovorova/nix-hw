public class Task2 {
	// Expected output:
	// 1 - 9:45
	// 2 - 10:35
	// 3 - 11:35
	// 4 - 12:25
	// 5 - 13:25
	// 6 - 14:15
	// 7 - 15:15
	// 8 - 16:05
	// 9 - 17:05
	// 10 - 17:55

	public static void main(String[] args) {
		Task2 task2 = new Task2();
		task2.lessonsEnd(1);
		task2.lessonsEnd(2);
		task2.lessonsEnd(3);
		task2.lessonsEnd(4);
		task2.lessonsEnd(5);
		task2.lessonsEnd(6);
		task2.lessonsEnd(7);
		task2.lessonsEnd(8);
		task2.lessonsEnd(9);
		task2.lessonsEnd(10);
	}

	public void lessonsEnd(int numberOfLessons) {
		int lessonsTime = numberOfLessons * 45;
		int fiveMinBreakTime = (numberOfLessons - 1) * 5;
		int fifteenMinBreakTime = (numberOfLessons - 1) / 2 * 10;
		int total = lessonsTime + fiveMinBreakTime + fifteenMinBreakTime;

		System.out.printf("%d : %02d\n", total / 60 + 9, total % 60);
	}
}
