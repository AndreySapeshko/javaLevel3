public class Main {
    public static void main(String[] args) {
        Orange orange = new Orange(1.5f);
        Apple apple = new Apple(1.0f);
        Fruit fruitO = new Orange(1.5f);
        Fruit fruitA = new Apple(1.0f);
        Box<Orange> orangeBox = new Box<Orange>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Fruit> box = new Box<Fruit>();
        box.addFruitToBox(apple);
        box.addFruitToBox(orange);
        box.addFruitToBox(fruitA);
        box.addFruitToBox(fruitO);
        orangeBox.addFruitToBox(orange);
        appleBox.addFruitToBox(new Apple(1.0f));
        for (int i = 0; i < 5; i++) {
            appleBox.addFruitToBox(new Apple(1.0f));
        }
        for (int i = 0; i < 4; i++) {
            orangeBox.addFruitToBox(new Orange(1.5f));
        }
        System.out.println("Weight orangeBox: " + orangeBox.getWeightBox());
        System.out.println("Weight fruitBox: " + box.getWeightBox());
        System.out.println("Weight appleBox: " + appleBox.getWeightBox());
        System.out.print("Weight appleBox and orangeBox ");
        if (appleBox.compareBox(orangeBox)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
//        appleBox.fromBoxToBox(box);
//        box.fromBoxToBox(appleBox);
        Box<Orange> orangeBox1 = new Box<>();
        orangeBox.fromBoxToBox(orangeBox);
        System.out.println("Weight orangeBox1: " + orangeBox1.getWeightBox());
        System.out.println("Weight orangeBox: " + orangeBox.getWeightBox());
    }
}
