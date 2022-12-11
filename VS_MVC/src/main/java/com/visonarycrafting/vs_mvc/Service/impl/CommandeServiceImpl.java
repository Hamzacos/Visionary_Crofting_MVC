package com.visonarycrafting.vs_mvc.Service.impl;

import com.visonarycrafting.vs_mvc.Dao.ClientRepository;
import com.visonarycrafting.vs_mvc.Dao.CommandRepository;
import com.visonarycrafting.vs_mvc.Entities.Client;
import com.visonarycrafting.vs_mvc.Entities.Command;
import com.visonarycrafting.vs_mvc.Service.CommandeService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private Validator validator;
    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Command saveCommande(Command command) {
        Set<ConstraintViolation<Command>> violations = validator.validate(command);
        if(!violations.isEmpty()){
            StringBuilder sb = new StringBuilder("<ul>");
            for (ConstraintViolation<Command> constraintViolation : violations) {
                sb.append("<li>"+constraintViolation.getMessage()+"</li>");
            }
            sb.append("</ul>");
            throw new ConstraintViolationException("<h3>Error occurred:</h3> " + sb.toString(), violations);
        }
        Client cl = new Client();
        cl = clientRepository.findByEmail("test@test.com");
        command.setClient(cl);
        return commandRepository.save(command);
    }

    @Override
    public Command updateCommand(int id) {
        Optional<Command> optionalCommand = commandRepository.findById(id);
        Command command = null;
        if(optionalCommand.isPresent()){
            command = optionalCommand.get();
        }else {
            throw new RuntimeException("Command not found for id : " + id);
        }
        return command;
    }


}
