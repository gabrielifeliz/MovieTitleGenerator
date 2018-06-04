package com.company;

// Import Random class
import java.util.Random;
import java.net.URL;
import java.util.Scanner;

public class MovieTitleGen
{
    public static void main(String[] args) throws Exception
    {
        // Create Random object
        Random rnd = new Random();

        String[] adjectives = arrayFromUrl("https://cs.leanderisd.org/txt/adjectives.txt");
        String[] nouns      = arrayFromUrl("https://cs.leanderisd.org/txt/nouns.txt");

        System.out.println("Myxyllplyk's Random Movie Title Generator\n");

        System.out.print("Choosing randomly from " + adjectives.length + " adjectives ");
        System.out.println("and " + nouns.length + " nouns (" + (adjectives.length*nouns.length) + " combinations).");

        // Generate random adjective by randomly choosing an element from the adjectives array
        String randomAdjective = adjectives[rnd.nextInt(adjectives.length - 1)];
        // Build the adjective so that the first character is uppercase and the rest are lowercase
        String adjective = randomAdjective.toUpperCase().charAt(0) + randomAdjective.substring(1);

        // Generate random noun by randomly choosing an element from the nouns array
        String randomNoun = nouns[rnd.nextInt(nouns.length - 1)];
        // Build the noun so that the first character is uppercase and the rest are lowercase
        String noun = randomNoun.toUpperCase().charAt(0) + randomNoun.substring(1);

        // Display random adjectives and nouns to create movie title
        System.out.println( "Your movie title is: " + adjective + " " + noun );
    }

    /**
     *	@param url - the URL to read words from
     *	@return An array of words, initialized from the given URL
     */
    public static String[] arrayFromUrl( String url ) throws Exception
    {
        Scanner fin = new Scanner((new URL(url)).openStream());
        int count = fin.nextInt();

        String[] words = new String[count];

        for ( int i=0; i<words.length; i++ )
        {
            words[i] = fin.next();
        }
        fin.close();

        return words;
    }

}