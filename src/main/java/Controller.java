import java.io.IOException;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = (WeatherModel) new AccuweatherModel();

    private Map<Integer, Period> variantResults = new HashMap<>();

    public Controller() {
        variantResults.put(1, Period.ofDays(1));
        variantResults.put(0, Period.ofDays(5));
    }

    public void getWeather(String commandInput, String selectedCity) throws IOException {
        Integer integerCommand = Integer.parseInt(commandInput);
        //TODO: *сделать обработку ввода пользователя

        switch (variantResults.get(integerCommand)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.ofDays(5));
                break;
            case FIVE_DAYS:
                //weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                throw new IOException("Вывод прогноза погоды не реализован!");
        }
    }
}
