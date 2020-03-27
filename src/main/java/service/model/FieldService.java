package service.model;


public interface FieldService {
    FieldDao getField();

    FieldValue getNextFigure();

    FieldValue getNowFigure();

    void makeMove(int x, int y);

    boolean isFieldFull();

    String getWinner();

    boolean isWinnerExist();

    boolean checkVerticals(FieldValue fieldValue);

    boolean checkHorizontals(FieldValue fieldValue);

    boolean checkDiagonals(FieldValue fieldValue);
}
