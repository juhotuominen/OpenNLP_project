import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the pre-trained language detection model
            InputStream modelInputStream = new FileInputStream("src/langdetect-183.bin"); // FOR WINDOWS USE "src\\langdetect-183.bin"
            LanguageDetectorModel model = new LanguageDetectorModel(modelInputStream);

            // Initialize LanguageDetector
            LanguageDetectorME languageDetector = new LanguageDetectorME(model);

            // Input text for language detection
            String englishText = "The quick brown fox jumps over the lazy dog. Can you tell me where the nearest restaurant is?"; // English example
            String frenchText = "Le renard brun rapide saute par-dessus le chien paresseux. Pouvez-vous me dire où se trouve le restaurant le plus proche?";  // French example
            String finnishText = "Hei, miten menee? Voitko kertoa minulle, missä on lähin ravintola?";  // Finnish example

            // Detect the language
            Language detectedLanguage = languageDetector.predictLanguage(englishText);

            // Print detected language and confidence score
            System.out.println("Detected Language: " + detectedLanguage.getLang());
            System.out.println("Confidence: " + detectedLanguage.getConfidence() + "\n");

            // Detect the language
            detectedLanguage = languageDetector.predictLanguage(frenchText);

            // Print detected language and confidence score
            System.out.println("Detected Language: " + detectedLanguage.getLang());
            System.out.println("Confidence: " + detectedLanguage.getConfidence() + "\n");

            // Detect the language
            detectedLanguage = languageDetector.predictLanguage(finnishText);

            // Print detected language and confidence score
            System.out.println("Detected Language: " + detectedLanguage.getLang());
            System.out.println("Confidence: " + detectedLanguage.getConfidence());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
