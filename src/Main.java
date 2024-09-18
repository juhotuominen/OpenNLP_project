import opennlp.tools.tokenize.*;
import opennlp.tools.namefind.*;
import opennlp.tools.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String sentence = "This is a test sentence. It is used to test OpenNLP functions";
        String[] nameSentence = new String[]{
                "Mike",
                "and",
                "Smith",
                "are",
                "friends"
        } ;

        System.out.println(" Tokenization\n");
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String tokens[] = tokenizer.tokenize(sentence);

        for (String token : tokens)
            System.out.println(token);
        System.out.println("\n\n\n Whitespace Tokenization\n");

        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;
        String whiteTokens[] = whitespaceTokenizer.tokenize(sentence);

        for (String token : whiteTokens)
            System.out.println(token);
        System.out.println("\n\n\n Name Recognition\n");

        InputStream inputStream = new FileInputStream("C:\\Users\\juhon\\IdeaProjects\\OpenNLP_project\\src\\en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStream);

        NameFinderME nameFinder = new NameFinderME(model);
        Span nameSpans[] = nameFinder.find(nameSentence);

        for(Span s: nameSpans)
            System.out.println(s.toString());


    }
}