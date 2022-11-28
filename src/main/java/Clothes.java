import java.util.UUID;
import java.util.stream.Stream;


public class Clothes {
    private UUID id;
    private final String brandName;
    private ClothesType type;

    public Clothes(String brandName, ClothesType type) {
        setId();
        this.brandName = brandName;
        setType(type);
    }

    public Clothes(String brandName){
        this.brandName = brandName;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setType(ClothesType type) {
        Stream.of(ClothesType.values())
                .filter(x -> x.toString().equals(type));
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public ClothesType getType() {
        return type;
    }

    public enum ClothesType {
        SHIRT, BLOUSE, TROUSERS, SKIRT;
    }
}


