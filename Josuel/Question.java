package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by elizabethsengoba on 10/19/16.
 */
public class Question {

        Question() throws IOException {
            this.getQuestion();
        }
        public String getQuestion() throws IOException {
            // Read in the file from the text
            /**
             * Added by Josuel
             * Randomly select a question from the list of questions retrieved from the file
             */
            Random rand = new Random();

            String ans = getListOfQuestions().get(rand.nextInt(getListOfQuestions().size() - 1));

            return ans;
        }

    /**
     * Added by Josuel
     * This function reads from a file a list of questions from a specific category
     * and stores them in a list.
     */
    ArrayList<String> getListOfQuestions() throws IOException {
        ArrayList<String> questions = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get("src/model/geekout.txt"))) {
            questions.add(line);
        }

        return questions;
    }

}
