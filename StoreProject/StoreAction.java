package StoreProject;
import java.util.TreeSet;
public class StoreAction  {
    StoreAction(){}
    Brand Samsung = new Brand(1,"Samsung");
    Brand Lenevo = new Brand(2,"Lenevo");
    Brand Apple = new Brand(3,"Apple");
    Brand  Huawei = new Brand(4," Huawei");
    Brand Casper = new Brand(5,"Casper");
    Brand Asus = new Brand(6,"Asus");
    Brand HP = new Brand(7,"HP");
    Brand Xiaomi = new Brand(9,"Xiaomi");
    Brand Monster = new Brand(10,"Monster");

    notebook n1 = new notebook(1,Huawei,"Matebook 14 ", 7000.0f,0,5,8,512,14.0f,"Green");
    notebook n2 = new notebook(2,Lenevo,"V14 IGL", 3699.0f,0,6,4,1024,14.0f,"Black");
    notebook n3 = new notebook(3,Apple,"Tuf Gaming", 8199.0f,0,7,16,2048,15.6f,"Red");

    phone p1 = new phone(1,Samsung,"SAMSUNG GALAXY A51",3199.0f,0,3,4,128,6.5f,"White");
    phone p2 = new phone(2,Apple,"iPhone 11 64 GB",7379.0f,0,2,8,64,6.2f,"Red");
    phone p3 = new phone(3,Xiaomi,"Redmi Note 10 Pro 8GB",4012.0f,0,5,16,128,6.5f,"Pink");

    TreeSet<Brand> brandSet = new TreeSet<>();
    TreeSet<ElectronicDevice> notebookSet = new TreeSet<>();
    TreeSet<ElectronicDevice> phoneSet = new TreeSet<>();
    public void createList(){
        brandSet.add(Samsung);
        brandSet.add(Apple);
        brandSet.add(Asus);
        brandSet.add(Lenevo);
        brandSet.add(Xiaomi);
        brandSet.add(HP);
        brandSet.add(Huawei);
        brandSet.add(Casper);
        brandSet.add(Monster);

        phoneSet.add(n1);
        phoneSet.add(n2);
        phoneSet.add(n3);
        notebookSet.add(p1);
        notebookSet.add(p2);
        notebookSet.add(p3);

    }

    public void sortBrand(){
        for(Brand a : brandSet){
            System.out.println("-"+a.getBrand());
        }
    }
     public void sortNotebook(){
        for(ElectronicDevice i : notebookSet){
            System.out.println("| "+i.getId()+" |\t"+i.getName()+"\t\t\t|\t"+i.getPrice()+"\t|\t"+i.getBrand().getBrand()+"\t|\t"+i.getStorage()+"\t|\t"+i.getScreenSize());
        }
    }
    public void sortPhone(){
        for(ElectronicDevice i : phoneSet){
            System.out.println("| "+i.getId()+" |\t"+i.getName()+"\t\t\t|\t"+i.getPrice()+"\t|\t"+i.getBrand().getBrand()+"\t|\t"+i.getStorage()+"\t|\t"+i.getScreenSize());
        }
    }
}

