package first;

public class Word {
    private String string;
    private static final String SEARCH_NONTEXT = "[^abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]";     //regex для небуквенных символов
    private static final String NOTHING = "";                                                               //для исключения небуквенных символов
    private static final String SEARCH_TEXT = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]";     //regex для буквенных символов (латиница)
    private static final String GAP = " ";                                                                  //для замены буквенных символов на пробелы
    private static final char GAP_CHAR = ' ';                                                               //символьный аналог от GAP

    public Word(String string){
        this.string = string;
        showReverse();
    }

    private void showReverse(){
        char[] result = new char[this.string.length()];//инициализация массива
        char[] reverse = this.reverseArray(this.getWordToArray(this.getText(string)));//выделяем с входящего String только буквенные символы и разворачиваем их
        char[] nontext = this.getWordToArray(this.getNonText(string));//выделяем с входящего String только небуквенные символы, оставляем их на местах, а буквенные заменяем на пробелы

        int k = 0;//показатель небуквенных символов в небуквенном массиве nontext
        for (int i = 0; i < result.length; i++) {
            if (nontext[i] != GAP_CHAR){
                //если в nontext на позиции i не пробел, добавляем в result
                result[i]=nontext[i];//а если на позиции i стоит пробел, то добавляем в result символ с буквенного массива reverse, учитывая смещение на k
                k++;
            }else result[i] = reverse[i - k];
            System.out.print(result[i]);
        }

    }
    private char[] getWordToArray(String string){
        return string.toCharArray();
    }//конвертация String в массив char

    private String getText(String string){
        return string.replaceAll(SEARCH_NONTEXT,NOTHING);
    }//получаем String только буквенных символов, а не буквенные удаляем

    private String getNonText(String string){
        return string.replaceAll(SEARCH_TEXT,GAP);
    }//получаем String только не буквенных символов, а буквенные заменяем на пробелы

    private char[] reverseArray(char[] chars){
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]))
                result[chars.length-1-i]=chars[i];
            else
                result[i] = chars[i];
        }
        return result;
    }//разворачивает массив chars в обратную сторону
}
