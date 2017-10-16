package rpg;

public class Monster extends  GameCharacter implements Cloneable {
    public Monster(String _charClass, String _name,int _hp,int _atk,int _def) {
        super(_name, _charClass, _hp , _atk, _def);
        atk=_atk;
        def=_def;
        hp=_hp;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException a) {
            return (this);
        }
    }
}
