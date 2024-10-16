import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    void addParents() {
        //arrange
        Person child = new Person("John", "Doe", 10, "Male");
        Person mother = new Person("Jane", "Doe", 35, "Female");
        Person father = new Person("Jack", "Doe", 37, "Male");
        //act
        child.addParents(mother, father);
        //assert
        assertEquals(mother, child.getMother());
        assertEquals(father, child.getFather());
        assertTrue(mother.getChildren().contains(child));
        assertTrue(father.getChildren().contains(child));
    }

    @Test
    void addPet() {
        //arrange
        Person owner = new Person("John", "Doe", 30, "Male");
        Pet pet = new Pet("Buddy", 3, "Dog");
        //act
        owner.addPet(pet);
        //assert
        assertTrue(owner.getPets().contains(pet));
        assertEquals(owner, pet.getOwner());
    }

    @Test
    void addSibling() {
        //arrange
        Person person = new Person("John", "Doe", 25, "Male");
        Person sibling = new Person("Jane", "Doe", 23, "Female");
        //act
        person.addSibling(sibling);
        //assert
        assertTrue(person.getSiblings().contains(sibling));
    }

    @Test
    void addChild() {
        //arrange
        Person parent = new Person("Jane", "Doe", 35, "Female");
        Person child = new Person("John", "Doe", 10, "Male");
        //act
        parent.addChild(child);
        //assert
        assertTrue(parent.getChildren().contains(child));
    }
}
