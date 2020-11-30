import java.util.List;

public class Messages {
	
	public Messages() {
		
	}
	
	public void TapeExtension(String site) {
		if(site == "right") {
			System.out.println("Taśma została przedłużona z prawej strony.");
		}else if(site == "left"){
			System.out.println("Taśma została przedłużona z lewej strony.");
		}else {
			System.out.println("Taśma została przedłużona.");
		}
	}
	
	public void Configuration(List<Character> Tape) {
		
	}
	
	public void SummarizeComputes() {
		
	}
	
	public void Error() {
		System.out.println("Obliczenia zakończone błędem.");
	}
}
