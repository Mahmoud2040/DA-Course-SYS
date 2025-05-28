package lecture5_Strings;

public class StringsLec {
    public static void main(String[] arg) {

        /* stringInit();
        stringImmutability();
        stringPopularMethods();*/

        String name = "madam";
        name = name + "saied";

        StringBuffer nameBuilder = new StringBuffer("Ali");
        nameBuilder.append(" saied").append(" mohamed").append(" fathy");
        nameBuilder.delete(0, 5);
        nameBuilder.insert(0, 's');

        String finalName = nameBuilder.toString();
        System.out.println(finalName);
        nameBuilder.reverse();
        System.out.println(nameBuilder);


    }

    private static void stringPopularMethods() {


        String name = "said ali $ mahmoud";
        String lName = "saied";

        String replacedString = name.replace("$", "fathy");
        replacedString = replacedString.replace("mahmoud", "Ali");
        replacedString = replacedString.replace("i", " ls ");
        System.out.println(replacedString);

        System.out.println(name.indexOf('a', 3));
        System.out.println(name.lastIndexOf('a'));
        System.out.println(name.indexOf("mahmoud", 3));

        System.out.println(name.contains("Ali"));

        System.out.println(name.substring(9));
        System.out.println(name.substring(5, 8));

        String pass = "  hard   drive   123456     ";
        System.out.println(pass);
        System.out.println(pass.trim().trim());

        System.out.println(name.equalsIgnoreCase(lName));

        System.out.println(name);
        System.out.println(name.charAt(2));
        System.out.println(name.charAt(name.length() - 1));

        char[] nameCharacters = name.toCharArray();
        for (char c : nameCharacters)
            System.out.println(c);

    }

    private static void stringImmutability() {
// immuta
        String fName = "Ali";
        String fName2 = "Ali";
        String lName = " saied";
        fName = fName + lName;

        System.out.println(fName);
        System.out.println(fName2);


        //Muta
        TestMutability t1 = new TestMutability();
        TestMutability t2 = t1;
        System.out.println(t1.phone);
        System.out.println(t2.phone);
        t1.phone = "+201098988481";
        System.out.println(t1.phone);
        System.out.println(t2.phone);

    }

    private static void stringInit() {
        String fName = new String("Ahmed");
        String fName2 = new String("Ahmed");
        String fName3 = new String("Ahmed");

        String lName = "saied";
        String lName2 = "saied";
        String lName3 = "saied";

        System.out.println(fName == fName2);
        System.out.println(fName);
        System.out.println(fName2);
        System.out.println(fName2 == fName3);

        System.out.println(lName == lName2);
        System.out.println(lName);
        System.out.println(lName2);
        System.out.println(lName2 == lName3);
    }
}
