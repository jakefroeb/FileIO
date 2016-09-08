import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jakefroeb on 9/8/16.
 */
public class PromptUser {
    public static Scanner scanner = new Scanner(System.in);
    public static FavoriteTeam favoriteTeam = new FavoriteTeam();

    public static void main(String[] args) {
        try {
            favoriteTeam = loadTeam();
            System.out.printf("Your favorite team is %s. They play %s in %s and have won %s championships, " +
                            "and your favorite player is %s\n", favoriteTeam.getName(), favoriteTeam.getSportType(),
                    favoriteTeam.getState(), favoriteTeam.getChampionships(), favoriteTeam.getFavoritePlayer());
            while (isDone()) {
                changeTeam();
            }
        } catch (FileNotFoundException e) {
            createTeam();
        }
        System.out.printf("Your favorite team is %s. They play %s in %s and have won %s championships, " +
                        "and your favorite player is %s", favoriteTeam.getName(), favoriteTeam.getSportType(),
                favoriteTeam.getState(), favoriteTeam.getChampionships(), favoriteTeam.getFavoritePlayer());
        boolean saved = false;
        while (!saved) {
            try {
                saveTeam();
                saved = true;
            } catch (IOException e) {
                System.out.println("Unable to save your favorite team");

            }
        }


    }

    public static FavoriteTeam loadTeam() throws FileNotFoundException {
        File f = new File("game.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();
        JsonParser p = new JsonParser();
        return p.parse(contents, FavoriteTeam.class);
    }

    public static void changeTeam() {
        System.out.println("Which part of your team would you like to change? [name/state/sporttype/championships/favoriteplayer");
        String option = scanner.nextLine().toLowerCase();
        boolean validOption = false;
        while (!validOption) {
            if (option.equals("name")) {
                System.out.println("What is the new name of your team?");
                favoriteTeam.setName(scanner.nextLine());
                validOption = true;
            } else if (option.equals("state")) {
                System.out.println("What is the new state that your team is in?");
                favoriteTeam.setState(scanner.nextLine());
                validOption = true;
            } else if (option.equals("sporttype")) {
                System.out.println("What is the new sport type?");
                favoriteTeam.setSportType(scanner.nextLine());
                validOption = true;
            } else if (option.equals("championships")) {
                System.out.println("How many championships have you won now?");
                favoriteTeam.setChampionships(Integer.parseInt(scanner.nextLine()));
                validOption = true;
            } else if (option.equals("favoriteplayer")) {
                System.out.println("Who is your new favorite player?");
                favoriteTeam.setFavoritePlayer(scanner.nextLine());
                validOption = true;
            } else {
                System.out.println("Im sorry your input doesnt match one of the categories please try again.");
                option = scanner.nextLine();
            }
        }

    }

    public static void createTeam() {
        System.out.println("What is the name your favorite sportsteam?");
        favoriteTeam.setName(scanner.nextLine());
        System.out.println("What state is this team in?");
        favoriteTeam.setState(scanner.nextLine());
        System.out.println("What kind of sport is it?");
        favoriteTeam.setSportType(scanner.nextLine());
        System.out.println("How many championships have they won?");
        favoriteTeam.setChampionships(Integer.parseInt(scanner.nextLine()));
        System.out.println("Who is your favorite player?");
        favoriteTeam.setFavoritePlayer(scanner.nextLine());
    }

    public static void saveTeam() throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.serialize(favoriteTeam);
        File f = new File("game.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static boolean isDone() {
        System.out.println("Would you like to make changes?");
        String changes = scanner.nextLine();
        if (changes.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }


    }


}
