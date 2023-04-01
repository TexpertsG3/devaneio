package br.com.hotel.devaneio.controller;

import br.com.hotel.devaneio.model.Contato;
import br.com.hotel.devaneio.model.Hospede;
import br.com.hotel.devaneio.model.dto.HospedeAtualizaInputDTO;
import br.com.hotel.devaneio.model.dto.HospedeInputDTO;
import br.com.hotel.devaneio.model.dto.HospedeOutputDTO;
import br.com.hotel.devaneio.repository.ContatoDAO;
import br.com.hotel.devaneio.repository.HospedeDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/hotel")
public class HospedeController {
    @Autowired
    private ContatoDAO contatoDAO;
    @Autowired

    private HospedeDAO hospedeDAO;
    @GetMapping("/cadastraHospede")
    public String cadastraHospede(Model model, HospedeInputDTO hospedeInputDTO) {
        model.addAttribute("hospedeInputDTO", hospedeInputDTO);
        return "form-hospede";
    }

    @Transactional
    @PostMapping("/persisteHospede")
    public String persisteHospede(@Valid HospedeInputDTO hospedeInputDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return cadastraHospede(model, hospedeInputDTO);
        }
        Contato contato = new Contato(hospedeInputDTO.getEmail(), hospedeInputDTO.getTelefone(), hospedeInputDTO.getCelular());
        this.contatoDAO.cadastra(contato);
        Hospede hospede = new Hospede(hospedeInputDTO.getNome(), hospedeInputDTO.getSobrenome(), hospedeInputDTO.getCpf(), hospedeInputDTO.getSenha(), contato);
        this.hospedeDAO.cadastraHospede(hospede);

        return "redirect:/hotel/listaHospedes";
    }

    @GetMapping("/listaHospedes")
    public String listaHospedes(Model model) {
        List<HospedeOutputDTO> hospedeDTO = hospedeDAO.lista();
        model.addAttribute("hospedes", hospedeDTO);
        return "lista-hospedes";
    }

    @GetMapping("/deletaHospede")
    public String deletaHospede(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        this.hospedeDAO.deletaHospede(id);
        redirectAttributes.addFlashAttribute("deletado","hospede deletado com sucesso.");
        return "redirect:/hotel/listaHospedes";
    }

    @GetMapping("/updateHospede")
    public String updateHospede(@RequestParam("id") Long id, Model model ){

        model.addAttribute("hospede", this.hospedeDAO.buscaHospede(id));

        return "update-hospede";
    }

    @PostMapping("/atualizaHospede")
    @Transactional
    public String atualizaHospede(HospedeAtualizaInputDTO hospedeAtualizaInputDTO, RedirectAttributes redirectAttributes){
        Hospede hospede = this.hospedeDAO.buscaHospede(hospedeAtualizaInputDTO.getIdHospede());

        hospede.setNome(hospedeAtualizaInputDTO.getNome());
        hospede.setSobrenome(hospedeAtualizaInputDTO.getSobrenome());
        hospede.setCpf(hospedeAtualizaInputDTO.getCpf());
        hospede.setSenha(hospedeAtualizaInputDTO.getSenha());
        hospede.getContato().setEmail(hospedeAtualizaInputDTO.getEmail());
        hospede.getContato().setTelefone(hospedeAtualizaInputDTO.getTelefone());
        hospede.getContato().setCelular(hospedeAtualizaInputDTO.getCelular());


        redirectAttributes.addFlashAttribute("atualizaHospede", "Sucesso na atualização dos dados.");


        return "redirect:/hotel/listaHospedes";
}}
