package com.example.demo.Data;

import java.io.*;

public class FileSerializer<T> {

    private final T element;
    private final String fileName;
    private final SerializeStrategy strategy;

    public FileSerializer(T element, String fileName, SerializeStrategy strategy) {
        this.element = element;
        this.fileName = fileName;
        this.strategy = strategy;
    }

    public void serialize() throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        if (strategy == SerializeStrategy.AS_BYTES) {
            serializeAsBytes(file);
        } else {
            serializeAsString(file);
        }
    }

    private void serializeAsString(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(element.toString());
        }
    }

    private void serializeAsBytes(File file) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        )
        {
            objectOutputStream.writeObject(element);
        }
    }

}
