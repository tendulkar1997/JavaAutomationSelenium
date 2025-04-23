package temp;

import java.util.Date;

public class EmailChange {

	public static void main(String[] args) {	
	
		Date date= new Date();
		String  stringDate=date.toString();
	     String stringNospace= stringDate.replaceAll("\\s", "");
	     String nospaceNocolon= stringNospace.replaceAll("\\:", "");
	     String emailTime=nospaceNocolon+"@gmail.com";
	     System.out.println(emailTime);

	}

}
