package com.visonarycrafting.vs_mvc.web;


import com.visonarycrafting.vs_mvc.Dao.CommandRepository;
import com.visonarycrafting.vs_mvc.Entities.Command;
import com.visonarycrafting.vs_mvc.Service.impl.CommandeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class CommandeController {

    private CommandRepository commandRepository;



   private CommandeServiceImpl commandeService;




    @GetMapping("/add")
    public String showNewCommand(Model model) {
       Command command = new Command();
        model.addAttribute("command", command);
        return "new_commande";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("Command") Command command) {
        commandeService.saveCommande(command);
        return "redirect:/index";
    }

    @GetMapping(path = "/index")
    public String command(Model model){
        List<Command> commands = commandRepository.findAll();
        model.addAttribute("listCommand",commands);
        return "commands";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable( value = "id")int id){
        commandRepository.deleteById(id);
        return "redirect:/index";
    }
}
