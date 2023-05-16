import java.util.ArrayList;

public class Functions {

    public ArrayList<Double> ConvertToDouble(ArrayList<String> list) {
        ArrayList<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "") {
                doubleList.add(0.0);
            } else {
                String tempStr = list.get(i).replace(".", "");
                String cleanStr = tempStr.replace(",", ".");
                doubleList.add(Double.parseDouble(cleanStr));
            }
        }
        return doubleList;
    }

    public ArrayList<Double> CleanList(ArrayList<Double> list) {
        ArrayList<Double> cleanList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0.0) {
                cleanList.add(list.get(i));
            }
        }
        return cleanList;
    }
}
