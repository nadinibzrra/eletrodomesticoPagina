package tads.eaj.ufrn.eletrodomesticopagina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tads.eaj.ufrn.eletrodomesticopagina.model.Eletrodomestico;
import tads.eaj.ufrn.eletrodomesticopagina.service.EletrodomesticoService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ControllerPagina {

    private EletrodomesticoService service;

    @Autowired
    public void setService(EletrodomesticoService service) {
        this.service = service;
    }

    @RequestMapping({"/", "/index"})
    public String getPage(Model model){
        List<Eletrodomestico> eletroLista = service.findAll();
        model.addAttribute("eletros", eletroLista);
        return "index";
    }

    @RequestMapping("/admin")
    public String getAdmin(Model model){
        List<Eletrodomestico> eletroLista = service.findAll();
        model.addAttribute("eletros", eletroLista);
        return "admin";
    }

    @RequestMapping("/cadastro")
    public String getFormCadastro(Model model){
        Eletrodomestico eletro = new Eletrodomestico();
        model.addAttribute("eletro", eletro);
        return "cadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute @Valid Eletrodomestico eletro, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/cadastro" ;
        }else{
            service.save(eletro);
            return "redirect:/";
        }

    }

    @RequestMapping("/deletar/{id}")
    public String doDelete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdicao(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edicao");
        Eletrodomestico eletro = service.getById(id);
        modelAndView.addObject("eletro", eletro);
        return modelAndView;
    }




}
