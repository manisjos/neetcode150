public class PCMain {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.show();

        Parent p11 = new Child();
        p11.Character();

        Parent p21 = new Child();
//        the below dosent work
//        p21.kiddishness()

        Child p1 = new Child();
        p1.show();

        Parent dn = new Child();
        Child c1 = (Child) dn;   // ✅ Allowed (Downcasting)


        Parent uc = new Parent();
        Child c2 = (Child) uc;   // ❌ Runtime Error
        // Parent cant replace child (it may own attributes, unknown to parent)

        // static method - where is it stoed ?
        // direct object - where is it stored ?
        // static variable and direct object reference or creation


        // Child c = (Child) p;   // ❌ Runtime Error
        // why is it allowed while writing the code then
    }
}
