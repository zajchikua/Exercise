package CollectionsExercise;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionLibraries {
    public static void main(String[] args) {
        Room one = new Room("One", "Standard Small",2, 99.99);
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.0);
        Collection<Room> rooms = List.of(one, cambridge, manchester);

//        System.out.println(rooms.stream()
//                .mapToDouble(r -> r.getRate())
//                .sum());

        System.out.println(rooms.stream()
                .mapToDouble(Room::getRate)
                .sum());
    }
}
class Room
{
    private String name;
    private String type;
    private double rate;
    private int capacity;

    public Room(String name, String type, int capacity, double rate)
    {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
    }

    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public double getRate()
    {
        return rate;
    }
    public int getCapacity()
    {
        return capacity;
    }
}
