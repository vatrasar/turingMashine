import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String fileName = "test.txt";
		DataReader dataReader = new DataReader(fileName);
		turingMachine(dataReader);

	}

	public static void turingMachine(DataReader dataReader) {
		Messages Message = new Messages();
		List<Character> tasma = new ArrayList<Character>();
		//sprawdzenie czy slowo nalezy do jezyka
		String slowoDoSprawdzenia = dataReader.getInWord();
		for (char c : slowoDoSprawdzenia.toCharArray()) {
				if(dataReader.getAlphabetIn().contains(""+c)==false) {
					System.exit(1);// slowo nie nalezyt do alfabetu
				}
		}
		
		int tasmaPraw = 1;// ile blokow 32 ma tasma
		int glowica = 1;
		// zapelnienie tasmy
		char hasz = '#';
		for (int i = 0; i < 32; i++) {
			tasma.add(hasz);
		}
		// zapis slowa pcozatkowego
		String slowo = dataReader.getInWord();
		int i = 1;
		for (char c : slowo.toCharArray()) {
			tasma.set(i, c);
			i++;
		}
		// wyznaczenie stanu poczatkowego
		State actual = dataReader.getStartState();
		// PORUSZANIE sie maszyny
		Message.Configuration(tasma, glowica, actual);
		while (actual.isFinish() == false) {
			String haszs = String.valueOf(tasma.get(glowica));
			TransitionKey key = new TransitionKey(actual, haszs);
			Transition tr = dataReader.getTransitionsMap().get(key);
			// jesli nie ma przejscia
			if (tr == null) {
				Message.Error();
				break;
			}
			// zmiana symbolu przy wczytywaniu
			tasma.set(glowica, tr.outChar.charAt(0));
			// zmiana miejsca glowicy
			if (tr.nextMoveDirection == Diretion.RIGHT) {
				glowica++;
			} else {
				glowica--;
			}
			// rozszerzenie tasmy
			if (glowica == -1) {
				Message.TapeExtension("left");
				List<Character> tasma2 = new ArrayList<Character>();
				for (int j = 0; j < 32; j++) {
					tasma2.add(hasz);
				}
				for (int j = 0; j < 32; j++) {
					tasma2.add(32 + j, tasma.get(j));
				}
				tasma.clear();
				tasma.addAll(tasma2);
				glowica = 31;
				tasmaPraw++;
			} else if (glowica == (tasmaPraw * 32)) {
				Message.TapeExtension("right");
				for (int j = 0; j < 32; j++) {
					tasma.add(hasz);
				}
				tasmaPraw++;
			}
			// zmiana stanu
			actual = tr.nextState;
			Message.Configuration(tasma, glowica, actual);
		}
		Message.SummarizeComputes(slowo);
	}

}
