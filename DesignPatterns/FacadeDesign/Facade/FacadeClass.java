package FacadeDesign.Facade;

import FacadeDesign.ConcreteClasses.ClassA;
import FacadeDesign.ConcreteClasses.ClassB;
import FacadeDesign.ConcreteClasses.ClassC;

public class FacadeClass {
    ClassA classA;
    ClassB classB;
    ClassC classC;

    public FacadeClass() {
        classA = new ClassA();
        classB = new ClassB();
        classC = new ClassC();
    }

    public void execute() {
        classA.funHelp();
        classB.fun();
        classC.fun();
    }
}
