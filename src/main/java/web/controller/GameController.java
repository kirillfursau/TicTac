package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.model.FieldServiceImpl;


@Controller
public class GameController {
    private final FieldServiceImpl fieldServiceImpl;

    @Autowired
    public GameController(FieldServiceImpl fieldServiceImpl) {
        this.fieldServiceImpl = fieldServiceImpl;
    }

    @GetMapping(path = "/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "/draw")
    public String getPathVariable(Model model) {
        model.addAttribute("fields", fieldServiceImpl.getField().getFigures());
        return "game-field";
    }

    @GetMapping(path = "/step/{i}/{j}")
    public String getNextStep(Model model, @PathVariable int i, @PathVariable int j) {
        fieldServiceImpl.makeMove(i, j);
        if (fieldServiceImpl.isFull() && !fieldServiceImpl.isFindWinner()) {
            fieldServiceImpl.getField().makeEmpty();
            return "restart";
        } else if (fieldServiceImpl.isFindWinner()) {
            model.addAttribute("winner", fieldServiceImpl.getWinner());
            fieldServiceImpl.getField().makeEmpty();
            return "winner";
        }
        model.addAttribute("fields", fieldServiceImpl.getField().getFigures());
        return "game-field";
    }
}
