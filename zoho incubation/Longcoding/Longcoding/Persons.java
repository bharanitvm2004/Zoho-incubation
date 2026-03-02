
package Longcoding;
import java.util.*;

class Persons {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Persons getFather() {
        return father;
    }

    public void setFather(Persons father) {
        this.father = father;
    }

    public Persons getMother() {
        return mother;
    }

    public void setMother(Persons mother) {
        this.mother = mother;
    }

    public List<Persons> getBrothers() {
        return brothers;
    }

    public void setBrothers(Persons brother) {
        this.brothers.add(brother);
    }

    public List<Persons> getSisters() {
        return sisters;
    }


    public void setSisters(Persons sister) {
        this.sisters.add(sister);
    }

    public List<Persons> getSons() {
        return sons;
    }

    public void setSons(Persons son) {
        this.sons.add(son);
    }

    public List<Persons> getDaughters() {
        return daughters;
    }

    public void setDaughters(Persons daughter) {
        this.daughters.add(daughter);
    }

    String name;
    String gender;
    

    Persons father;
    Persons mother;

    List<Persons> brothers = new ArrayList();
    List<Persons> sisters = new ArrayList();
    List<Persons> sons = new ArrayList();
    List<Persons> daughters = new ArrayList();

    Persons(String name, String gender,Persons father, Persons mother) 
    {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }
}