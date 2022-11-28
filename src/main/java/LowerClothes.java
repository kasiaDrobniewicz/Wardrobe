public class LowerClothes extends Clothes {

    public LowerClothes(String brandName, ClothesType type) {
        super(brandName);
        super.setId();
        setType(type);
    }

    @Override
    public void setType(ClothesType type) {
        switch (type) {
            case TROUSERS:
            case SKIRT:
                super.setType(type);
                break;
            case BLOUSE:
            case SHIRT:
                throw new IllegalArgumentException("The wrong type of wardrobe was introduced");
            default:
                System.out.println("Enter the type of clothing");
                break;
        }
    }
}



