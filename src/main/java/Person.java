import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
    private Integer age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;

    public Person(String firstName, String lastName, Integer age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String firstName, String middleName, String lastName, Integer age, String sex) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person mother, Person father) {
        setMother(mother);
        if (mother.getChildren() == null) {
            mother.setChildren(new ArrayList<>());
        }
        mother.addChild(this);

        setFather(father);
        if (father.getChildren() == null) {
            father.setChildren(new ArrayList<>());
        }
        father.addChild(this);
    }

    public void addPet(Pet pet) {
        List<Pet> pets = new ArrayList<>();
        if (this.getPets() != null) {
            pets.addAll(this.getPets());
        }
        pets.add(pet);
        this.setPets(pets);
        pet.setOwner(this);
    }

    public void addSibling(Person sibling) {
        List<Person> siblings = new ArrayList<>();
        if (this.getSiblings() != null) {
            for (Person person : this.getSiblings()) {
                siblings.add(person);
            }
        }
        siblings.add(sibling);
        this.setSiblings(siblings);
    }

    public void addChild(Person child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (!getChildren().contains(child)) {
            getChildren().add(child);
        }
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        if (this.getChildren() != null) {
            for (Person child : this.getChildren()) {
                if (child.getChildren() != null) {
                    for (Person grandChild : child.getChildren()) {
                        grandChildren.add(grandChild);
                    }
                }
            }
        }
        return grandChildren;
    }
}
