package helloServer;

import java.io.Serializable;

public class Person implements Serializable {
  private String name;
  private int age;
  private String city;

  public void setName(String name) {
    this.name = name;
  }
 
  public String getName() {
    return this.name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }
  
  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return this.city;

  }

  public String info() {
    return "Hi, I'm " + this.name + " (" + this.age + ") and I'm from " + this.city;
  }  
}
