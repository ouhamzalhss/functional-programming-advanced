package com.ouhamza.demo.service;

import com.ouhamza.demo.dao.OrderRepo;
import lombok.SneakyThrows;
import org.jooq.lambda.Unchecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;

/**
 * @author Lhouceine OUHAMZA
 */
@Service
public class OrderExporter {

    @Autowired
    private OrderRepo repo;

    @SneakyThrows
    public void writerContent(Writer writer) {
        writer.write("OrderId;Date\n");
        repo.findAll().stream()
                .map(order -> order.getId() + ";"+ order.getCreationDate())
                .forEach(Unchecked.consumer(writer::write));
    }
}
