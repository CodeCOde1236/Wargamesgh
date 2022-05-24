package com.example.wargames;

import java.io.*;
import java.util.List;

public class FileController {

    public FileController() {
    }

    /**
     * Creates a csv file for the army
     * @param army Army to be read
     * @return Returns csv file contents
     */
    public String readFile(Army army) {
        String file = army.getName() + ".txt";
        BufferedReader reader = null;
        String result = "";

        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split("\n");

                for(String index : row){
                    //System.out.printf("%-10s", index);
                    result += index + " ";
                }
                //System.out.println();

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

    /**
     * Writes army into a csv file
     * @param army Army object to be recorded
     */
    public void writeFile(Army army){
        String text = army.getName() + ".txt";
        try {
            File file = new File(text);

            FileWriter writer = new FileWriter(text);

            writer.write(army.getName()+"\n");

            for(Unit unit : army.getAllUnits()){
                if(unit instanceof InfantryUnit){
                    writer.append(String.format("InfantryUnit,%s,%d\n", unit.getName(), unit.getHealth()));
                }
                if(unit instanceof CavalryUnit){
                    writer.append(String.format("CavalryUnit,%s,%d\n", unit.getName(), unit.getHealth()));
                }
                if(unit instanceof CommanderUnit){
                    writer.append(String.format("CommanderUnit,%s,%d\n", unit.getName(), unit.getHealth()));
                }
                if(unit instanceof RangedUnit){
                    writer.append(String.format("RangedUnit,%s,%d\n", unit.getName(), unit.getHealth()));
                }
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
