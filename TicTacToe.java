import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {

    //Declaring instances for what we need to control the game and see it visually.
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){
        //frame of GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //tEXT IN GUI
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,90,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        //title_panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //BUTTON_PANEL
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//This snippet of code performs the action user takes while the code process it and execute the users demand
        for(int i = 0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X Turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {
//Try and catch, this will Display "Tic Tac Toe" at the top and then who starts first
        //THis code snippet will determine who will go first
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2)==0) {
            player1_turn=true;
            textField.setText("X turn");
        }
        else{
            player1_turn=false;
            textField.setText("O turn");
        }
    }
    //we want to see if this rows for the winner line up or if they do not
    public void check(){
        //Check x win condtions
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
                        ) {
            xWins(0,1,2);
        }
        //check o win condtions
        if(
                        (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }
        if(
                        (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                        (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }
        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }
        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
//check o win condtions
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }

        if(
                        (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }
        if(
                        (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                        (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }
        if(
                        (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }
        if(
                        (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }
    }



    public void xWins(int a,int b,int c){

        //Need to indicate that player X has won
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X Win");

    }

    public void oWins(int a,int b,int c){

        //Need to indicate that player O has won

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O Win");
    }

}
