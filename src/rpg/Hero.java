package rpg;


import java.util.Scanner;

public class Hero extends GameCharacter implements Cloneable {
    private int currentExp;
    private int expToNextLevel;

    public Hero(String _name, String _charClass, int _hp,int _atk,int _def) {
        super(_charClass, _name,_hp ,_atk,_def);
        atk=_atk;
        def=_def;
        hp=_hp;
        currentExp = 0;
        expToNextLevel = 500;
    }

    public void ShowFullInfo() {


    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException a) {
return (this);
        }

    }
    public void expgain(int _exp){
        int z;
        currentExp += _exp;
        System.out.println(name + " получил " + _exp + " ед. опыта");
        if(currentExp > expToNextLevel) {
            currentExp -=expToNextLevel;
            expToNextLevel = (int) (expToNextLevel * 2 * Math.random()*(1.5)+0.33);
            lvl++;
            atk += 25;
            System.out.println("Атака героя повысилась до " + atk + " ед. урона");
            hpmax += 150;
            System.out.println("Запас здоровья героя повысился до " + hpmax);
            hp = hpmax;
            System.out.println(name + " повысил уровень до " + lvl);
            if(lvl==5){
                System.out.println(" Выберите талант: \n 1.Сила духа \n 2.Жестокость \n 3.Атлетизм");
                Scanner sc = new Scanner(System.in);
                System.out.println(" Для получения информации о таланте выберете его номер \n .");
                for (int i=0;i<3;i++){
                int inpInt=sc.nextInt();
                if (inpInt==1){
                    System.out.println(" Навсегда повышает ваш запас здоровья на 200 и урон на 50 ");

                }
                if (inpInt==2){
                    System.out.println(" Увеличивает шанс критического урона на 10% и урон на 20 ");

                }
                if (inpInt==3){
                    System.out.println(" Повышает ваш показатель брони и жизни на 100 ");

                }
                }

                System.out.println(" Выберите талант введя его номер.");
                int inpInt=sc.nextInt();
                if (inpInt==1) {
                    z = 1;
                    hpmax += 200;
                    atk +=50;
                    System.out.println(" Вы выбрали Силу духа.");

                }
                if (inpInt==2) {
                    z = 2;
                    critChansehero=critChanse+10;
                    atk+=20;
                    System.out.println(" Вы выбрали Жестокость.");
                }
                if (inpInt==3) {
                    z = 3;
                    hpmax +=100;
                    def +=100;
                    System.out.println(" Вы выбрали Атлетизм.");
                }




            }
        }

}
}