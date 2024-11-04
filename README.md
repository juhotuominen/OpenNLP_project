OpenNLP project where user can input website as argument and program returns detected language and confidence score.  
Uses Apache OpenNLP for language detection and Jsoup for website parsing.  
  
Compile: javac -cp "path/to/opennlp;path/to/jsoup" Main.java  
Run:     java -cp "path/to/opennlp;path/to/jsoup" Main.java "https://www.example.com/"  

openjdk 19.0.2  
opennlp 2.4.0  
jsoup 1.18.1  
