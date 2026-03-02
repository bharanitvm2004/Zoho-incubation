

package Longcoding;
import java.util.*;





public class Main{

    static List<Persons> cousinList(Persons relation , String gender) {

        List <Persons> cousin = new ArrayList<>();
        if(gender.equals("Male"))
        {
            return relation.getDaughters();
        }
        return relation.getSons();
    }

    static void moraponnu(List <Persons> relation , String gender)
    {
        List <Persons> cousin = new ArrayList<>();
        

        if((relation.size()>0))
        {
            for(int j=0;j<relation.size();j++)
            {
                cousin = cousinList(relation.get(j),gender);
                for(int k=0;k<cousin.size();k++)
                {
                    System.out.println(cousin.get(k).getName());
                }
            }
        }
    }

    public static void main(String[] args) {

        List<Persons> familyPersons = new ArrayList<>();

        // Father's
        Persons grandpa =new Persons("Ranganathan","Male",null,null);
        Persons grandma = new Persons("Senthamarai","FeMale",null,null);

        // Mother's
        Persons momGrandpa =new Persons("Krishnamoorthi","Male",null,null);
        Persons momGrandma = new Persons("Ponni","FeMale",null,null);
        

        Persons senthil = new Persons("Senthil","Male",grandpa,grandma);
        grandpa.setSons(senthil);
        grandma.setSons(senthil);
        Persons vasuki = new Persons("vasuki","Female",momGrandpa,momGrandma);
        
        momGrandpa.setDaughters(vasuki);
        momGrandma.setDaughters(vasuki);
        Persons bharani = new Persons("bharani","Male",senthil,vasuki);
        senthil.setSons(bharani);
        vasuki.setSons(bharani);
        Persons saritha = new Persons("saritha","Female",grandpa,grandma);
        grandpa.setDaughters(saritha);
        grandma.setDaughters(saritha);
        senthil.setSisters(saritha);
        Persons srileela = new Persons("srileela","female",null,saritha);
        saritha.setDaughters(srileela);
        Persons ravi = new Persons("ravi","Male",momGrandpa,momGrandma);
        momGrandpa.setSons(ravi);
        momGrandma.setSons(ravi);
        vasuki.setBrothers(ravi);
        ravi.setSisters(vasuki);
        Persons pooja= new Persons("pooja","female",ravi,null);
        ravi.setDaughters(pooja);
        senthil.setSons(bharani);
        senthil.setSons(bharani);


        


        familyPersons.add(grandpa);
        familyPersons.add(grandma);
        familyPersons.add(momGrandpa);
        familyPersons.add(momGrandma);
        familyPersons.add(senthil);
        familyPersons.add(vasuki);
        familyPersons.add(bharani);
        familyPersons.add(saritha);
        familyPersons.add(srileela);
        familyPersons.add(ravi);
        familyPersons.add(pooja);

        String name = "pooja";
        List <Persons> aunts = new ArrayList<>();
        List <Persons> uncles = new ArrayList<>();
        String gender = "";

        for(int i=0;i<familyPersons.size();i++)
        {
            if(name.equals(familyPersons.get(i).getName()))
            {
                gender = familyPersons.get(i).getName();
                aunts = familyPersons.get(i).getFather().getSisters();
                moraponnu(aunts,gender);
                uncles = familyPersons.get(i).getMother().getBrothers();
                moraponnu(uncles, gender);
                break;
            }
        }
    }
}