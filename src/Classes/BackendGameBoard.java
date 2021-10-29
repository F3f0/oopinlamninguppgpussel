package Classes;

import java.util.ArrayList;
import java.util.Collections;

public class BackendGameBoard {
    ArrayList<Piece> pieces = new ArrayList<>();
    int boardSize = 4; // width and height of board

    public BackendGameBoard() {
        for (int i = 0; i < boardSize * boardSize; i++) {
            pieces.add(new Piece(i, 0));
        }
        ShuffleBoard();
    }

    public void ShuffleBoard() {
        Collections.shuffle(pieces);
        for (int i = 0; i < pieces.size(); i++) {
            pieces.get(i).setPosition(i);
        }
        System.out.println(pieces);
    }

    public void MovePiece(int positionTo, int positionFrom) {
        for (Piece piece : pieces) {
            if (piece.getPosition() == positionTo) {
                piece.setPosition(positionFrom);
            }
        }
        pieces.get(positionFrom).setPosition(positionTo);
    }

    public int LegalMove(int positionFrom) {
        //find empty space
        int emptyPiecePosition = -1;
        for (Piece piece : pieces) {
            if (piece.getValue() == 0) {
                emptyPiecePosition = piece.getPosition();
            }
        }
        //check legal move (+-boardWidth / +-1 position)
        if (positionFrom == emptyPiecePosition - 1 || positionFrom == emptyPiecePosition + 1 || positionFrom == emptyPiecePosition + boardSize || positionFrom == emptyPiecePosition - boardSize) {
            return emptyPiecePosition;
        }
        return -1;
    }

    public void SolveGame() {
        for (Piece piece : pieces) {
            piece.setValue(piece.getPosition());
            //update game board
        }
    }

    public boolean GameWon() {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getPosition() != i || pieces.get(i).getValue() != i) {
                return false;
            }
        }
        return true;
    }
}
