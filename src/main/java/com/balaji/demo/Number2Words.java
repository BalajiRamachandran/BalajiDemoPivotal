package com.balaji.demo;

import java.text.DecimalFormat;

/**
 * @author bajji
 *
 */
public class Number2Words {
	private static boolean bSingular = true;

	/**
	 * 
	 */
	public Number2Words() {
		// TODO Auto-generated constructor stub
	}
		

	  private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };

	  /**
	 * @param number
	 * @return
	 */
	private static String convertLessThanOneThousand(int number) {
	    String soFar;

	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;
	      if ( !soFar.isEmpty() ) {
	    	  soFar = tensNames[number % 10] + "-" + soFar.trim();
	      } else {
	    	  soFar = tensNames[number % 10] + soFar.trim();
	      }
	      number /= 10;
	    }
	    // if number = 0 then singular
	    if (number == 0) {
	    	return soFar;
	    }
	    return numNames[number] + " hundred" + soFar;
	  }


	  /**
	 * @param number
	 * @return
	 */
	public String convert(double number) {
	    // 0 to 999 999 999 999
	    if (number == 0) { return "zero"; }

	    String snumber = Double.toString(number);
	    // pad with "0"
	    String mask = "000000000000.00";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);
	    
	    
	    int cents = Integer.parseInt(snumber.substring(snumber.indexOf (".")+1, snumber.length()));
	    String centsMask = "00";
	    df = new DecimalFormat(centsMask);
	    
	    // XXXnnnnnnnnn
	    int billions = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXXnnnnnn
	    int millions  = Integer.parseInt(snumber.substring(3,6));
	    // nnnnnnXXXnnn
	    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
	    // nnnnnnnnnXXX
	    int thousands = Integer.parseInt(snumber.substring(9,12));
	    
	    if ( billions > 0 || millions > 0 || hundredThousands > 0 || thousands > 0 ) {
	    	bSingular = false;
	    }

	    String tradBillions;
	    switch (billions) {
	    case 0:
	      tradBillions = "";
	      break;
	    case 1 :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	      break;
	    default :
	      tradBillions = convertLessThanOneThousand(billions)
	      + " billion ";
	    }
	    String result =  tradBillions;

	    String tradMillions;
	    switch (millions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(millions)
	         + " million ";
	    }
	    result =  result + tradMillions;

	    String tradHundredThousands;
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one thousand ";
	      break;
	    default :
	      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
	         + " thousand ";
	    }
	    result =  result + tradHundredThousands;

	    String tradThousand;
	    tradThousand = convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;
	    
	    if ( cents > 0 ) {
	    	result = result + " and " + df.format ( cents ) + "/100 " ;
	    } else {
	    	result = result + " and " +  "00/100 " ;
	    }
	    
	    if ( bSingular ) { 
	    	result = result + "dollar";
	    } else {
	    	result = result + "dollars";
	    }
	    result = result.trim();
	    result = Character.toUpperCase(result.charAt(0)) + result.substring(1);

	    // remove extra spaces!
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	  }
}
