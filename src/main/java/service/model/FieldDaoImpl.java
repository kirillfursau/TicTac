package service.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class FieldDaoImpl implements FieldDao {
    private Figure[][] figures;

    public Figure getFigure(int x, int y) {
        return figures[x][y];
    }

    public void setFigure(int x, int y, Figure figureEnter) {
        figures[x][y] = figureEnter;
    }

    public Figure[][] getFigures() {
        return figures;
    }

    public Figure[][] makeFieldEmpty() {
        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < figures[i].length; j++) {
                figures[i][j] = null;
            }
        }
        return figures;
    }

    @PostConstruct
    public void init() {
        figures = new Figure[3][3];
    }
}
