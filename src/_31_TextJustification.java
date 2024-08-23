import java.util.*;

class Node{
    private int wordWidth;
    private List<String> line;

    public Node(int wordWidth, List<String> line) {
        this.wordWidth = wordWidth;
        this.line = line;
    }

    public int getWordWidth() {
        return wordWidth;
    }

    public void setWordWidth(int wordWidth) {
        this.wordWidth = wordWidth;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }
}
public class _31_TextJustification {
    String [] spaces;
    public List<String> fullJustify(String[] words, int maxWidth) {
        spaces = new String[maxWidth];
        List<Node> list = new ArrayList<>();
        int widthLeft = maxWidth;
        int lineLength = 0;
        List<String> line = new ArrayList<>();
        for(String word : words){
            if(word.length() <= widthLeft){
                line.add(word);
                lineLength = lineLength + word.length();
                widthLeft = widthLeft - (word.length() + 1);
            } else {
                list.add(new Node(lineLength, line));
                line = new ArrayList<>();
                lineLength = 0 ;
                line.add(word);
                lineLength = lineLength + word.length();
                widthLeft = maxWidth - (word.length() + 1);
            }
        }
        list.add(new Node(lineLength, line));
        List<String> result = new ArrayList<>();
        int index=0;
        for(Node n : list){
            System.out.println(n.getWordWidth() + " " + n.getLine());
            if(index == list.size()-1){
                StringBuilder sb = new StringBuilder();
                int i=0;
                for(String word: n.getLine()){
                    sb.append(word);
                    if(i<n.getLine().size()-1){
                        sb.append(" ");
                    }
                    i++;
                }
                sb.append(getSpaces(maxWidth - sb.length()));
                result.add(sb.toString());
            } else if(n.getLine().size() == 1){
                int spacesToAdd = maxWidth - n.getWordWidth();
                String sb = n.getLine().get(0) + getSpaces(spacesToAdd);
                result.add(sb);
            } else {
                int spacesToAdd = maxWidth - n.getWordWidth();
                int spacePerWord = spacesToAdd / (n.getLine().size()-1);
                int [] spacesToAddPerWord = new int [n.getLine().size()-1];
                Arrays.fill(spacesToAddPerWord, spacePerWord);
                int currWidth = n.getWordWidth() + (spacePerWord * spacesToAddPerWord.length);
                while (currWidth != maxWidth){
                    for(int i=0;i<spacesToAddPerWord.length;i++){
                        spacesToAddPerWord[i] = spacesToAddPerWord[i] + 1;
                        currWidth++;
                        if(currWidth == maxWidth)
                            break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                int i=0;
                for(String word: n.getLine()){
                    sb.append(word);
                    if(i < (n.getLine().size()-1)){
                        sb.append(getSpaces(spacesToAddPerWord[i]));
                    }
                    i++;
                }
                result.add(sb.toString());
            }

            index++;

        }
        return result;
    }

    public String getSpaces(int length){
        if(spaces[length] == null){
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<length;i++){
                sb.append(" ");
            }
            spaces[length] = sb.toString();
        }

        return spaces[length];
    }

    public static void main(String[] args) {
        _31_TextJustification tj = new _31_TextJustification();
        System.out.println(tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(tj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
//        System.out.println(tj.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16));
//        System.out.println(tj.fullJustify(new String[]{"Give","me","my","Romeo;","and,","when","he","shall","die,","Take","him","and","cut","him","out","in","little","stars,","And","he","will","make","the","face","of","heaven","so","fine","That","all","the","world","will","be","in","love","with","night","And","pay","no","worship","to","the","garish","sun."}, 25));

    }
}
