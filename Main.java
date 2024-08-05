//---------------> SINGLETON <------------------
// class GameSetting{
//     private static volatile GameSetting instance ;
//     private String difficulty;
//     private int volume ;
//     private String resolution;

//     GameSetting(){
//      difficulty="Low";
//      volume=80;
//      resolution="4k";
//     }
    
//     public static GameSetting getInstance(){
//         if (instance==null) {
//             synchronized(GameSetting.class){
//                 if (instance==null) {
//                     instance=new GameSetting();
                    
//                 }
//             }
            
//         }
//         return instance;
//     }
//     public void setDifficulty(String difficulty){
//         this.difficulty = difficulty;
//     }
//     public String getDifficulty(){
//         return difficulty;
//     }
//     public void setVolume(int volume){
//         this.volume=volume;
//     }
//     public int getVolume(){
//         return volume;
//     }
//     public void setResolution(String resolution){
//         this.resolution=resolution;
//     }

// }


// public class Main {
//     public static void main(String[] args){
//     GameSetting St1=GameSetting.getInstance();
//     GameSetting St2=GameSetting.getInstance();
//     St1.setDifficulty("High");
//     St2.setDifficulty("Low");
//     System.out.println(St1.getDifficulty());
//     System.out.println(St2.getDifficulty());
    
//     }
// }






//--------------> BUILDER <----------------------

// class Pc{
//    private  String cpu;
//    private  String ram;
//    private  String storage;
//    private  String power;
    
//    private Pc(String cpu ,String ram ,String storage,String power){
//      this.cpu=cpu;
//      this.ram=ram;
//      this.storage=storage;
//      this.power=power;
//  } 
// public String toString()  {

//     return cpu+"\n"+ram+"\n"+storage+"\n"+power;
// }
// static class PcBuilder{
//     private  String cpu;
//    private  String ram;
//    private  String storage;
//    private  String power;

//    public PcBuilder cpu(String cpu){
//     this.cpu=cpu;
//     return this;
//    }
//    public PcBuilder ram(String ram){
//     this.ram=ram;
//     return this;
//    }
//    public PcBuilder storage(String storage){
//     this.storage=storage;
//     return this;
//    }
//    public PcBuilder power(String power){
//     this.power=power;
//     return this;
//    }
//    public Pc build(){
//     return new Pc(cpu, ram, storage, power);
//    }

// }
// }


// public class Main {
//     public static void main(String[] args){
//      Pc c1 = new Pc.PcBuilder()
//      .cpu("I9")
//      .ram("16")
//      .storage("1TB")
//      .power("750w")
//      .build();
     

//      System.out.println(c1);
//     }
// }




// -----------------> DIRECTOR <--------------------------
// interface Pizza {
//  String MakePizza();
// }
// class PlainPizza implements Pizza {
//  public String MakePizza(){
//     return "Pizza";
//  }
// }
// abstract class PizzaDecorator implements Pizza{
//     protected Pizza pizza;
//     PizzaDecorator(Pizza pizza){
//        this.pizza=pizza;
//     }
//     public String MakePizza(){
//         return pizza.MakePizza();
//     }

// }
// class ChickenPizzaDecorator extends PizzaDecorator{
//   ChickenPizzaDecorator(Pizza pizza){
//     super(pizza);
//   }
//  private String addChiken(){
//     return " ,Chicken added";
//  }

//   @Override 
//   public String MakePizza(){
//     return pizza.MakePizza() + addChiken();
//   }
  
// }
// class VegPizzaDecorator extends PizzaDecorator{
//     VegPizzaDecorator(Pizza pizza){
//      super(pizza);
//     }
//     private String addVegetable(){
//         return ", Vegetable added";
//     }
//     @Override
//     public String MakePizza(){
//         return pizza.MakePizza() + addVegetable();
//     }
// }

// public class Main{
//     public static void main(String[] args){
//     PlainPizza obj =new PlainPizza();
//     System.out.println(obj.MakePizza());


//     PizzaDecorator objwc = new ChickenPizzaDecorator(obj);
//     System.out.println(objwc.MakePizza());


//     PizzaDecorator pishfoiw =new VegPizzaDecorator(objwc);
//     System.out.println(pishfoiw.MakePizza());
//     }
// }



// ------------------> ADAPTER <--------------------------
// interface MediaPlayer{
//     void play();
// }
// class CassettePlay{
//     void playtape(){
//         System.out.println("Play tape");
//     }
// }
// class ADAPTER implements MediaPlayer{
//     private CassettePlay cassettePlay;
//     ADAPTER(CassettePlay cassettePlay){
//         this.cassettePlay=cassettePlay;
//     }
//     @Override
//     public void play(){
//      cassettePlay.playtape();
//     }
// }



// public class Main{
//     public static void main(String[] args){
//      CassettePlay obj1 =new CassettePlay();
//      ADAPTER obj2 =new ADAPTER(obj1);
//      obj2.play();
//     }
// }




// --------------------> FACADE <-------------------------
// class DVD{
//     void play(){
//         System.out.println("PLay dvd");
//     }
//     void stop(){
//         System.out.println("Stopping dvd");
//     }
// }
// class Projector{
//     void on(){
//         System.out.println("Projector on");
//     }
//     void off(){
//         System.out.println("Projector off");
//     }
// }
// class Light{
//     void on(){
//         System.out.println("light on ");
//     }
//     void off(){
//         System.out.println("Light off");
//     }
// }
// class Screen{
//     void up(){
//         System.out.println("Screen up");
//     }
//     void down(){
//         System.out.println("Screen Down");
//     }
// }
// class Sound{
//     void on(){
//         System.out.println("Sound on ");
//     }
//     void off(){
//         System.out.println(" Sound off");
//     }
// }
// class Hometheater{
//     private DVD dvd;
//     private Projector pjct;
//     private Light light;
//     private Screen screen;
//     private Sound sound;


//  Hometheater(DVD dvd,Projector pjct,Light light,Screen screen,Sound sound){
//      this.dvd=dvd;
//      this.light=light;
//      this.pjct=pjct;
//      this.sound=sound;
//      this.screen=screen;
//     }
    
//     void playMovie(){
//         dvd.play();
//         screen.down();
//         sound.on();
//         light.on();
//         pjct.on();

//     }
    
//     void end(){
//         dvd.stop();
//         screen.up();
//         sound.off();
//         light.off();
//         pjct.off();

//     }


// }






public class Main{
  public static void main(String[] args){
  }
}









