package com.cursoMinchelli.eventosApp.controller;

import com.cursoMinchelli.eventosApp.model.Evento;
import com.cursoMinchelli.eventosApp.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    @RequestMapping("/{id}")
    public ModelAndView detalhesEvento(@PathVariable("id") long id){
        Evento evento = repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
    }
}