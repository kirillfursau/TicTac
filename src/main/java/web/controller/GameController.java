package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.model.FieldDao;
import service.model.FieldService;
import service.model.FieldServiceImpl;


@Controller
public class GameController {
    private final FieldService fieldService;
    private final FieldDao fieldDao;

    @Autowired
    public GameController(FieldServiceImpl fieldServiceImpl, FieldDao fieldDao) {
        this.fieldService = fieldServiceImpl;
        this.fieldDao = fieldDao;
    }

    @GetMapping(path = "/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "/draw")
    public String getPathVariable(Model model) {
        model.addAttribute("fields", fieldDao.getFieldValues());
        return "game-field";
    }

    @GetMapping(path = "/step/{i}/{j}")
    public String getNextStep(Model model, @PathVariable int i, @PathVariable int j) {
        fieldService.makeMove(i, j);
        if (fieldService.isFieldFull() && !fieldService.isWinnerExist()) {
            fieldService.restartGame();
            return "winner";
        } else if (fieldService.isWinnerExist()) {
            model.addAttribute("winner", fieldService.getWinner());
            fieldService.restartGame();
            return "winner";
        }
        model.addAttribute("fields", fieldDao.getFieldValues());
        return "redirect:/draw";
    }
}
