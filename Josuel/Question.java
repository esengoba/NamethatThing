package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
            ArrayList<String> questions = new ArrayList<>();
            ArrayList<String> questionID = new ArrayList<>();
            HashMap<String, ArrayList<String>> answers = new HashMap<>();

            getListOfQuestions(questions, questionID, answers);
            getListOfAnswers(answers);

            Random rand = new Random();

            String ans = questions.get(rand.nextInt(questions.size() - 1));

            return ans;
        }

    /**
     * Added by Josuel
     * This function reads from a file a list of questions from a specific category
     * and stores them in a list.
     */
    void getListOfQuestions(ArrayList<String> questions, ArrayList<String> questionID, HashMap<String, ArrayList<String>> answers) throws IOException {
        ArrayList<String> temp = new ArrayList<>();

        boolean isOdd = true;

        for (String line : Files.readAllLines(Paths.get("src/model/geekout.txt"))) {

            if (isOdd){
                answers.put(line, temp);
                questionID.add(line);
                isOdd = false;
            } else{
                questions.add(line);
                isOdd = true;
            }
        }
    }

    /**
     * Read the file containing the answers
     * These answers are mapped to a key value corresponding to the
     * questionID
     */

    void getListOfAnswers(HashMap<String, ArrayList<String>> ans) throws IOException {

        int num = 1;
        String key = "";
        ArrayList<String> temp = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get("src/model/geekoutAnswers.txt"))) {
            if ((num % 6) == 1){
                temp = new ArrayList<>();
                key = line;
            }else{
                System.out.println(key);
                temp.add(line);
                ans.put(key, temp);
            }
            num++;
        }
    }

}
