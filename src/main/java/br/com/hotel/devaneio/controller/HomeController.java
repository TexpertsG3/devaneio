package br.com.hotel.devaneio.controller;

import br.com.hotel.devaneio.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    //Exemplo de modelos -  Banco: ContaCorrente, Cliente, Agência, Banco, Funcionarios, ClienteDAO, ClienteRepository,
    // ClienteService

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();

        String teste = "Teste de conexão";

        modelAndView.addObject("home", teste);

        return modelAndView;
    }


//    @PostMapping("/um")
//    public String cadastraProdutos(){
//        System.out.println("Página Home");
//        return "home";
//    }
//
//    @PostMapping("/dois") //Aqui só acessa com o POST
//    public String cadastraProdutor(){
//        System.out.println("Página home2");
//        return "home2";
//    }
}

