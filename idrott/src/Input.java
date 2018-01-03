import java.util.Scanner;

public class Input {
	
	private Scanner scan = new Scanner(System.in);
	
	public int readInt() {
		int i = scan.nextInt();
		scan.nextLine();
		return i;
	}
	
	public float readFloat() {
		float f = scan.nextFloat();
		scan.nextLine();
		return f;
	}
	
	public String readString() {
		return scan.nextLine();
	}
	
	public String readTrimmedString() {
		return readString().trim();
	}
	
}