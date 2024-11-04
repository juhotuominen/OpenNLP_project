import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) {
        try {
            // Load the pre-trained language detection model
            InputStream modelInputStream = new FileInputStream("src/langdetect-183.bin");
            LanguageDetectorModel model = new LanguageDetectorModel(modelInputStream);

            // Initialize LanguageDetector
            LanguageDetectorME languageDetector = new LanguageDetectorME(model);

            String link = args[0]; // Get link from arguments

            Document doc = Jsoup.connect(link).get();
            Elements lines = doc.select("p");
            String linesToString = lines.html();

            Language detectedLanguage = languageDetector.predictLanguage(linesToString);
            System.out.println("\n\nDetected Language: " + detectedLanguage.getLang());
            System.out.println("Confidence: " + detectedLanguage.getConfidence() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
