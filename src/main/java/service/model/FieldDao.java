package service.model;

public interface FieldDao {
    public FieldValue getFigure(int x, int y);

    public void setFigure(int x, int y, FieldValue fieldValueEnter);

    public FieldValue[][] getFieldValues();

}
