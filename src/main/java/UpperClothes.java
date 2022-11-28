public class UpperClothes extends Clothes {

    public UpperClothes(String brandName, ClothesType type) {
        super(brandName);
        super.setId();
        setType(type);
    }

    @Override
    public void setType(ClothesType type) {
        switch (type) {
            case BLOUSE:
            case SHIRT:
                super.setType(type);
                break;
            case TROUSERS:
            case SKIRT:
                throw new IllegalArgumentException("The wrong type of wardrobe was introduced");
            default:
                System.out.println("Enter the type of clothing");
                break;
        }
    }
}
