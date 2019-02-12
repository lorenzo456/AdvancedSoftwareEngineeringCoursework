package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MenuList {
    private ArrayList<Item> items;

    public MenuList() {
        this.items = new ArrayList<Item>();
    }


    public ArrayList<Item> getItems() {
        return items;
    }


    public static MenuList fromFile(String fileName) {
        String separator = ",";
        MenuList list = new MenuList();

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(separator);

                double cost = Double.parseDouble(parts[3]);
                ItemCategory category = ItemCategory.valueOf(parts[4].trim());
                ItemType type = ItemType.valueOf(parts[5].trim());

                list.getItems().add(
                    new Item(parts[0], parts[1], parts[2], cost, category, type)
                );
            }
        } catch (IOException e) {
            System.out.println("Unable to load menu list file " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create menu item " + e.getMessage());
        }
        return list;
    }

    @Override
    public String toString() {
        return "domain.MenuList{" +
                "items=" + items +
                '}';
    }
}
