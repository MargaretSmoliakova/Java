/**
 * Created by Маргарита on 07.12.2016.
 */
public class Program {

    public static void main(String[] args) {

        try {
            Publication newsPaper = new NewsPaper("Таймс", "Энтони", 300, Colourity.black_white);
            Publication magazine = new Magazine("Бурбонс", "Джонс", 200, TypeOfMagazine.shiny);

            System.out.println("Publication's name: " + newsPaper.getName());
            System.out.println("Publication's name: " + magazine.getName());

            newsPaper.setName("Бывший Таймс");
            magazine.setName("Бывший Бурбонс");

            System.out.println("Publication's name: " + newsPaper.getName());
            System.out.println("Publication's name: " + magazine.getName());

            System.out.println(newsPaper);
            System.out.println(magazine);
        } catch (WrongInfoException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
