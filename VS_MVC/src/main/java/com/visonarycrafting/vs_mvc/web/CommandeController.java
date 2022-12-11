package com.visonarycrafting.vs_mvc.web;


import com.visonarycrafting.vs_mvc.Dao.CommandRepository;
import com.visonarycrafting.vs_mvc.Entities.Command;
import com.visonarycrafting.vs_mvc.Service.impl.CommandeServiceImpl;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public String saveCourse(@ModelAttribute("command") Command command,Model model) {
        try{

            commandeService.saveCommande(command);
            return "redirect:/index";
        }catch(ConstraintViolationException e){
            e.printStackTrace();

            model.addAttribute("command", command);
            model.addAttribute("errors",e.getMessage());
            return "new_commande";
        }

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

    @GetMapping("/update/{id}")
    public String update(@PathVariable( value = "id")int id,Model model){
        Command command = commandeService.updateCommand(id);
        model.addAttribute("command",command);
        return  "Update_Command";
    }


    @GetMapping("/page")
    public  String products(Model model ,
                            @RequestParam(name="page",defaultValue = "0") int page ,
                            @RequestParam(name = "size",defaultValue = "5") int size,
                            @RequestParam(name="keyword",defaultValue = "") String keyword
    ){
        // if you want to show all product
        Page<Command> PageComands  = commandRepository.findAll(PageRequest.of(page,size));
        //Page<Product> Pageproducts  = productRepository.findProductByProductName(keyword,PageRequest.of(page,size));
        model.addAttribute("PageComands",PageComands.getContent());
        model.addAttribute("pages",new int[PageComands.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "index";
    }
}
