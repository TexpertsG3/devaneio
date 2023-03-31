package br.com.hotel.devaneio.controller;

import br.com.hotel.devaneio.model.Hotel;
import br.com.hotel.devaneio.model.ServicoAdicional;
import br.com.hotel.devaneio.model.dto.ServicoAdicionalInputDTO;
import br.com.hotel.devaneio.model.dto.ServicoAdicionalOutputDTO;
import br.com.hotel.devaneio.repository.HotelDAO;
import br.com.hotel.devaneio.repository.ServicoAdicionalDAO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/servicoAdicional")
public class ServicoAdicionalController {

    @Autowired
    ServicoAdicionalDAO servicoAdicionalDAO;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    HotelDAO hotelDAO;

    @GetMapping("/cadastra")
    public String cadastra(Model model, ServicoAdicionalInputDTO servicoAdicionalInputDTO) {
        model.addAttribute("servicoAdicionalInputDTO", servicoAdicionalInputDTO);
        return "form-servicoadicional";
    }

    @Transactional
    @PostMapping("/persiste")
    public String persiste(@Valid ServicoAdicionalInputDTO servicoAdicionalInputDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return cadastra(model, servicoAdicionalInputDTO);
        }
        Hotel hotel = this.hotelDAO.buscaPor(servicoAdicionalInputDTO.getHotel());
        if (hotel != null) {
            ServicoAdicional servico = new ServicoAdicional(servicoAdicionalInputDTO.getNome(), servicoAdicionalInputDTO.getValor(), hotel);
            this.servicoAdicionalDAO.cadastra(servico);
        } else {
            model.addAttribute("resultado", "Hotel não encontrado na base de dados");
            return cadastra(model, servicoAdicionalInputDTO);
        }
        return "redirect:/servicoAdicional/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        List<ServicoAdicionalOutputDTO> servicoDTO = servicoAdicionalDAO.lista();
        model.addAttribute("servicos", servicoDTO);
        return "lista-servicosadicionais";
    }

    @GetMapping("/altera")
    public String altera(@RequestParam("id") Integer id, Model model) {

        ServicoAdicional servico = this.servicoAdicionalDAO.buscaPor(id);
        ServicoAdicionalOutputDTO servicoOutput = modelMapper.map(servico, ServicoAdicionalOutputDTO.class);
        servicoOutput.setId(servico.getId());
        servicoOutput.setNome(servico.getNome());
        servicoOutput.setPreco(servico.getPreco());
        servicoOutput.setHotel(servico.getHotel().getIdHotel());

        model.addAttribute("servicoOutput", servicoOutput);

        return "update-servicoadicional";

    }

    @PostMapping("/atualiza")
    @Transactional
    public String atualiza(@Valid ServicoAdicionalOutputDTO servicoAdicionalOutputDTO, Model model, RedirectAttributes redirectAttributes) {
        Hotel hotel = this.hotelDAO.buscaPor(servicoAdicionalOutputDTO.getHotel());
        if (hotel == null) {
            model.addAttribute("resultado", "Hotel não encontrado na base de dados, nenhuma alteração foi realizada.");
            return lista(model);
        }

        this.servicoAdicionalDAO.atualiza(servicoAdicionalOutputDTO);
        redirectAttributes.addFlashAttribute("resultado", "Serviço " + servicoAdicionalOutputDTO.getId() + " alterado com sucesso.");
        return "redirect:/servicoAdicional/lista";
    }

    @GetMapping("/deleta")
    @Transactional
    public String deleta(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        this.servicoAdicionalDAO.deleta(id);
        redirectAttributes.addFlashAttribute("resultado", "Serviço deletado com sucesso.");
        return "redirect:/servicoAdicional/lista";
    }
}
