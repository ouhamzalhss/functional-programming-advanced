package com.ouhamza.demo.service;

import com.ouhamza.demo.dao.UserRepo;
import lombok.SneakyThrows;
import org.jooq.lambda.Unchecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;

/**
 * @author Lhouceine OUHAMZA
 */

@Service
public class UserExporter
{
    @Autowired
    private UserRepo userRepo;
    @SneakyThrows
    public void writerContent(Writer writer){
        writer.write("FirstName;LastName\n");
        userRepo.findAll().stream()
                .map(user -> user.getFirstName() + ";"+ user.getLastName())
                .forEach(Unchecked.consumer(writer::write));
    }
}
