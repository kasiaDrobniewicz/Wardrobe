import java.util.*;

public class Wardrobe {

    private int wardrobeLimit;
    private List<Hanger<? extends Clothes>> wardrobe = new ArrayList<>();

    public Wardrobe(int limit) {
        setWardrobeLimit(limit);
    }

    public int getWardrobeLimit() {
        return wardrobeLimit;
    }

    public List<Hanger<? extends Clothes>> getWardrobe() {
        return wardrobe;
    }

    public void setWardrobeLimit(int wardrobeLimit) {
        if (wardrobeLimit <= 120){
            this.wardrobeLimit = wardrobeLimit;
        } else {
            throw new IllegalArgumentException("Maximum limit is 120.");
        }
    }

    public void printClothes() {
        System.out.println("List od clothes: ");
        for (int i=0; i < wardrobe.size(); i ++) {
            System.out.println( (i + 1) + "." + wardrobe.get(i));
        }
    }

    public void put(Hanger<? extends Clothes> hanger) {
        if(getWardrobeLimit()>wardrobe.size()){
            wardrobe.add(hanger);
            wardrobeLimit--;
        }
        else {
            throw new IllegalStateException("The wardrobe currently is full.");
        }
    }

    public int count() {
        return wardrobe.size();
    }

    public Hanger<? extends Clothes> getHanger(Clothes.ClothesType clothesType) {
        for(Hanger hanger: wardrobe){
            if(hanger.hasSlotFor(clothesType)){
                return hanger;
            }
        }
        throw new NoSuchElementException("No empty hangers for your clothes");
    }

    public Clothes getClothes(UUID id) {
        for (Hanger hanger: wardrobe){
            if(hanger.takeOff(id).isPresent()){
                return (Clothes) hanger.takeOff(id).get();
            }
        }
        throw new NoSuchElementException("Clothes not found.");
    }

    public static void printList(List<? extends Clothes> wardrobe) {
        Iterator<? extends Clothes> iterator = wardrobe.iterator();
        System.out.println("==============================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }


    public static void main(String[] args) {
        System.out.println("Welcome in Wardrobe!");
    }
}
