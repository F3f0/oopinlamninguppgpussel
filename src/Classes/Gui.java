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

    JPanel controls = new JPanel();
    JPanel gameBoard = new JPanel();
    JButton newGame = new JButton("New Game");
    BufferedImage myPicture = ImageIO.read(new File("src/images.png"));
    JLabel pic = new JLabel(new ImageIcon(myPicture));
    int buttons = 4;
    JButton[] arrayButton = new JButton[buttons * buttons];

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
        System.out.println(event.paramString());

        if (event.getSource() == newGame)
            System.out.println("NewGame");
        if (event.getSource() == arrayButton[1])
            System.out.println("1");
    }
}