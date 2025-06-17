package com.lp2.projeto_sistemacursos.controller;

import com.lp2.projeto_sistemacursos.model.Area;
import com.lp2.projeto_sistemacursos.service.AreaService;
import com.lp2.projeto_sistemacursos.service.ProfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lp2.projeto_sistemacursos.model.Professor;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProfService profService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/professores", method = RequestMethod.GET)
    public ModelAndView getProfessor(){
        ModelAndView mv = new ModelAndView("professores");
        List<Professor> professores = profService.findAll();
        mv.addObject("professores", professores);
        mv.addObject("professor", new Professor());

        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public String getCursos(){
        return "cursos";
    }

    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public ModelAndView getAreas(){
        ModelAndView mv = new ModelAndView("areas");
        List<Area> areas = areaService.findAll();
        mv.addObject("areas", areas);
        mv.addObject("area", new Area());
        return mv;
    }

    @PostMapping(value = "/novoprofessor")
    public String saveProfessor(@Valid Professor professor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("openModal", true);
            List<Professor> professores = profService.findAll();
            model.addAttribute("professores", professores);
            return "professores";
        }

        profService.save(professor);
        return "redirect:/professores";
    }

    @PostMapping(value = "/novaarea")
    public String saveArea(@Valid Area area, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("openModal", true);
            List<Area> areas = areaService.findAll();
            model.addAttribute("areas", areas);
            return "areas";
        }

        areaService.save(area);
        return "redirect:/areas";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
