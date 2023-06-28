package maingroup.st1projektautomat.backend;

public class cAutomatController implements iAutomatControllerInterface{

    private cAutomat automat;
    public cAutomatController(cAutomat a){ automat = a;
        System.out.println("udało się");}

    @Override
    public void test() {
        System.out.println("też się udało!");
    }
}
