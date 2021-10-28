package Classes;

import Classes.BackendGameBoard;
import Classes.Gui;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FontFormatException {
        new Gui();
        new BackendGameBoard();
    }
}
