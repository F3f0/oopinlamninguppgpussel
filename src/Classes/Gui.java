package Classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gui extends JFrame implements ActionListener {
    BackendGameBoard backend = new BackendGameBoard();
    JPanel controls = new JPanel();
    JPanel gameBoard = new JPanel();
    JButton newGame = new JButton("New Game");
    JButton solution = new JButton("Solution");
    BufferedImage myPicture = ImageIO.read(new File("src/images.png"));
    JLabel pic = new JLabel(new ImageIcon(myPicture));
    int buttons = 4;
    public JButton[] arrayButton = new JButton[buttons * buttons];

    Gui() throws IOException, FontFormatException {
        setLayout(new GridLayout(2, 1));
        add(gameBoard);
        add(controls);
        gameBoard.setLayout(new GridLayout(buttons, buttons));


        for (int i = 0; i < buttons * buttons; i++) {
            JButton button = new JButton(Integer.toString(i));
            arrayButton[i] = button;
            gameBoard.add(button);
            button.setForeground(Color.BLACK);
            button.setBackground(Color.MAGENTA);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            button.setFont(Gui.scaryFont());
            button.setBorderPainted(true);
            button.addActionListener(this);
        }

        controls.add(pic);
        controls.add(newGame);
        controls.add(solution);
        controls.setBackground(Color.WHITE);
        newGame.addActionListener(this);
        newGame.setFont(Gui.scaryFont());
        newGame.setBackground(Color.orange);
        newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        solution.addActionListener(this);
        solution.setFont(Gui.scaryFont());
        solution.setBackground(Color.orange);
        solution.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setLocation(400, 100);
        setSize(400, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        updateBoard();
    }

    static public void winningPic() {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel(new ImageIcon("src/Treisman-Scary-Stories.png"));
        dialog.add(label);
        dialog.setLocation(300, 25);
        dialog.pack();
        dialog.setVisible(true);
    }

    static Font scaryFont() throws IOException, FontFormatException {
        Font scaryFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Halloween Morning.ttf")).deriveFont(24f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(scaryFont);
        return scaryFont;
    }

    public void moveMethod(int positionFrom){
        backend.MovePiece(backend.LegalMove(positionFrom), positionFrom);
        updateBoard();
        if (backend.GameWon()){
            Gui.winningPic();
        }
        //arrayButton[0].setText(Integer.toString(backend.pieces.get(backend.LegalMove(positionFrom)).getPosition()));
        //arrayButton[backend.pieces.get(backend.LegalMove(positionFrom)).getPosition()].setText(Integer.toString(positionFrom));
        System.out.println(positionFrom);
    }

    public void updateBoard(){
        for (int i = 0; i < backend.pieces.size(); i++) {
            arrayButton[backend.pieces.get(i).getPosition()].setText(Integer.toString(backend.pieces.get(i).getValue()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //System.out.println(event.paramString());
        if (event.getSource() == solution){
            backend.SolveGame();
            updateBoard();
            System.out.println("solve");
        }
        if (event.getSource() == newGame){
            backend.ShuffleBoard();
            updateBoard();
            System.out.println("NewGame");
        }
        for(int i = 0; i < arrayButton.length; i++)
            if(event.getSource() == arrayButton[i])
                if (backend.LegalMove(i) != -1) {
                    moveMethod(i);
                }
    }
}