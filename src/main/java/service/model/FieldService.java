package service.model;


public interface FieldService {
    FieldDaoImpl getField();

    Figure getNextFigure();

    Figure getNowFigure();

    void makeMove(int x, int y);

    boolean isFieldFull();

    String getWinner();

    boolean isFindWinner();

    boolean checkVerticals(Figure figure);

    boolean checkHorizontals(Figure figure);

    boolean checkDiagonals(Figure figure);
}
