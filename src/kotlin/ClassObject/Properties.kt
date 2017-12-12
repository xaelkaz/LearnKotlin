package kotlin.ClassObject

class Car (var speed: Double)

/* ----------- */

//Java access properties using method access syntax
Car car = new Car(7.4)
car.setSpeed(9.2)
Double speed = car.getSpeed();

//Kotlin access properties using property access syntax
val car: Car = Car(7.4)
car.speed = 9.2
val speed = car.speed


/* ----------- */

//Java class declaration
public class Fish {
    private int size;
    private boolean hungry;

    public Fish(int size, boolean isHungry) {
        this.size = size;
        this.hungry = isHungry;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}
/* ----------- */

//Kotlin class usage
val fish = Fish(12, true)
fish.size = 7
println(fish.size) // Prints: 7
fish.isHungry = true
println(fish.isHungry) // Prints: true

/* ----------- */

//Kotlin class declaration
class Fish(var size: Int, var hungry: Boolean)

//class usage in Java
Fish fish = new Fish(12, true);
fish.setSize(7);
System.out.println(fish.getSize());
fish.setHungry(false);
System.out.println(fish.getHungry())


/* Custom Get Setter */

class Fruit(var weight: Double) {
    var ecoRating: Int = 3
        get() {
            println("getter value retrieved")
            return field
        }
        set(value) {
            field = if (value < 0) 0 else value
            println("setter new value assigned $field")
        }
}

// Usage
val fruit = Fruit(12.0)
val ecoRating = fruit.ecoRating
// Prints: getter value retrieved
fruit.ecoRating = 3;
// Prints: setter new value assigned 3
fruit.ecoRating = -5;
// Prints: setter new value assigned 0


/* Custom is */

class Fruit(var weight: Double) {
    val isHeavy = weight > 20
}

var fruit = Fruit(7.0)
println(fruit.isHeavy) // Prints: false
fruit.weight = 30.5
println(fruit.isHeavy) // Prints: false


/* Lateint */

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        button = findViewById(R.id.button) as Button
        button.text = "Click Me"
    }
}