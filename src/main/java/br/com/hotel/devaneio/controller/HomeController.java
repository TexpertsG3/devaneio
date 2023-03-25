package br.com.hotel.devaneio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/homeAdmin")
public class HomeController {

    //Exemplo de modelos -  Banco: ContaCorrente, Cliente, Agência, Banco, Funcionarios, ClienteDAO, ClienteRepository,
    // ClienteService

    @GetMapping
    public ModelAndView homeAdmin() {
        ModelAndView modelAndView = new ModelAndView();

        String teste = "Teste de conexão";

        modelAndView.addObject("homeAdmin", teste);

        return modelAndView;
    }

    @GetMapping("/createAdmin")
    public String createAdmin(){
        System.out.println("Direcionando para a página de criação de admin");

        return "form-admin";
    }


}

