package service.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class FieldDaoImpl implements FieldDao {
    private FieldValue[][] fieldValues;

    public FieldValue getFigure(int x, int y) {
        return fieldValues[x][y];
    }

    public void setFigure(int x, int y, FieldValue fieldValueEnter) {
        fieldValues[x][y] = fieldValueEnter;
    }

    public FieldValue[][] getFieldValues() {
        return fieldValues;
    }



    @PostConstruct
    public void init() {
        fieldValues = new FieldValue[3][3];
    }
}
