import java.util.Scanner;
/**
   TODO Change words or phrase into PigLatin
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Gavin Wong
   @version TODO 10/19/2018

   @author  Period - 5
   @author  Assignment - Piglatinator

   @author  Sources - TODO list collaborators
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        int start = -1;

        for(int index = 0; index < phraseToTranslate.length(); index++)
        {
            if(Character.isLetter(phraseToTranslate.charAt(index)) && start == -1)
            {
                start = index;
            }
            else if (!Character.isLetter(phraseToTranslate.charAt(index)) && 
                            start != -1)
            {
                String word = phraseToTranslate.substring(start, index);
                translation += wordToPigLatin(word) + 
                                phraseToTranslate.charAt(index);
                start = -1;
            } 
            else if(!Character.isLetter(phraseToTranslate.charAt(index)))
            {
                translation += phraseToTranslate.charAt(index);
            }
            else if(index == phraseToTranslate.length() - 1 && 
                            Character.isLetter(phraseToTranslate.charAt(index)))
            {
                String word = phraseToTranslate.substring(start);
                translation += wordToPigLatin(word);
            }
        }

        return translation;
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWYXZ";
        int caseNumber = 0;
        int firstVowel = 0;
        String pigLatinWord = "";
        String vowels = "aeiouAEIOU";
        for(int index = 0; index < englishWord.length(); index++ )
        {
            if (index == 0 && vowels.indexOf(englishWord.charAt(index)) > -1)
            {
                caseNumber = 2;
                break;
            }
            else if(vowels.indexOf(englishWord.charAt(index)) >= 0)
            {
                firstVowel = index;
                caseNumber = 3;
                break;
            }
            else if(vowels.indexOf(englishWord.charAt(index)) == -1)
            {
                caseNumber = 1;
            }
        }

        switch(caseNumber)
        {
            case 1:
                pigLatinWord = englishWord + "ay";
                break;
            case 2:
                pigLatinWord = englishWord + "yay";
                break;
            case 3:
                String start = englishWord.substring(0, firstVowel);
                String end = englishWord.substring(firstVowel);
                if (upperCaseAlphabet.indexOf(start.charAt(0)) >= 0)
                {
                    start = start.toLowerCase();
                    end = Character.toUpperCase(end.charAt(0)) +
                                    end.substring(1);        
                }
                pigLatinWord = end + start + "ay";
                break;
        }

        return pigLatinWord;
    }

    // TODO add additional helper methods

}
