public class MembershipControl {
    public static void main(String[] args) {
        setMembershipStatus(true);
    }

    static void setMembershipStatus(boolean b){
        if(b == true){
            IEnquirer enquirer = new Person();
            enquirer.enquire();
            ICarSharer carSharer = (ICarSharer) enquirer;
            carSharer.carShare();
        }
    }
}

interface IEnquirer{
    void enquire();
}

interface ICarSharer{
    void carShare();
}

class Person implements ICarSharer, IEnquirer{

    @Override
    public void enquire() {

    }

    @Override
    public void carShare() {

    }
}

