class ParentHiding {
    static void staticMethod() {
        System.out.println("Parent static method");
    }

    void instanceMethod() {
        System.out.println("Parent instance method");
    }
}

class ChildHiding extends ParentHiding {
    static void staticMethod() {
        System.out.println("Child static method");
    }

    @Override
    void instanceMethod() {
        System.out.println("Child instance method");
    }
}

public class HidingExam {
    public static void main(String[] args) {
        ParentHiding parent = new ParentHiding();
        ParentHiding childAsParent = new ChildHiding();
        ChildHiding child = new ChildHiding();

        // Static method hiding
        parent.staticMethod(); // Parent static method
        childAsParent.staticMethod(); // Parent static method
        child.staticMethod(); // Child static method

        // Instance method overriding
        parent.instanceMethod(); // Parent instance method
        childAsParent.instanceMethod(); // Child instance method
        child.instanceMethod(); // Child instance method
    }
    /*
    Parent static method
    Parent static method
    Child static method
    Parent instance method
    Child instance method
    Child instance method
     */
}