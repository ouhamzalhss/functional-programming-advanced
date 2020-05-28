package com.ouhamza.demo;


import com.ouhamza.demo.service.FileExporter;
import com.ouhamza.demo.service.OrderExporter;
import com.ouhamza.demo.service.UserExporter;
import lombok.SneakyThrows;
import org.jooq.lambda.Unchecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FpApplication implements CommandLineRunner {

        @Autowired
        private FileExporter fileExporter;
        @Autowired
        private OrderExporter orderExporter ;
        @Autowired
        private UserExporter userExporter;

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(FpApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        fileExporter.exportFile("order.csv", Unchecked.consumer(orderExporter::writerContent));
        fileExporter.exportFile("users.csv",Unchecked.consumer(userExporter::writerContent));

    }
}
