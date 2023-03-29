package br.com.hotel.devaneio.controller;

import br.com.hotel.devaneio.model.Contato;
import br.com.hotel.devaneio.model.DadosHotel;
import br.com.hotel.devaneio.model.Endereco;
import br.com.hotel.devaneio.model.Hotel;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


}
