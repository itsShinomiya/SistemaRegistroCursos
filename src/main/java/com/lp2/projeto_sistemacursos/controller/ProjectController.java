package com.lp2.projeto_sistemacursos.controller;

import com.lp2.projeto_sistemacursos.model.Area;
import com.lp2.projeto_sistemacursos.model.Curso;
import com.lp2.projeto_sistemacursos.service.AreaService;
import com.lp2.projeto_sistemacursos.service.CursoService;
import com.lp2.projeto_sistemacursos.service.ProfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.lp2.projeto_sistemacursos.model.Professor;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    ProfService profService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private CursoService cursoService;

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
    public ModelAndView getCursos(){
        ModelAndView mv = new ModelAndView("cursos");
        List<Curso> cursos = cursoService.findAll();
        mv.addObject("cursos", cursos);
        mv.addObject("curso", new Curso());
        mv.addObject("professores", profService.findAll());
        mv.addObject("areas", areaService.findAll());

        return mv;
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

    @PostMapping(value = "/novocurso")
    public String saveCurso(@Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("openModal", true);
            model.addAttribute("cursos", cursoService.findAll());
            model.addAttribute("professores", profService.findAll());
            model.addAttribute("areas", areaService.findAll());
            return "cursos";
        }
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @PostMapping(value = "/editcurso")
    public String editCurso(@Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("openEditModal", true);
            model.addAttribute("cursos", cursoService.findAll());
            model.addAttribute("professores", profService.findAll());
            model.addAttribute("areas", areaService.findAll());
            model.addAttribute("curso", curso);

            return "cursos";
        }
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
