# Wardrobe

## Story

Your company, WardROBOT is in the fashion industry. Your goal is to sell smart wardrobes and hangers.
This is the prototyping phase, and you were asked to create some basic functionality for
this revolutionary furniture. It shouldn't have a graphical interface for the time being,
only a simple console interface, just to see the different wardrobe scenarios.

## What are you going to learn?

- Practice the principles of object-oriented programming.
- Use built-in exceptions.
- Use generics.
- Use Optionals and streams.

## Tasks

1. Implement different clothes that can be placed on hangers.
    - All clothes have a unique identifier (UUID) field named `id`, which is set when created. The identifier cannot be changed later. It is available through the `UUID getId()` method.
    - All clothes have a `brandName` field which can be set only once at creation. Its value is returned when calling the `getBrandName` method.
    - All clothes have a `type` field, which is different for different kinds of clothing.
The type can be one from the following list.
- shirt
- blouse
- trousers
- skirt
    - There is a special type of clothing named `UpperClothes`. Its type can be only `shirt` or `blouse`. Otherwise, an `IllegalArgumentException` is thrown.
    - There is a special type of clothing named `LowerClothes`. Its type can be only `trousers` or `skirt`. Otherwise, an `IllegalArgumentException` is thrown.

2. Implement different types of hangers which can store different clothes in different ways.
    - Every `Hanger` has the following capabilities.
- `Optional<Clothes> takeOff()` returns a clothing item currently stored on hanger.
- `Optional<Clothes> takeOff(UUID id)` returns the requested clothing item by ID. If the clothing item is not on the hanger, it returns empty.
- `void put(Clothes clothes)` puts the clothing item on the hanger if there is a free slot. Otherwise, it throws an `IllegalStateException`.
- `boolean hasSlotFor(ClothesType type)` determines whether there is a free slot for a particular `ClothesType`.
    - The `ShirtHanger` can only accommodate clothes that can be worn on the upper body (shirts and blouses). As a `ShirtHanger` can accommodate only one clothing item, the value of the `hasSlotFor` method is only true when the hanger does not store any clothes. The currently stored clothing item can be taken off by hanger or by its ID.
    - The `PantHanger` can accommodate one shirt or blouse and one skirt or pair of trousers. Based on the `put(Clothes clothes)` parameter runtime type, it the clothes are automatically moved to the proper slot. If there is no place for the particular type, an `IllegalStateException` is thrown.
    - The `hasSlotFor` method returns `true` if the hanger has a free slot for the requested clothing type.
    - Upper and lower body clothing items can be taken off one-by-one from a `PantHanger` using the `Optional<Clothes> takeOff()` method. This method always returns the upper body clothes first, when possible. Lower body clothing items are only returned when no upper body items are stored on the hanger.

3. The wardrobe stores the clothes, but there are some rules on how clothes can be placed in it.
    - A `Wardrobe` can only accommodate a certain number of hangers, based on the value of the `limit` field. The value of `limit` can vary between different wardrobes. The value of `limit` is defined when creating the wardrobe and cannot be changed afterwards. The value of `limit` can be queried at any time using `getLimit()` method. The value of `limit` cannot exceed `120`. When trying to create a `Wardrobe` with a limit over 120, an `IllegalArgumentException` is thrown with a 'Maximum limit is 120.' message.
    - There is a `put(Hanger hanger)` method that enables placing a hanger in the wardrobe. If there is free space in wardrobe, the hanger is stored.
    - No more hangers can be placed in the wardrobe than physically possible. When trying to place a hanger in the wardrobe and the wardrobe is full, an `IllegalStateException` is thrown with a 'The wardrobe currently is full.' message.
    - Empty hangers can be placed into the wardrobe by calling `put(Hanger hanger)`.
    - There is a `count()` method which returns the number hangers in the wardrobe.
    - Hangers with clothes on them can be placed in wardrobe by calling `put(Hanger hanger)`.
    - A clothing item can only be hung in the wardrobe if it is placed on a hanger.
    - You can get an empty hanger using the `Hanger getHanger(ClothesType type)` method. It returns an available hanger. If no free hanger is available, a `NoSuchElementException` is thrown with a 'No empty hangers for your clothes' message.
    - Clothes can be taken out of the wardrobe based on their unique identifier by calling the `Clothes getClothes(UUID id)` method. If the clothing item is not in the wardrobe, a `NoSuchElementException` is thrown with a 'Clothes not found.' message.

## Hints

- Draw some inspiration from the provided unit tests for other projects.
- Use streams for the take off functionality of the wardrobe.
- Check the expected exception message when throwing exceptions is required.
- [Run tests in your IDE](media/java/run-tests.gif).


## Background materials

- <i class="far fa-exclamation"></i> [Nulls are evil](project/curriculum/materials/pages/java/java-nulls-are-evil.md)
- <i class="far fa-exclamation"></i> [Guide to Java 8 Optional](https://www.baeldung.com/java-optional)
- <i class="far fa-exclamation"></i> [Exception handling](project/curriculum/materials/pages/java/exception-handling.md)
- <i class="far fa-exclamation"></i> [Generics](project/curriculum/materials/competencies/java-data-structures/java-generics.md.html)
- <i class="far fa-candy-cane"></i> [Functional programming](project/curriculum/materials/pages/general/functional-programming.md)
- <i class="far fa-candy-cane"></i> [Functional elements in Java](project/curriculum/materials/pages/java/functional-elements-in-java.md)
- <i class="far fa-candy-cane"></i> [Java streams](https://www.baeldung.com/java-streams)
- <i class="far fa-book-open"></i> [Software testing](project/curriculum/materials/pages/general/software-testing.md)

