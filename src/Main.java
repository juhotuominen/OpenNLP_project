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
            InputStream modelInputStream = new FileInputStream("src/langdetect-183.bin");
            LanguageDetectorModel model = new LanguageDetectorModel(modelInputStream);

            // Initialize LanguageDetector
            LanguageDetectorME languageDetector = new LanguageDetectorME(model);

            // Input text for language detection
            String englishText = "The quick brown fox jumps over the lazy dog. Can you tell me where the nearest restaurant is?"; // English example
            String frenchText = "Le renard brun rapide saute par-dessus le chien paresseux. Pouvez-vous me dire où se trouve le restaurant le plus proche?";  // French example
            String finnishText = "Hei, anteeksi! Voitko kertoa minulle, missä on lähin ravintola?";  // Finnish example
            String koreanText = "빠른 갈색 여우가 게으른 개를 뛰어 넘습니다. 가장 가까운 레스토랑이 어디 있는지 알려줄 수 있나요?"; // Korean example

            String languages[] = new String [] {englishText, frenchText, finnishText, koreanText};

            for(int i = 0; i < languages.length; i++ )
            {
                // Detect the language
                Language detectedLanguage = languageDetector.predictLanguage(languages[i]);
                // Print detected language and confidence score
                System.out.println("Detected Language: " + detectedLanguage.getLang());
                System.out.println("Confidence: " + detectedLanguage.getConfidence() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
