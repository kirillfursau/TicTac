package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.model.FieldService;
import service.model.FieldServiceImpl;


@Controller
public class GameController {
    private final FieldService fieldService;

    @Autowired
    public GameController(FieldServiceImpl fieldServiceImpl) {
        this.fieldService = fieldServiceImpl;
    }

    @GetMapping(path = "/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "/draw")
    public String getPathVariable(Model model) {
        model.addAttribute("fields", fieldService.getField().getFigures());
        return "game-field";
    }

    @GetMapping(path = "/step/{i}/{j}")
    public String getNextStep(Model model, @PathVariable int i, @PathVariable int j) {
        fieldService.makeMove(i, j);
        if (fieldService.isFieldFull() && !fieldService.isFindWinner()) {
            fieldService.getField().makeFieldEmpty();
            return "restart";
        } else if (fieldService.isFindWinner()) {
            model.addAttribute("winner", fieldService.getWinner());
            fieldService.getField().makeFieldEmpty();
            return "winner";
        }
        model.addAttribute("fields", fieldService.getField().getFigures());
        return "game-field";
    }
}
