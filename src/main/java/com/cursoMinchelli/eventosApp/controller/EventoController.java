package com.cursoMinchelli.eventosApp.controller;

import com.cursoMinchelli.eventosApp.model.Evento;
import com.cursoMinchelli.eventosApp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento"; // renderiza o template formEvento.html
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento){
        repository.save(evento);
        return "redirect:/cadastrarEvento"; // redireciona para a rota /cadastrarEvento
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos (){
        ModelAndView mv = new ModelAndView("/index");
        Iterable<Evento> eventos = repository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }
}