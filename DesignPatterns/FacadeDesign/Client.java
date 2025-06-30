package FacadeDesign;

import FacadeDesign.Facade.FacadeClass;

public class Client {
    public static void main(String[] args) {
        FacadeClass facade = new FacadeClass();

        /**
         * For client only execution is important -> internally the classes calling or
         * ordering of the class.
         */
        facade.execute();
    }
}
