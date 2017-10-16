package rpg;
import java.util.Scanner;
import java.util.Random;
public class GameClass {
    public static Random rand = new Random();
    private  Hero [] heroPattern = new Hero[3];
    private Monster [] monsterPattern = new Monster[3];
    private Hero mainhero;
    private Monster  currentMonster;
    private int currentRound=0;




   public  GameClass() {


       initGame();
    }
    public void mainGameCircle(){
        Scanner sc = new Scanner(System.in);
        int inpInt = 0;
        System.out.println("Ваша игра начинается прямо сейчас.");
        System.out.println("\n Выберите персонажа:");
            for (int i = 0; i < 3; i++)
                System.out.println((i+1) + ". " + heroPattern[i].getName());
        inpInt=sc.nextInt();
        mainhero= (Hero)heroPattern[inpInt-1].clone();
        System.out.println("Вы выбрали "+mainhero.getName()+"- "+ mainhero.getCharClass());
        currentMonster = (Monster)monsterPattern[0].clone();
        do {
            System.out.println("Текущий раунд: " + currentRound);
            mainhero.ShowFullInfo();
            currentMonster.ShowFullInfo();
            System.out.println("Ваш ход: 1. Атака 2. Защита 3. Пропустить ход");
            System.out.println("\n\n\n");
            inpInt=sc.nextInt();
            if(inpInt==0)break;
            if (inpInt==1){
                currentMonster.getDamage(mainhero.makeatkhero());
            }
            if (inpInt==2){
                mainhero.setBlockStance();
            }
                if (Math.random()*100<=36) {
               currentMonster.setBlockStance();
            }else
                mainhero.getDamage(currentMonster.makeatk());
                currentRound++;
            if (!mainhero.live){
                break;

            }
            if (!currentMonster.live){
                int z=0;
                System.out.println(" Вы убили монстра " + currentMonster.getName() );
                z++;
                currentMonster = (Monster)monsterPattern[GameClass.rand.nextInt(3)].clone();
                System.out.println(" На поле боя выходит " +currentMonster.getName());
                mainhero.expgain ((int)(currentMonster.gethpmax() * 1.5*(int)(z+0.3f*z)));
            }
        }
        while (true);
        if(!currentMonster.live) System.out.println(" Вы убили монстра " + currentMonster.getName() );
        if(!mainhero.live) {
            System.out.println("Вы погибли");
            System.out.println("Игра завершена");
        }



    }
    public void initGame(){
        heroPattern[0] = new Hero("Паладин ","Тирион Фордринг ",3400,200,200);
        heroPattern[1] = new Hero("Лучник ","Сильванна Ветрокрылая ",2500,276,150);
        heroPattern[2] = new Hero("Маг ","Эгвин Хранитель Трисфаля ",1900,400,90);

        monsterPattern[0]= new Monster("Гуманойд ","Мурлок     ",500+GameClass.rand.nextInt(200),200+GameClass.rand.nextInt(48),0);
        monsterPattern[1]= new Monster("Нежить ","Голем из плоти ",1000+GameClass.rand.nextInt(300),150+GameClass.rand.nextInt(150),200);
        monsterPattern[2]= new Monster("Человек ","Убийца ",600+GameClass.rand.nextInt(100),100+GameClass.rand.nextInt(300),49);

    }

    public static void main(String[] args){
        GameClass gameClass = new GameClass();

    }


}
