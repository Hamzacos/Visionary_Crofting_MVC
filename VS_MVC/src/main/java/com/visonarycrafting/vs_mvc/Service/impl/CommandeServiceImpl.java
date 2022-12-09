package com.visonarycrafting.vs_mvc.Service.impl;

import com.visonarycrafting.vs_mvc.Dao.ClientRepository;
import com.visonarycrafting.vs_mvc.Dao.CommandRepository;
import com.visonarycrafting.vs_mvc.Entities.Client;
import com.visonarycrafting.vs_mvc.Entities.Command;
import com.visonarycrafting.vs_mvc.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Command saveCommande(Command command) {
        Client cl = new Client();
//        cl = clientRepository.findByEmail("test@test.com");
        command.setClient(cl);
        return commandRepository.save(command);
    }
}
