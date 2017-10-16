package rpg;


public class GameCharacter {
    protected int hpmax;
    protected  String name;
    protected int hp;
    protected int atk;
    protected int def;
    protected int critChanse;
    protected int critChansehero;
    protected boolean jivy;
    public boolean live=true;
    protected int lvl=1;
    protected boolean blockstance;
    public int gethpmax(){
        return hpmax;
    }


    public String getName() {
        return name;
    }

    protected  String charClass;
    public GameCharacter(String _name, String _charClass, int _hp,int _atk,int _def){
        name= _name;
        charClass = _charClass;
        hp=_hp;
        atk=_atk;
        def=_def;
        critChanse=100;
        hpmax=hp;
        lvl=1;
        blockstance=false;
    }
    public void makeNewRound()
    {
        blockstance = false;
    }
    public void setBlockStance()
    {
        blockstance = true;
        System.out.println(name + " встал в защитную стойку");
    }

    public String getCharClass() {
        return charClass;
    }
    public int makeatkhero() {
        int delta_atk1 =(int)(atk*0.50f);
        int minimumofatk1=(int)(atk*0.75f);
        int currentatk1=minimumofatk1+GameClass.rand.nextInt(delta_atk1);
        if (GameClass.rand.nextInt(100)<=critChansehero){
            currentatk1*=2;
            System.out.println(name+ " нанес критический урон на " +currentatk1+ " урона ");
        }else System.out.println(name+ " нанес " +currentatk1+ " урона ");
        return currentatk1;

    }

    public int makeatk() {
        int delta_atk =(int)(atk*0.50f);
        int minimumofatk=(int)(atk*0.75f);
        int currentatk=minimumofatk+GameClass.rand.nextInt(delta_atk);
        if (GameClass.rand.nextInt(100)<=critChanse){
        currentatk*=2;
            System.out.println(name+ " нанес критический урон на " +currentatk+ " урона ");
        }else System.out.println(name+ " нанес " +currentatk+ " урона ");
        return currentatk;

    }

    public void getDamage(int _inputDamage) {


        _inputDamage -= def*Math.random()*1;
        if (blockstance)
        {
            System.out.println(name + " дополнительно заблокировал " + def*1.3 + " ед. урона в защитной стойке");
            _inputDamage -= def*1.3;
        }
        if (_inputDamage < 0) _inputDamage = 0;
        {
            hp -= _inputDamage;
            System.out.println(name + " получил " + _inputDamage + " урона ");
        }
        if (hp < 1) {
            live = false;
        }
    }
    public void ShowFullInfo(){
        System.out.println("Имя: " + name + " Здоровье: " + hp + "/" + hpmax);
    }

}
