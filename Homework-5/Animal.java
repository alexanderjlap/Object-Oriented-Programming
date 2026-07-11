public class Animal {
    private Data data;

    public Animal (int age, String name) {
        data = new Data(age, name);
    }

    public int getAge () {
        return data.getAge();
    }

    public String getName () {
        return data.getName();
    }

    public void setAge (int newAge) {
        data.setAge(newAge);
    }

    public void setName (String name) {
        data.setName(name);
    }
}
