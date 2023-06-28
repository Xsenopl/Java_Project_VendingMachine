package maingroup.st1projektautomat.backend;

public class cAutomatController implements iAutomatControllerInterface{

    private cAutomat automat;
    public cAutomatController(cAutomat a){ automat = a; }

    @Override
    public void test() {
        automat.test();
    }
}
