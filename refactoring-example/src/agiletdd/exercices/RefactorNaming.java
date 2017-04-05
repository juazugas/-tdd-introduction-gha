package agiletdd.exercices;

import agiletdd.exercices.common.Citizen;
import agiletdd.exercices.common.CitizenRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefactorNaming {

    public static final int MAX_HAPPINESS_PER_CITY = 10000;

    /**
     * Devuelve un mapa con las ciudades y la felicidad de sus ciudadanos.
     *
     * @return
     */
    public Map refactor() {

        CitizenRepository citizenRepository = new CitizenRepository();
        Map<String, Integer> happinessCities = initHappinessCities();
        List<Citizen> citizens = citizenRepository.allCitizens();

        for(Citizen citizen : citizens){
            updateCityHappiness(citizen,happinessCities);
        }

        return happinessCities;
    }

    private void updateCityHappiness(Citizen citizen, Map<String, Integer> happinessByCity) {

        int initialHappiness = happinessByCity.get(citizen.getCity());

        initialHappiness = initialHappiness + citizen.getHappiness();

        if(initialHappiness > MAX_HAPPINESS_PER_CITY) {
            throw new RuntimeException("City citizens are extremely happy.");
        }

        happinessByCity.put(citizen.getCity(), initialHappiness);
    }

    private Map<String, Integer> initHappinessCities() {
        Map<String, Integer> map = new HashMap<>();

        map.put("Valencia", 0);
        map.put("Madrid", 0);
        map.put("Barcelona", 0);
        map.put("Sevilla", 0);

        return map;
    }


}
