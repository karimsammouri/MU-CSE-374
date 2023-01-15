import java.util.Comparator;

public class Exercise6Comparators {
	String name;
	float age;
	int yearsOfExperience;
	boolean punctuality;
	boolean collegial;
	short disciplined;
	boolean dependable;
	boolean energetic;

	Comparator<Exercise6Comparators> comp = new Comparator<Exercise6Comparators>() {
		public int compare(Exercise6Comparators employee1,
				Exercise6Comparators employee2) {
			int employee1Score = (yearsOfExperience * 2) + (disciplined / 100);
			int employee2Score = (yearsOfExperience * 2) + (disciplined / 100);

			if (employee1.punctuality == true) {
				employee1Score += 10;
			} else {
				employee1Score -= 10;
			}
			if (employee1.collegial == true) {
				employee1Score += 15;
			} else {
				employee1Score -= 15;
			}
			if (employee1.dependable == true) {
				employee1Score += 20;
			} else {
				employee1Score -= 20;
			}
			if (employee1.energetic == true) {
				employee1Score += 5;
			} else {
				employee1Score -= 5;
			}

			if (employee2.punctuality == true) {
				employee2Score += 10;
			} else {
				employee2Score -= 10;
			}
			if (employee2.collegial == true) {
				employee2Score += 15;
			} else {
				employee2Score -= 15;
			}
			if (employee2.dependable == true) {
				employee2Score += 20;
			} else {
				employee2Score -= 20;
			}
			if (employee2.energetic == true) {
				employee2Score += 5;
			} else {
				employee2Score -= 5;
			}

			if (employee1Score > employee2Score) {
				return 1;
			} else if (employee1Score < employee2Score) {
				return -1;
			} else {
				return 0;
			}
		}
	};
}
