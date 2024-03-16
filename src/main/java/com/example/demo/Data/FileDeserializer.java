package com.example.demo.Data;

import com.example.demo.Logic.ShopOfClocks;

import java.io.*;
import java.util.Scanner;

public class FileDeserializer<T> {

    private final String fileName;
    private SerializeStrategy strategy;

    public FileDeserializer(String fileName, SerializeStrategy strategy) {
        this.fileName = fileName;
        this.strategy = strategy;
    }

    public T deserialize() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }

        if (strategy == SerializeStrategy.AS_BYTES) {
            return deserializeFromBytes(file);
        } else {
            return deserializeFromString(file);
        }

    }

    private T deserializeFromString(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
            builder.append('\n');
        }

        return (T) builder.toString();
    }

    private T deserializeFromBytes(File file) throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        )
        {
            return (T) objectInputStream.readObject();
        }
    }
}
