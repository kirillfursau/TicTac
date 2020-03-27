package service.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldDao field;

    @Override
    public void restartGame() {
        for (int i = 0; i < field.getFieldValues().length; i++) {
            for (int j = 0; j < field.getFieldValues()[i].length; j++) {
                field.getFieldValues()[i][j] = null;
            }
        }
    }

    @Override
    public FieldValue getNowFigure() {
        if (Arrays.stream(field.getFieldValues())
                .flatMap(e -> Stream.of(e)
                        .filter(el -> el != null))
                .count() % 2 == 0) {
            return FieldValue.O;
        }
        return FieldValue.X;
    }

    @Override
    public FieldValue getNextFigure() {
        if (getNowFigure() == FieldValue.O) {
            return FieldValue.X;
        }
        return FieldValue.O;
    }

    @Override
    public void makeMove(int x, int y) {
        field.setFigure(x, y, getNextFigure());
    }

    @Override
    public boolean isFieldFull() {
        return Arrays.stream(field.getFieldValues())
                .flatMap(e -> Stream.of(e)
                        .filter(el -> el == null))
                .count() == 0;
    }

    @Override
    public String getWinner() {
        return getNowFigure().toString();

    }

    @Override
    public boolean isWinnerExist() {
        return (checkVerticals(getNowFigure()) || checkHorizontals(getNowFigure()) || checkDiagonals(getNowFigure()));
    }

    @Override
    public boolean checkVerticals(FieldValue fieldValue) {
        for (int p = 0; p < 3; p++) {
            if ((field.getFigure(p, 0) == fieldValue && field.getFigure(p, 1) == fieldValue &&
                    field.getFigure(p, 2) == fieldValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkHorizontals(FieldValue fieldValue) {
        for (int p = 0; p < 3; p++) {
            if ((field.getFigure(0, p) == fieldValue && field.getFigure(1, p) == fieldValue &&
                    field.getFigure(2, p) == fieldValue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDiagonals(FieldValue fieldValue) {
        return ((field.getFigure(0, 0) == fieldValue &&
                field.getFigure(1, 1) == fieldValue &&
                field.getFigure(2, 2) == fieldValue)
                ||
                (field.getFigure(2, 0) == fieldValue &&
                field.getFigure(1, 1) == fieldValue &&
                field.getFigure(0, 2) == fieldValue));
    }
}
