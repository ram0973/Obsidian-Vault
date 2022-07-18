package classes;

class _Alpha {
    int outer_number = 123;
    void show() {
        _Bravo bravo = new _Bravo();
        bravo.display();
        bravo.innerNumber = 777; // access with inner object granted
        // innerNumber = 888; // direct access to inner field denied
        // display(); // direct access to inner method denied
    }

    class _Bravo {
        int innerNumber = 666;
        void display() {
            System.out.println("Поле number: " + outer_number); // access to outer field granted
        }
    }
}