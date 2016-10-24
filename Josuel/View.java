package view;
import model.Model;
import model.Question;
//import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import static view.Constants.WINDOW_HEIGHT;
import static view.Constants.WINDOW_WIDTH;

/**
 * Created by elizabethsengoba on 10/19/16.
 */

public class View extends JFrame {
    private Model model;
    private HomePanel homePanel = new HomePanel();
    private BackgroundPanel backgroundPanel = new BackgroundPanel();
    private CategoryPanel categoryPanel = new CategoryPanel();
    private ReadyPanel readyPanel = new ReadyPanel();
    private JPanel lastPage = new JPanel();
    private QuestionPanel questionPanel = new QuestionPanel();
    JLayeredPane layered = new JLayeredPane();


    public View() throws IOException {

        model = new Model();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Name that Thing! -- Home");

        //p.setLayout(null);
        layered.add(homePanel);
        layered.add(backgroundPanel);
        //layered.add(new HomePanel());
       //layered.add(new BackgroundPanel());
        setLayout(new BorderLayout());
        add(layered, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//making the frame visible

    }

    public HomePanel getHomePanel() { return homePanel;}
    public BackgroundPanel getBackgroundPanel() { return backgroundPanel;}

    public class HomePanel extends JPanel implements ActionListener{
        private boolean isStartScreen;
        public HomePanel(){
            //Add buttons
            super();
            setTitle("Name that Thing! -- Home");

            //set layout for the home panel
            setLayout(new GridLayout(6,1));

            setOpaque(false);
            setBounds(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            add(createButtonWithFont(Constants.START));
            add(createButtonWithFont(Constants.SETTINGS));
            add(createButtonWithFont(Constants.LEADERBOARD));

        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (isStartScreen){
                //Don't do anything on the start screen
                return;
            }
        }

    }


    public class BackgroundPanel extends JPanel implements ActionListener{
        private boolean isStartScreen;
        public BackgroundPanel(){
            setBounds(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            setOpaque(true);
            isStartScreen = true;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if (isStartScreen){
                //Don't do anything on the start screen
                return;
            }
        }
    @Override
       public void paint(Graphics g){
            super.paint(g);
           //Create background
             g.setColor(Color.DARK_GRAY);
             g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

       }

    }

    public class CategoryPanel extends JPanel implements ActionListener{
        private boolean isStartScreen;
        public CategoryPanel(){
            //Add buttons
            super();

            setOpaque(false);
            setBounds(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            setLayout(new GridLayout(7,1));
            add(createButtonWithFont("GEEK OUT"));
            add(createButtonWithFont("EARLY 2000s JAMS"));
            add(createButtonWithFont("HOT GUY CINEMA"));
            add(createButtonWithFont("RATCHET FACTS"));
            add(createButtonWithFont("FOODIE"));
            add(createButtonWithFont("BACK"));

        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (isStartScreen){

                //Don't do anything on the start screen
                return;
            }
        }

    }

    public class ReadyPanel extends JPanel implements ActionListener{
        private boolean isStartScreen;
        public ReadyPanel(){
            //Add buttons
            super();

            setOpaque(false);
            setBounds(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            setLayout(new GridLayout(7,1));
            /* Will need to print a label to the SCREEN*/
            add(createButtonWithFont(Constants.READY));
            add(createButtonWithFont(Constants.BACK));

        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (isStartScreen){
                //Don't do anything on the start screen
                return;
            }
        }

    }

    public class QuestionPanel extends JPanel implements ActionListener{
        private boolean isStartScreen;
        public QuestionPanel(){
            //Add buttons
            super();

            setOpaque(false);
            setBounds(0,0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            setLayout(new GridLayout(7,1));
            add(createButtonWithFont("A"));
            add(createButtonWithFont("B"));
            add(createButtonWithFont("C"));
            add(createButtonWithFont("D"));


        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (isStartScreen){

                //Don't do anything on the start screen
                return;
            }
        }

    }

    public JButton createButtonWithFont(String text){
        JButton button = new JButton(text);
        button.setFont(Constants.BUTTON_FONT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    switch (text) {
                        case Constants.START: // do nothing
                            //update my layers
                            //display category Panel
                            setTitle("Name that Thing! -- Category Selection");
                            layered.removeAll();
                            layered.add(categoryPanel);
                            layered.add(backgroundPanel);
                            layered.repaint();
                            break;

                        case Constants.SETTINGS:
                            break;

                        case Constants.LEADERBOARD:
                            break;
                        case "GEEK OUT":
                            layered.removeAll();
                            layered.add(readyPanel);
                            layered.add(backgroundPanel);
                            break;
                        case Constants.READY:
                            layered.removeAll();
                            layered.add(questionPanel);
                            layered.add(backgroundPanel);

                            break;
                        case Constants.BACK:
                            setTitle("Name that Thing! -- Home");
                            /*Implement to return to the last visited panel*/

                            layered.removeAll();
                            layered.add(homePanel);
                            layered.add(backgroundPanel);
                            layered.repaint();


                        default:
                            break;
                    }}

        });

        return button;
    }


    public static void main(String[] args) throws IOException {
        View v = new View();
    }
}
