package com.example.wargames;

import java.io.*;
import java.util.List;

public class FileController {

    public FileController() {
    }

    public String readFile(Army army) throws IOException {
        String file = army.getName();
        BufferedReader reader = null;
        String result = "";

        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split("\n");

                for(String index : row){
                    System.out.printf("%-10s", index);
                    result += index + " ";
                }
                System.out.println();

            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                reader.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }

        return result;

    }

    public void writeFile(Army army){
        String text = army.getName() + "txt";
        try {
            File file = new File(text);

            FileWriter writer = new FileWriter(text);

            writer.write(army.getName()+"\n");

            for(Unit infantry : army.getInfantryUnits()){
                writer.append(String.format("Infantry,%s,%d\n", infantry.getName(), infantry.getHealth()));
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Army army = new Army("ARM");
        InfantryUnit unitOne = new InfantryUnit("unitOne", 30);
        InfantryUnit unitTwo = new InfantryUnit("unitTwo", 30);
        CommanderUnit unitThree = new CommanderUnit("unitThree", 30);
        army.addAll(List.of(unitOne, unitTwo, unitThree));

        FileController write = new FileController();
        write.writeFile(army);

    }
}
