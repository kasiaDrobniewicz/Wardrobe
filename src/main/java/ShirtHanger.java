import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShirtHanger implements Hanger<UpperClothes> {

    private List<UpperClothes> hangersWithUpperClothes = new ArrayList<>();

    public ShirtHanger() {
        super();
    }

    public List<UpperClothes> getHangersWithUpperClothes() {
        return hangersWithUpperClothes;
    }

    @Override
    public Optional<UpperClothes> takeOff() {
        if (hangersWithUpperClothes.size() >0){
            UpperClothes clothes = hangersWithUpperClothes.get(0);
            hangersWithUpperClothes.remove(clothes);
            return Optional.ofNullable(clothes);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UpperClothes> takeOff(UUID id) {
        for (UpperClothes findClothes : hangersWithUpperClothes) {
            if (findClothes.getId().equals(id)) {
                return Optional.ofNullable(findClothes);
            }
        }
        return Optional.empty();
    }

    @Override
    public void put(UpperClothes item) {
        if (hasSlotFor(item.getType())) {
            hangersWithUpperClothes.add(item);
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasSlotFor(Clothes.ClothesType type) {
        if (type == Clothes.ClothesType.SHIRT || type == Clothes.ClothesType.BLOUSE) {
            return hangersWithUpperClothes.size() <= 0;
        }
        return false;
    }
}


