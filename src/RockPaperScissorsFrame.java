import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    //Panels//
    static JPanel TopPnl;
    static JPanel BtnPnl;
    static JPanel StatsPnl;
    static JPanel ResultsPnl;

    //BUTTONS//
    static  JButton RockBtn;
    static JButton PaperBtn;
    static JButton ScissorsBtn;
    static  JButton QuitBtn;

    //BTN PICTURES//
    static  ImageIcon RockIcon;
    static ImageIcon PaperIcon;
    static  ImageIcon ScissorsIcon;
    static ImageIcon QuitIcon;

    ///Stats//
    static  JLabel Player_Wins;
    static JLabel AI_WINS;
    static JLabel Ties;

    //ScrollPane/
    static JScrollPane ScrollPane;


    //GAME/
    String AIWins = "";
    String PlayerWins = "";


    //GAME STATS/
    static int playerWins = 0;
    static int AiWins = 0;
    static int ties = 0;


    //GAME MOVES/
    static final String ROCK = "ROCK";
    static final String PAPER = "PAPER";
    static final String SCISSORS = "SCISSORS";


    public static void main(String[] args)
    {
        JFrame Frame = new JFrame();
        JPanel Panel = new JPanel();
        JButton Buttoms = new JButton();

        Frame.setSize(650,650);
        Frame.setTitle("RPS GAME");
        Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Create panels
        TopPnl = new JPanel();
        BtnPnl = new JPanel();
        StatsPnl = new JPanel();
        ResultsPnl = new JPanel();

        //POSITION THE FRAME//
        Frame.add(BtnPnl,BorderLayout.NORTH);
        Frame.add(ResultsPnl,BorderLayout.CENTER);
        Frame.add(StatsPnl,BorderLayout.SOUTH);




        //Create buttons WITH PICS///
        RockIcon = new ImageIcon(new ImageIcon("PICS/ROCK.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        PaperIcon = new ImageIcon(new ImageIcon("PICS/Paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        ScissorsIcon = new ImageIcon(new ImageIcon("PICS/scissors.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        QuitIcon = new ImageIcon(new ImageIcon("PICS/Quit.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));




        //Create buttons// with actions

        RockBtn = new JButton( RockIcon);
        RockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will execute when the Rock button is clicked
                String playerMove = ROCK; // set player's move to ROCK
                // Call a method to process the player's move and generate the AI's move
                // and update the game statistics and results
                processMoves(playerMove, generateAIMove(), ResultsPnl);
            }
        });



        PaperBtn = new JButton(PaperIcon);
        PaperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will execute when the Paper button is clicked
                String playerMove = PAPER; // set player's move to PAPER
                // Call a method to process the player's move and generate the AI's move
                // and update the game statistics and results
                processMoves(playerMove, generateAIMove(), ResultsPnl);
            }
        });







        PaperBtn = new JButton(PaperIcon);
        PaperBtn = new JButton(PaperIcon);
        PaperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will execute when the Paper button is clicked
                String playerMove = PAPER; // set player's move to PAPER
                // Call a method to process the player's move and generate the AI's move
                // and update the game statistics and results
                processMoves(playerMove, generateAIMove(), ResultsPnl);
            }
        });



        ScissorsBtn = new JButton(ScissorsIcon);
        ScissorsBtn = new JButton(ScissorsIcon);
        ScissorsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will execute when the Scissors button is clicked
                String playerMove = SCISSORS; // set player's move to SCISSORS
                // Call a method to process the player's move and generate the AI's move
                // and update the game statistics and results
                processMoves(playerMove, generateAIMove(), ResultsPnl);
            }
        });

// Add Scissors button to top panel
        TopPnl.add(ScissorsBtn);



        QuitBtn = new JButton( QuitIcon);
        QuitBtn.addActionListener((ActionEvent e) -> {System.exit(0);});





        ///RESULTS PANE// JSCROLL//
        JTextArea ResultsArea = new JTextArea();
        ResultsArea.setFont(new Font("Arial", Font.PLAIN,14));
        ScrollPane = new JScrollPane(ResultsArea);
        //Resing the TextArea//
        ResultsArea.setPreferredSize(new Dimension(600, 400));





        ///STATS////
        //PLAYER WIN///
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.X_AXIS));
        JLabel textLabel = new JLabel("PLAYER WIN: ");
        textLabel.setPreferredSize(new Dimension(100, 50));
        statsPanel.add(Box.createHorizontalStrut(10)); // Add a horizontal gap of 10 pixels
        statsPanel.add(textLabel);

        ///STATS//
        //COMPUTER WIN//
        JPanel COMPstatsPanel = new JPanel();
        COMPstatsPanel.setLayout(new BoxLayout(COMPstatsPanel,BoxLayout.X_AXIS));
        JLabel COMPTextLabel = new JLabel("AI WINS: ");
        COMPTextLabel.setPreferredSize(new Dimension(100,50));
        COMPstatsPanel.add(Box.createHorizontalStrut(10)); // Add a horizontal gap of 10 pixels
        COMPstatsPanel.add(COMPTextLabel);


        ///STATS//
        //TIES//
        JPanel TIEStatsPanel = new JPanel();
        TIEStatsPanel.setLayout(new BoxLayout(TIEStatsPanel,BoxLayout.X_AXIS));
        JLabel TIETextLabel = new JLabel("TIES: ");
        TIETextLabel.setPreferredSize(new Dimension(100,50));
        TIEStatsPanel.add(Box.createHorizontalStrut(10)); // Add a horizontal gap of 10 pixels
        TIEStatsPanel.add(TIETextLabel);







        //Add buttons to top panel
        TopPnl.add(RockBtn);
        TopPnl.add(PaperBtn);
        TopPnl.add(ScissorsBtn);
        TopPnl.add(QuitBtn);

        //Add top panel to button panel
        BtnPnl.add(TopPnl);
        ResultsPnl.add(ScrollPane);
        StatsPnl.add(statsPanel);
        StatsPnl.add(textLabel);
        StatsPnl.add(COMPTextLabel);
        StatsPnl.add(TIETextLabel);





        Frame.setVisible(true);

    }

    public static void processMoves(String playerMove, JPanel resultsPanel) {
        String result;

        // Generate a random move for the computer
        String aiMove = getRandomMove();

        if (playerMove.equals(aiMove)) { // if player and AI moves are the same
            result = "Tie game! Both chose " + playerMove + ".";
            ties++;
        } else if ((playerMove.equals(ROCK) && aiMove.equals(SCISSORS)) || (playerMove.equals(PAPER) && aiMove.equals(ROCK)) || (playerMove.equals(SCISSORS) && aiMove.equals(PAPER))) {
            // if player wins
            result = "You win! " + playerMove + " beats " + aiMove + ".";
            playerWins++;
        } else { // if AI wins
            result = "AI wins! " + aiMove + " beats " + playerMove + ".";
            AiWins++;
        }

        // update game statistics
        Player_Wins.setText("Player wins: " + playerWins);
        AI_WINS.setText("AI wins: " + AiWins);
        Ties.setText("Ties: " + ties);

        // add the result to the results panel
        JTextArea resultsArea = (JTextArea) ScrollPane.getViewport().getView();
        resultsArea.append(result + "\n");
        resultsArea.setCaretPosition(resultsArea.getDocument().getLength());
    }

    // Helper method to generate a random move for the computer
    private static String getRandomMove() {
        Random random = new Random();
        int move = random.nextInt(3);
        if (move == 0) {
            return ROCK;
        } else if (move == 1) {
            return PAPER;
        } else {
            return SCISSORS;
        }
    }







}
