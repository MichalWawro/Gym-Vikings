package com.example.elgrande;

import com.example.elgrande.repository.TempDatabase;
import com.example.elgrande.repository.TempDatabaseImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElGrandeApplication {
    
    public static void main(String[] args) {
        TempDatabase tempDatabase = new TempDatabaseImpl();
        SpringApplication.run(ElGrandeApplication.class, args);

        System.out.println(TempDatabase.INGREDIENTS.get(1));
    }


}
