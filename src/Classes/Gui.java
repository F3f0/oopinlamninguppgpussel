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
        controls.add(newGame);
        controls.setBackground(Color.WHITE);
        controls.add(pic);
        newGame.addActionListener(this);
        newGame.setFont(Gui.scaryFont());
        newGame.setBackground(Color.orange);
        newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setLocation(400, 100);
        setSize(400, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Gui.winningPic();
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

    @Override
    public void actionPerformed(ActionEvent event) {
        //System.out.println(event.paramString());
        if (event.getSource() == newGame){
            backend.ShuffleBoard();
            System.out.println("NewGame");
        }
        if (event.getSource() == arrayButton[0]){
            if (backend.LegalMove(0) != -1) {
                backend.MovePiece(0, backend.pieces.get(backend.LegalMove(0)).getPosition());
                System.out.println("0");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[1]){
            if (backend.LegalMove(1) != -1) {
                backend.MovePiece(1, backend.pieces.get(backend.LegalMove(1)).getPosition());
                System.out.println("1");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[2]){
            if (backend.LegalMove(2) != -1) {
                backend.MovePiece(2, backend.pieces.get(backend.LegalMove(2)).getPosition());
                System.out.println("2");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[3]){
            if (backend.LegalMove(3) != -1) {
                backend.MovePiece(3, backend.pieces.get(backend.LegalMove(3)).getPosition());
                System.out.println("3");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[4]){
            if (backend.LegalMove(4) != -1) {
                backend.MovePiece(4, backend.pieces.get(backend.LegalMove(4)).getPosition());
                System.out.println("4");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[5]){
            if (backend.LegalMove(5) != -1) {
                backend.MovePiece(5, backend.pieces.get(backend.LegalMove(5)).getPosition());
                System.out.println("5");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[6]){
            if (backend.LegalMove(6) != -1) {
                backend.MovePiece(6, backend.pieces.get(backend.LegalMove(6)).getPosition());
                System.out.println("6");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[7]){
            if (backend.LegalMove(7) != -1) {
                backend.MovePiece(7, backend.pieces.get(backend.LegalMove(7)).getPosition());
                System.out.println("7");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[8]){
            if (backend.LegalMove(8) != -1) {
                backend.MovePiece(8, backend.pieces.get(backend.LegalMove(8)).getPosition());
                System.out.println("8");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[9]){
            if (backend.LegalMove(9) != -1) {
                backend.MovePiece(9, backend.pieces.get(backend.LegalMove(9)).getPosition());
                System.out.println("9");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[10]){
            if (backend.LegalMove(10) != -1) {
                backend.MovePiece(10, backend.pieces.get(backend.LegalMove(10)).getPosition());
                System.out.println("10");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[11]){
            if (backend.LegalMove(11) != -1) {
                backend.MovePiece(11, backend.pieces.get(backend.LegalMove(11)).getPosition());
                System.out.println("11");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[12]){
            if (backend.LegalMove(12) != -1) {
                backend.MovePiece(12, backend.pieces.get(backend.LegalMove(12)).getPosition());
                System.out.println("12");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[13]){
            if (backend.LegalMove(13) != -1) {
                backend.MovePiece(13, backend.pieces.get(backend.LegalMove(13)).getPosition());
                System.out.println("13");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[14]){
            if (backend.LegalMove(14) != -1) {
                backend.MovePiece(14, backend.pieces.get(backend.LegalMove(14)).getPosition());
                System.out.println("14");
            }
            System.out.println(backend.pieces.toString());
        }
        if (event.getSource() == arrayButton[15]){
            if (backend.LegalMove(15) != -1) {
                backend.MovePiece(15, backend.pieces.get(backend.LegalMove(15)).getPosition());
                System.out.println("15");
            }
            System.out.println(backend.pieces.toString());
        }
    }
}