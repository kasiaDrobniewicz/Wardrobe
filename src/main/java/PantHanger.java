import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PantHanger implements Hanger {

    private final List<Clothes> hangersWithUpperAndLowerClothes = new ArrayList<>();

    @Override
    public Optional takeOff() {
        for (Clothes clothes : hangersWithUpperAndLowerClothes) {
            if ((hangersWithUpperAndLowerClothes.contains(Clothes.ClothesType.SHIRT)) || (hangersWithUpperAndLowerClothes.contains(Clothes.ClothesType.BLOUSE))) {
                Clothes upperClothes = hangersWithUpperAndLowerClothes.get(hangersWithUpperAndLowerClothes.indexOf(clothes));
                hangersWithUpperAndLowerClothes.remove(clothes);
                return Optional.ofNullable(clothes);
            }
            if ((hangersWithUpperAndLowerClothes.contains(Clothes.ClothesType.SKIRT)) || (hangersWithUpperAndLowerClothes.contains(Clothes.ClothesType.TROUSERS))) {
                Clothes lowerClothes = hangersWithUpperAndLowerClothes.get(hangersWithUpperAndLowerClothes.indexOf(clothes));
                hangersWithUpperAndLowerClothes.remove(clothes);
                return Optional.ofNullable(clothes);
            }
        }
        return Optional.empty();
    }


    @Override
    public Optional takeOff(UUID id) {
        for (Clothes clothes : hangersWithUpperAndLowerClothes) {
            if (clothes.getId().equals(id)) {
                return Optional.ofNullable(clothes);
            }
        }
        return Optional.empty();
    }

    @Override
    public void put(Clothes item) {
        if (item.getType() == Clothes.ClothesType.SHIRT || item.getType() == Clothes.ClothesType.BLOUSE || item.getType() == Clothes.ClothesType.SKIRT || item.getType() == Clothes.ClothesType.TROUSERS) {
            hangersWithUpperAndLowerClothes.add(item);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (type == Clothes.ClothesType.SHIRT || type == Clothes.ClothesType.BLOUSE || type == Clothes.ClothesType.SHIRT || type == Clothes.ClothesType.TROUSERS){
            return hangersWithUpperAndLowerClothes.size() <= 0 ;
        }
        return false;
    }
}


