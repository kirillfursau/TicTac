package service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class FieldServiceImpl implements FieldService {
    private FieldDao field;

    @Autowired
    public FieldServiceImpl(FieldDao field) {
        this.field = field;
    }

    public FieldDao getField() {
        return field;
    }

    @Override
    public Figure getNextFigure() {
        if (Arrays.stream(field.getFigures())
                .flatMap(e -> Stream.of(e)
                        .filter(el -> el != null))
                .count() % 2 == 0) {
            return Figure.X;
        }
        return Figure.O;
    }

    @Override
    public Figure nowFigure() {
        if (Arrays.stream(field.getFigures())
                .flatMap(e -> Stream.of(e)
                        .filter(el -> el != null))
                .count() % 2 == 0) {
            return Figure.O;
        }
        return Figure.X;
    }

    @Override
    public void makeMove(int x, int y) {
        if (field.getFigure(x, y) != Figure.X && field.getFigure(x, y) != Figure.O) {
            field.setFigure(x, y, getNextFigure());
        }
    }

    @Override
    public boolean isFull() {
        return Arrays.stream(field.getFigures())
                .flatMap(e -> Stream.of(e)
                        .filter(el -> el == null))
                .count() == 0;
    }

    @Override
    public String getWinner() {
        if (getNextFigure() == Figure.O) {
            return "X";
        } else {
            return "O";
        }

    }

    @Override
    public boolean isFindWinner() {
        if (checkVerticals(nowFigure()) || checkHorizontals(nowFigure()) || checkDiagonals(nowFigure())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkVerticals(Figure figure) {
        for (int p = 0; p < 3; p++) {
            if ((field.getFigure(p, 0) == figure && field.getFigure(p, 1) == figure &&
                    field.getFigure(p, 2) == figure)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkHorizontals(Figure figure) {
        for (int p = 0; p < 3; p++) {
            if ((field.getFigure(0, p) == figure && field.getFigure(1, p) == figure &&
                    field.getFigure(2, p) == figure)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDiagonals(Figure figure) {
        if ((field.getFigure(0, 0) == figure && field.getFigure(1, 1)
                == figure && field.getFigure(2, 2) == figure) ||
                (field.getFigure(2, 0) == figure && field.getFigure(1, 1)
                        == figure && field.getFigure(0, 2) == figure)) {
            return true;
        }
        return false;
    }
}
