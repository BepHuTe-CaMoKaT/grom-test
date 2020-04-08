package first;

public class Main {
    public static void main(String[] args) {
        String str = "a1bcd efg!h";
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++){
            Word word = new Word(words[i]);
            System.out.print(" ");
        }
    }
}