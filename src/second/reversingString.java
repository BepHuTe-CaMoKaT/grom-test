package second;

public class reversingString {
    private String string;
    private static final String SEARCH_NONTEXT = "";
    private static final String SEARCH_TEXT = "";
    private static final String NOTHING = "";
    private static final String GAP = " ";
    private static final char GAP_CHAR = ' ';

    private reversingString(String str){
        this.string=str;
        showReverse();
    }

    private void showReverse(){
        char[] result = new char[string.length()];
        char[] reverse = this.reverseArray(this.getWordToArray(this.getText(string)));
        char[] nontext = this.getWordToArray(this.getNonText(string));
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            if (nontext[i]!=GAP_CHAR){
               result[i]=nontext[i];
               k++;
            }else result[i] = reverse[i-k];
            System.out.println(result[i]);
        }
    }
    private char[] getWordToArray(String string){
        return string.toCharArray();
    }
    private String getText(String string){
        return string.replaceAll(SEARCH_NONTEXT,NOTHING);
    }

    private String getNonText(String string){
        return string.replaceAll(SEARCH_TEXT,GAP);
    }

    private char[] reverseArray(char[] chars){
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) result[chars.length-1-i] = chars[i];
            else result[i] = chars[i];
        }
        return result;
    }
}
