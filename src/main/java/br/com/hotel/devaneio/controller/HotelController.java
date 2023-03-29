package br.com.hotel.devaneio.controller;

import br.com.hotel.devaneio.model.Contato;
import br.com.hotel.devaneio.model.DadosHotel;
import br.com.hotel.devaneio.model.Endereco;
import br.com.hotel.devaneio.model.Hotel;
import br.com.hotel.devaneio.model.dto.HotelAtualizaInputDTO;
import br.com.hotel.devaneio.model.dto.HotelInputDTO;
import br.com.hotel.devaneio.model.dto.HotelOutputDTO;
import br.com.hotel.devaneio.repository.ContatoDAO;
import br.com.hotel.devaneio.repository.DadosHotelDAO;
import br.com.hotel.devaneio.repository.EnderecoDAO;
import br.com.hotel.devaneio.repository.HotelDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private ContatoDAO contatoDAO;

    @Autowired
    private EnderecoDAO enderecoDAO;

    @Autowired
    private DadosHotelDAO dadosHotelDAO;

    @Autowired
    private HotelDAO hotelDAO;



    @GetMapping("/cadastra")
    public String cadastra(Model model, HotelInputDTO hotelInputDTO) {
        model.addAttribute("hotelInputDTO", hotelInputDTO);
        return "form-hotel";
    }

    @Transactional
    @PostMapping("/persiste")
    public String persiste(@Valid HotelInputDTO hotelInputDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return cadastra(model, hotelInputDTO);
        }
        Contato contato = new Contato(hotelInputDTO.getEmail(), hotelInputDTO.getTelefone(), hotelInputDTO.getCelular());
        this.contatoDAO.cadastra(contato);
        Endereco endereco = new Endereco(hotelInputDTO.getRua(), hotelInputDTO.getBairro(), hotelInputDTO.getNumero(), hotelInputDTO.getCep(),
                hotelInputDTO.getCidade(), hotelInputDTO.getUf(), hotelInputDTO.getComplemento());
        this.enderecoDAO.cadastra(endereco);
        DadosHotel dadosHotel = new DadosHotel(hotelInputDTO.getNome(), hotelInputDTO.getCnpj(), contato, endereco);
        this.dadosHotelDAO.cadastra(dadosHotel);
        Hotel hotel = new Hotel(dadosHotel);
        this.hotelDAO.cadastra(hotel);

        return "redirect:/hotel/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        List<HotelOutputDTO> hotelDTO = hotelDAO.lista();
        model.addAttribute("hoteis", hotelDTO);
        return "lista-hoteis";
    }

    @GetMapping("/deleta")
    public String deleta(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        this.hotelDAO.delete(id);
        redirectAttributes.addFlashAttribute("deletado","Hotel deletado com sucesso.");
        return "redirect:/hotel/lista";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("id") Integer id, Model model ){

        model.addAttribute("hotel", this.hotelDAO.buscaPor(id));

        return "update-form";
    }

    @PostMapping("/atualiza")
    @Transactional
    public String atualiza(HotelAtualizaInputDTO hotelAtualizaInputDTO, RedirectAttributes redirectAttributes){
        Hotel hotel = this.hotelDAO.buscaPor(hotelAtualizaInputDTO.getId());

        hotel.getDadosHotel().setNome(hotelAtualizaInputDTO.getNome());
        hotel.getDadosHotel().setCnpj(hotelAtualizaInputDTO.getCnpj());
        hotel.getDadosHotel().getContato().setEmail(hotelAtualizaInputDTO.getEmail());
        hotel.getDadosHotel().getContato().setTelefone(hotelAtualizaInputDTO.getTelefone());
        hotel.getDadosHotel().getContato().setCelular(hotelAtualizaInputDTO.getCelular());
        hotel.getDadosHotel().getEndereco().setRua(hotelAtualizaInputDTO.getRua());
        hotel.getDadosHotel().getEndereco().setBairro(hotelAtualizaInputDTO.getBairro());
        hotel.getDadosHotel().getEndereco().setNumero(hotelAtualizaInputDTO.getNumero());
        hotel.getDadosHotel().getEndereco().setCep(hotelAtualizaInputDTO.getCep());
        hotel.getDadosHotel().getEndereco().setCidade(hotelAtualizaInputDTO.getCidade());
        hotel.getDadosHotel().getEndereco().setUf(hotelAtualizaInputDTO.getUf());
        hotel.getDadosHotel().getEndereco().setComplemento(hotelAtualizaInputDTO.getComplemento());

        redirectAttributes.addFlashAttribute("deleta", "Sucesso na atualização dos dados.");


        return "redirect:/hotel/lista";
    }



}
