package service.model;


public interface FieldService {
    Figure getNextFigure();

    Figure nowFigure();

    void makeMove(int x, int y);

    boolean isFull();

    String getWinner();

    boolean isFindWinner();

    boolean checkVerticals(Figure figure);

    boolean checkHorizontals(Figure figure);

    boolean checkDiagonals(Figure figure);
}
