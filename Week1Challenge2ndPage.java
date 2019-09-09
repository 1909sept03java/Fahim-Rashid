import java.util.ArrayList;

public class Week1Challenge2ndPage {
	
	public static void main(String[] args) {
		
		System.out.println(mutCounter("AAACGGTA"));
		
	}
	
	public static int mutCounter(String end) {
		int counter = 0;
		String start = "AACCGGTT";
		ArrayList<String> bank = new ArrayList<String>();
		bank.add("AACCGGTA");
		bank.add("AAACGGTT");
		bank.add("AACCGCTA");
		bank.add("AAACGGTA");
		if(end.length() != start.length())
			return -1;
		else if(end.equals(start))
			return 0;
		else if(!end.equals(start)) {
			//for(int i = 0; i<bank.size();i++) {
				int j = 0;
				while(j<end.length()) {
					if(end.charAt(j) == start.charAt(j)) {
						j++;
					}
		
				else if(end.charAt(j) != start.charAt(j)) {
					
						String temp = start.replace(end.charAt(j), start.charAt(j));
						System.out.println(temp);
						if(bank.contains((Object)temp)) {
							start = temp;
							counter ++;
							j++;
							
		
						}else if(!bank.contains((Object)temp)) {
							System.out.println("That does not exist in the bank");
						}j++;
					}
					
				}
			}
		
		return counter;
	}
		
}
