package agiletdd.refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static agiletdd.refactor.MoviePrizeRepository.TITANIC;

public class MovieRentalStoreService {


    Map<String, MoviePrize> catalogue;


    public MovieRentalStoreService(MoviePrizeRepository moviePrizeRepository){
        catalogue = moviePrizeRepository.getCatalogue();

    }

    public RentalTicket rentMovies(Customer customer, List<String> movies, int days) {
        RentalTicket rentalTicket = new RentalTicket();
        int total = 0;
        int bonus = 0;

        int extra = calcInitialExtra(customer);
        total += extra;

        for (String movie : movies) {
            if (customer.getPremium() == 0) {
                total = getTotalByRegularCustomer(movie, days, total);
            } else {
                total = getTotalByPremiumCustomer(movie, days, total);
                bonus = getBonusByPremiumCustomer(movie,  bonus);
            }
        }

        if (customer.getPremium() == 1 && extra > 0) {
            bonus = 0;
        }

        rentalTicket.setCustomer(customer);
        rentalTicket.setMovies(movies);
        rentalTicket.setTotal(total);
        customer.setBonus(bonus);

        for (int i = 0; i < movies.size(); i++) {
            customer.getMovies().add(movies.get(i));
        }

        return rentalTicket;
    }

    private int getBonusByPremiumCustomer(String movie, int bonus) {
        return bonus + catalogue.get(movie).getBonus();

    }

    private int getTotalByPremiumCustomer(String movie, int days, int premium) {
       return premium + catalogue.get(movie).getPremium() * days;
    }

    private int getTotalByRegularCustomer(String movie, int days, int regular) {
        return regular + catalogue.get(movie).getRegular() *  days;
    }

    private int calcInitialExtra(Customer customer) {
        int extra = 0;
        for (int i = 0; i < customer.getMovies().size(); i++) {
            extra += 15;
        }
        return extra;
    }

}
