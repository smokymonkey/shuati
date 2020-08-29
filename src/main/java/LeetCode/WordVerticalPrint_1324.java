import java.util.ArrayList;
import java.util.List;

public class WordVerticalPrint_1324 {
  public List<String> printVertically(String s) {
    List<StringBuilder> stringBuilders = new ArrayList<>();
    stringBuilders.add(new StringBuilder());
    String[] subStrings = s.split(" ");

    for(int wordIdx =0; wordIdx<subStrings.length; wordIdx++){
      String word = subStrings[wordIdx];
      for(int charIdx=0;charIdx<word.length();charIdx++){
        if(charIdx>(stringBuilders.size()-1))
          stringBuilders.add(new StringBuilder());
        int curLength = stringBuilders.get(charIdx).length();
        for(int j =0;j<wordIdx-curLength;j++)
          stringBuilders.get(charIdx).append(' ');
        stringBuilders.get(charIdx).append(word.charAt(charIdx));
      }
    }
    List<String> rt = new ArrayList<>();
    for(int i =0 ;i<stringBuilders.size();i++){
      rt.add(stringBuilders.get(i).toString());
    }
    return rt;
  }
  public static void main(String[] args){
    new WordVerticalPrint_1324().printVertically("TO BE OR NOT TO BE");
  }
}
