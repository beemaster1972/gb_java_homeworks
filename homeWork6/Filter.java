import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private Map<Integer, String> filter = new HashMap<>();
    public String reString = "^\\d:[a-zA-Z0-9]+{1,9}";

    public Filter(Map<Integer, String> filter) {
        this.filter = filter;
    }

    public Filter() {
    }

    public Filter(String rawData) {
        String[] rawFilter = new String[14];
        int num = 0;
        String parameter = "";
        Pattern pattern = Pattern.compile(reString);
        Matcher matcher = pattern.matcher(rawData);
        if (matcher.find()) {
            rawFilter = rawData.split(":");
            for (int i = 0; i <= rawFilter.length - 2; i += 2) {
                num = Integer.parseInt(rawFilter[i]);
                parameter = rawFilter[i + 1];
                filter.put(num, parameter);
            }
        }
    }

    public Map<Integer, String> getFilter() {
        return filter;
    }

    @Override
    public String toString() {
        return "filter=" + filter;
    }
}
