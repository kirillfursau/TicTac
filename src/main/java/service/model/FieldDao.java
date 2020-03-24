package service.model;

public interface FieldDao {
    public Figure getFigure(int x, int y);

    public void setFigure(int x, int y, Figure figureEnter);

    public Figure[][] getFigures();

    public Figure[][] makeFieldEmpty();
}
