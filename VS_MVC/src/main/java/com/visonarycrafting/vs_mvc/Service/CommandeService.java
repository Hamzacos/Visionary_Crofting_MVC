package com.visonarycrafting.vs_mvc.Service;

import com.visonarycrafting.vs_mvc.Entities.Command;
import org.springframework.data.domain.Page;

public interface CommandeService {

    Command saveCommande(Command command);
    Command updateCommand(int id);

}
