// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package arabicnormalizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.ArrayList;
/**
 *
 * @author aahmed
 */


public class ArabicNormalizer {


    // ALL Arabic letters \U0621-\U063A\U0641-\U064A

    public static final String AllArabicLetters = "\u0621\u0622\u0623\u0624\u0625\u0626\u0627\u0628\u0629\u062A\u062B\u062C\u062D\u062E\u062F"
	    + "\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063A\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u0649\u064A";
    public static final String AllArabicDiacritics = "\u064B\u064C\u064D\u064E\u064F\u0650\u0651\u0652";
    // ALL Hindi digits \U0660-\U0669
    public static final String AllHindiDigits = "\u0660\u0661\u0662\u0663\u0664\u0665\u0666\u0667\u0668\u0669";
    // ALL Arabic letters and Hindi digits \U0621-\U063A\U0641-\U064A\U0660-\U0669
    public static final String AllArabicLettersAndHindiDigits = "\u0621\u0622\u0623\u0624\u0625\u0626\u0627\u0628\u0629\u062A\u062B\u062C\u062D\u062E\u062F"
	    + "\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063A\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u0649\u064A\u0660\u0661\u0662\u0663\u0664\u0665\u0666\u0667\u0668\u0669";
    public static final String AllDigits = "0123456789";
    public static final String ALLDelimiters = "\u0020\u0000-\u002F\u003A-\u0040\u007B-\u00BB\u005B-\u005D\u005F-\u0060\\^\u0600-\u060C\u06D4-\u06ED\ufeff";

    public static ArrayList<String> ArabicStopWords = new ArrayList<>();

    public static final char ALEF = '\u0627';
    public static final char ALEF_MADDA = '\u0622';
    public static final char ALEF_HAMZA_ABOVE = '\u0623';
    public static final char ALEF_HAMZA_BELOW = '\u0625';

    public static final char HAMZA = '\u0621';
    public static final char HAMZA_ON_NABRA = '\u0624';
    public static final char HAMZA_ON_WAW = '\u0626';

    public static final char YEH = '\u064A';
    public static final char DOTLESS_YEH = '\u0649';

    public static final char TEH_MARBUTA = '\u0629';
    public static final char HEH = '\u0647';

    public static final Pattern emailRegex = Pattern.compile("[a-zA-Z0-9\\-\\._]+@[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\-_]+");
    public static final Pattern dateRegex = Pattern.compile("[0-9]+[\\-/][0-9]+([\\-/][0-9]+)*");
    public static final Pattern pAllDiacritics = Pattern.compile("[\u0640\u064b\u064c\u064d\u064e\u064f\u0650\u0651\u0652\u0670]");
    public static final Pattern pAllNonCharacters = Pattern.compile("[\u0020\u2000-\u200F\u2028-\u202F\u205F-\u206F\uFEFF]+");
    public static final Pattern pAllDelimiters = Pattern.compile("[" + ALLDelimiters + "]+");

	private final static String FARSI_ORIGINAL_CHARACHTERS =    "٠١٢۲٣۳٤٥Ƽ٦٧۷٨۸٩۹ﺀٴٱﺂﭑﺎﺈﺄιٲﺍٳίﺃٵﺇﺁﺑپﮨﺒٻﺐﺏﭘﭒﭗﭖﭚٮﭛٺﺗﭠﺘټﺖﺕﭡٹﭞٿﭟﭤﮢﭥﭨﭢﭣﮣﭧﺛﺜﮆﺚﺙٽﮇچﺟﭴﺠﭼڄڇﭸﺝڃﺞﭽﮀﭵﭹﭻﭾﭿﭺﺣﺤﺡﺢځﺧﺨڅڂﺦﺥڿډﺩڍﺪڊڈﮃﮂڋﮈڌﮉڐﮄﺫﺬڎڏۮڕړﺮﺭڒڔږڑژﮌڗﮍڙﺯﺰﮊﺳڛﺴﺲﺱښﺷڜﺸﺶﺵۺﺻﺼڝﺺﺹﺿﻀﺽڞﺾۻﻃﻁﻄﻂﻈﻇﻅڟﻆﻋ۶ﻌﻊﻉﻏﻐڠۼﻍﻎﻓڤﻔﭬڣﭰﻒﻑڦڢڡﭫڥﭪﭭﭯﭮﻗﻘڨﻖﻕڧﭱگڳکڪڱﮔﻛﮘڰﮐﮖﻜﮜڲﻚڴﮗڭﻙﮓﮙګڮﮕﮛڬﮎﮝﮚﮑﮒﮏﯖﯕﻟڵڷﻠڶﻞﻝڸﻣﻤﻢﻡﻧﻥڼﻨﻦڻڽﮠڹﮞںטﮡﮟھہۃﮬﮪﮧۂﻫﮫﺔﻪﻬﮭﺓۿﻩەۀﮤﮥﮦۆۈۅﯙۉﻭﻮۄۋۇۊﯚٷٶﯛﯠﺆﯜۏﺅﯡﯝﯘﯢﯞﯣﯗﯟﯾےﻳۓېێﮱﻴﮯﭔﻲۑۍﯿﻱﻰﭜڀﺋﻯﭕﮮﺌﭓﯼﭝ༦ﺊﯽﮰﭙﯥﺉﯦﯧﯤیٸ";
    private final static String ARABIC_NORMALIZED_CHARACHTERS = "0122334556778899ءءاآااإأاأاإاأأإآببببببببببببببتتتتتتتتتتتتتتتتتتتتثثثثثثثجججججججججججججججججججحححححخخخخخخخددددددددددددددذذذذذرررررررررررررزززسسسسسسششششششصصصصصضضضضضضططططظظظظظعععععغغغغغغفففففففففففففففففقققققققككككككككككككككككككككككككككككككككككللللللللممممننننننننننننننههةههههههةهههةهههههههووووووووووووؤؤووؤووؤوؤوووووويىيئيئئيىيىيىييىييئىيىئيىيىئىئيىئيييىئ";

    private final static String FARSI_LA_ORIGINAL = "[ﻻﻵﻷעﻹﻼﻶﻸﬠ]";
    private final static String ARABIC_LA_NORMALIZED = "لا";

    public static final String EMPTY = "";

     /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here

    	processStream();
    }

    private static void processStream() throws IOException
    {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		processBuffer(br, bw);
    }	

    private static void processBuffer(BufferedReader br, BufferedWriter bw) throws IOException  
    {

		String line = "";

		while ((line = br.readLine()) != null)
		{
		 	//ArrayList<String> words = tokenize(removeDiacritics(line));
		    // normalize Farsi letter
		    line = replaceFarsiCharacters(line);
		    line = normalizeFull(line);
		    bw.write(line+"\n");
		}

        bw.flush();
        br.close();
		bw.close();
	}

	public static String replaceFarsiCharacters(String input)
    {
    	input = input.replace("ﻻ","لا");
        input = input.replace("ﻵ","لآ");
        input = input.replace("ﻷ","لأ");
        input = input.replace("ע","لا");
        input = input.replace("ﻹ","لإ");
        input = input.replace("ﻼ","لا");
        input = input.replace("ﻶ","لآ");
        input = input.replace("ﻸ","لأ");
        input = input.replace("ﬠ","لا");
		//input = input.replaceAll(FARSI_LA_ORIGINAL, ARABIC_LA_NORMALIZED);
		input = replaceChars(input, FARSI_ORIGINAL_CHARACHTERS, ARABIC_NORMALIZED_CHARACHTERS);
		return input;
    }

    public static String normalizeFull(String s) {
     
        s = s.replace(ALEF_MADDA, ALEF).replace(ALEF_HAMZA_ABOVE, ALEF).replace(ALEF_HAMZA_BELOW, ALEF);
         s = s.replace(DOTLESS_YEH, YEH);
         s = s.replace(HAMZA_ON_NABRA, HAMZA).replace(HAMZA_ON_WAW, HAMZA);
         s = s.replace(TEH_MARBUTA, HEH);
         s = s.replace("ٱ", "ا");
         
         s = pAllDiacritics.matcher(s).replaceAll("");

        return s;
    }	
    public static String replaceChars(final String str, final char searchChar, final char replaceChar)
    {
		if (str == null)
		{
	    	return null;
		}
		return str.replace(searchChar, replaceChar);
    }

    public static String replaceChars(final String str, final String searchChars, String replaceChars)
    {
    	if (isEmpty(str) || isEmpty(searchChars))
    	{
    		return str;
    	}
    	if (replaceChars == null)
    	{
    		replaceChars = EMPTY;
    	}
    	boolean modified = false;
    	final int replaceCharsLength = replaceChars.length();
    	final int strLength = str.length();
    	final StringBuilder buf = new StringBuilder(strLength);
    	for (int i = 0; i < strLength; i++)
    	{
    		final char ch = str.charAt(i);
    		final int index = searchChars.indexOf(ch);
    		if (index >= 0)
    		{
    			modified = true;
    			if (index < replaceCharsLength)
    			{
    				buf.append(replaceChars.charAt(index));
    			}
    		}
    		else
    		{
    			buf.append(ch);
    		}
    	}
    	if (modified)
    	{
    		return buf.toString();
    	}
    	return str;
    }

    public static boolean isEmpty(final CharSequence cs)
    {
		return cs == null || cs.length() == 0;
    }
}
