
public class Main {
	public static final String[] MONTHS = {"January", "Febuary", "March", "Arpil", "May", 
			"June", "July", "August", "September", "October", "November", "December"};
	
	/**
	 * Input strings must be in the format yyyy-mm-dd
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main main = new Main(args);
	}
	
	public Main(String[] args) {
		for(int i =0; i < args.length; i++) {
			if(isISO(args[i]) == false) {
				System.out.println(args[i] + " is not in the correct format, input must be yyyy-mm-dd");
			} else {
				String[] date = args[i].split("-", 5);
				String us = convertToUS(date);
				String uk = convertToUK(date);
				String spoken = convertToSpeech(date);
				
				System.out.println(args[i] + "->" + " US: " + us + " UK: " + uk + " Spoken: " + spoken);
			}
		}
	}
	
	public boolean isISO(String date) {
		if(date.matches("\\d{4}-\\d{2}-\\d{2}")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public String convertToUK(String[] isoDate) {
		String ukDate = isoDate[2] + "/"+ isoDate[1] + "/" + isoDate[0];
		return ukDate;
	}
	
	public String convertToUS(String[] isoDate) {
		String usDate = isoDate[1] + "/" + isoDate[2] + "/" + isoDate[0];
		return usDate;
	}
	
	public String convertToSpeech(String[] isoDate) {
		String speech = new String();
		speech += processDay(isoDate[2]);
		speech += " of " + processMonth(isoDate[1]) + " " + isoDate[0];
		return speech;
	}
	
	public String processDay(String dayNum) {
		String daySpeech = "";
		String[] day =dayNum.split("(?!^)");
		if(day[0].equals("0")) {
			daySpeech = dayToSpeech(day[1]);
		} else if (day[0].equals("1")) {
			switch(day[1]) {
			case "0": daySpeech = "tenth";
			break;
			case "1": daySpeech = "eleventh";
			break;
			case "2": daySpeech = "twelth";
			break;
			case "3": daySpeech = "thirteenth";
			break;
			case "4": daySpeech = "fourthteenth";
			break;
			case "5": daySpeech = "fifteenth";
			break;
			case "6": daySpeech = "sixteenth";
			break;
			case "7": daySpeech = "seventeenth";
			break;
			case "8": daySpeech = "eigteenth";
			break;
			case "9": daySpeech = "nintheenth";
			break;
			}
		} else if (day[0].equals("2")) {
			daySpeech="twenty";
			daySpeech+=dayToSpeech(day[1]);
		} else if (day[0].equals("3")) {
			daySpeech="thirty";
			daySpeech+=dayToSpeech(day[1]);
		}
		
		return daySpeech;
	}
	
	public String processMonth(String monthNum) {
		 return MONTHS[Integer.parseInt(monthNum)-1];
	}
	 
	public String dayToSpeech(String day) {
		String daySpeech = new String();
		switch(day) {
		case "0": daySpeech = "eth";
		break;
		case "1": daySpeech = "first";
		break;
		case "2": daySpeech = "second";
		break;
		case "3": daySpeech = "third";
		break;
		case "4": daySpeech = "fourth";
		break;
		case "5": daySpeech = "fifth";
		break;
		case "6": daySpeech = "sixth";
		break;
		case "7": daySpeech = "seventh";
		break;
		case "8": daySpeech = "eigth";
		break;
		case "9": daySpeech = "ninth";
		break;
	}
		return daySpeech;
	}
}
