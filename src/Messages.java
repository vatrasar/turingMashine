import java.util.List;

public class Messages {

	public Messages() {

	}

	public void TapeExtension(String site) {
		if (site == "right") {
			System.out.println("Taśma została przedłużona z prawej strony.");
		} else if (site == "left") {
			System.out.println("Taśma została przedłużona z lewej strony.");
		} else {
			System.out.println("Taśma została przedłużona.");
		}
	}

	public void Configuration(List<Character> tape, int head, State state) {
		String rightSite = "";
		int i = head;
		while (i < tape.size() && tape.get(i) != '#') {
			rightSite = rightSite + tape.get(i);
			i++;
		}
		String leftSite = "";
		i = head - 1;
		while (i >= 0 && tape.get(i) != '#') {
			leftSite = leftSite + tape.get(i);
			i--;
		}
		if (leftSite == "") {
			leftSite = "#";
		} else {
			StringBuilder reverseLeftSite = new StringBuilder(leftSite);
			leftSite = reverseLeftSite.reverse().toString();
		}
		if (rightSite == "") {
			rightSite = "#";
		}
		System.out.println("(" + state.getId() + ", " + leftSite + ", " + rightSite + ")");
	}

	public void SummarizeComputes() {

	}

	public void Error() {
		System.out.println("Obliczenia zakończone błędem.");
	}
}
