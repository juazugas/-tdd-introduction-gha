package agiletdd.refactor;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imasd on 6/4/17.
 */
public class MoviePrizeRepository {

    public static final String TITANIC = "Titanic";
    public static final String GLADIATOR = "Gladiator";
    public static final String LA_LA_LAND = "La La Land";
    public static final String MOONLIGHT = "Moonlight";
    public static final String FROZEN = "Frozen";
    public static final String TOY_STORY = "Toy Story";


    private enum Films {

        TITANIC("Titanic"),
        GLADIATOR("Gladiator"),
        LA_LA_LAND("La La Land"),
        MOONLIGHT("Moonlight"),
        FROZEN("Frozen"),
        TOY_STORY("Toy Story");

        String filmName;

        private Films(String filmName){
            this.filmName = filmName;
        }

    }

    public Map<String, MoviePrize> getCatalogue() {
        Map<String, MoviePrize> catalogue = new HashMap<>();

        EnumSet.allOf(Films.class).forEach(movie -> {
            int regular = 0;
            int premium= 0, bonus = 0;

            if (movie == Films.TITANIC) {
                bonus = 1;
            } else if (movie == Films.GLADIATOR) {
                bonus = 1;
            } else if (movie == Films.LA_LA_LAND) {
                bonus = 5;
            } else if (movie == Films.MOONLIGHT) {
                bonus = 5;
            } else if (movie == Films.FROZEN) {
                bonus = 2;
            } else if (movie == Films.TOY_STORY) {
                bonus = 5;
            }

            if (movie == Films.TITANIC) {
                premium = 8 ;   // 2€ de descuento si es premium en peliculas normales
            } else if (movie == Films.GLADIATOR) {
                premium = 8 ;
            } else if (movie == Films.LA_LA_LAND) {
                premium = 15 ; // 5€ de descuento si es premium en peliculas nuevas
            } else if (movie == Films.MOONLIGHT) {
                premium = 15 ;
            } else if (movie == Films.FROZEN) {
                premium = 4 ; // 5€ de descuento si es premium en peliculas para niños
            } else if (movie == Films.TOY_STORY) {
                premium = 4 ;
            }

            if (movie == Films.TITANIC) {
                regular = 10 ;   // el precio de las peliculas normales es de 10 al dia.
            } else if (movie == Films.GLADIATOR) {
                regular = 10 ;
            } else if (movie == Films.LA_LA_LAND) {
                regular = 20 ; // el precio de las peliculas nuevas es de 20 al dia.
            } else if (movie == Films.MOONLIGHT) {
                regular = 20 ;
            } else if (movie == Films.FROZEN) {
                regular = 5 ; // el precio de las peliculas para niños es de 5 al dia.
            } else if (movie == Films.TOY_STORY) {
                regular = 5 ;
            }
            MoviePrize moviePrize = new MoviePrize();
            moviePrize.setBonus(bonus);
            moviePrize.setPremium(premium);
            moviePrize.setRegular(regular);
            catalogue.put(movie.filmName, moviePrize);
        });

        return catalogue;
    }
}
