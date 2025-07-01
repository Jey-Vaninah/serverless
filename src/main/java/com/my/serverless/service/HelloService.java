package com.my.serverless.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

@Service
@AllArgsConstructor
public class HelloService {

    public String apply() {
        File file = new File("random.txt");

        if (file.exists()) {
            try {
                return Files.readString(file.toPath());
            } catch (IOException e) {
                return "Error reading file: : " + e.getMessage();
            }
        }

        int randomValue = new Random().nextInt(1000);
        String value = String.valueOf(randomValue);

        try {
            Files.writeString(file.toPath(), value);
            return value;
        } catch (IOException e) {
            return "Error writing file: " + e.getMessage();
        }
    }

}
