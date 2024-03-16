package com.example.demo.Data;

public class WriteObject {
    /*private static final WriteObject instance = new WriteObject();

    public static WriteObject getInstance() {
        return instance;
    }

    public WriteObject() {
        List<InterfaceOfClock> clocks = HelloApplication.getInstance().getShop().ReturnList();
        try {
            FileOutputStream fos = new FileOutputStream("inf.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(clocks.size());
            for(InterfaceOfClock clock: clocks) {
                oos.writeObject(clock);
            }
            oos.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}

//public class ReadObject {
    /*private static final ReadObject instance = new ReadObject();

    public static ReadObject getInstance() {
        return instance;
    }

    public ArrayList<InterfaceOfClock> List() {
        try {
            FileInputStream fis = new FileInputStream("inf.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<InterfaceOfClock> clocks = new ArrayList<>();
            int clockCounter = ois.readInt();
            for (int i = 0; i < clockCounter; i++) {
                clocks.add((InterfaceOfClock) ois.readObject());
            }
            ois.close();
            return clocks;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/
//}

