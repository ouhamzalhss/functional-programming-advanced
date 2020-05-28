package com.ouhamza.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.function.Consumer;

/**
 * @author Lhouceine OUHAMZA
 */
@Slf4j
@Service
public class FileExporter {

    public File exportFile(String fileName, Consumer<Writer> writerConsumer) throws Exception {
        File file = new File("export/"+ fileName);
        try(Writer writer= new FileWriter(file)){

            writerConsumer.accept(writer);

            return file;
        }catch (Exception e){
            log.debug("error");
            throw e;
        }
    }
}
