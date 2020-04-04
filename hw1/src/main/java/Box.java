import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> boxOFFruit = new ArrayList<T>();

    public Box() {

    }

    public ArrayList<T> getBoxOFFruit() {
        return boxOFFruit;
    }

//    public void addFruit(T fruit) {
//        if (getBoxOFFruit().size() == 0) {
//            getBoxOFFruit().add(fruit);
//        } else if ((getBoxOFFruit().get(0) instanceof Orange && fruit instanceof Orange)
//        || (getBoxOFFruit().get(0) instanceof Apple && fruit instanceof Apple)) {
//            getBoxOFFruit().add(fruit);
//        } else {
//            System.out.println("Фрукт " + fruit.getClass() +
//                    " в эту коробку положить нельзя сдесь лежат " + getBoxOFFruit().get(0).getClass());
//        }
//
//    }

    public void addFruitToBox(T fruit) {
        getBoxOFFruit().add(fruit);

    }

    public float getWeightBox() {
        if (boxOFFruit.size() == 0) {
            return 0;
        }
        return boxOFFruit.size() * boxOFFruit.get(0).getWeight();
    }

    public boolean compareBox(Box<?> box) {
        return Math.abs(getWeightBox() - box.getWeightBox()) < 0.0001;
    }

    public void fromBoxToBox(Box<T> box) {
        if (box.boxOFFruit.size() == 0 || this == box) {
            return;
        }
        getBoxOFFruit().addAll(box.getBoxOFFruit());
        box.getBoxOFFruit().clear();
    }
}
