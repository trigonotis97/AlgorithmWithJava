package leetcode;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class Test_1 {
    /* serializable class */

}

class Employee implements java.io.Serializable
{
    public String empname;
    public String empaddress;
    public transient int emppassword;
    public int empid;
    public void mailCheck()
    {
        System.out.println("Check a mail to " + empname + " " + empaddress);
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpaddress() {
        return empaddress;
    }

    public void setEmpaddress(String empaddress) {
        this.empaddress = empaddress;
    }

    public int getEmppassword() {
        return emppassword;
    }

    public void setEmppassword(int emppassword) {
        this.emppassword = emppassword;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
}
class SampleSerialize
{
    /* Driver Code */
    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.empname = "ABC";
        e.empaddress = "XYZ";
        e.emppassword = 11122333;
        e.empid = 401;
        try
        {
            FileOutputStream fileOut = new FileOutputStream("asdf.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in empinfo.ser");
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }

}

class SampleDeSerialize{
    public static void main(String[] args) {
        try
        {
            ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("asdf.ser"));
            //Read the object back
            Employee readEmpInfo = (Employee) ooi.readObject();
            System.out.println(readEmpInfo.getEmpname());
            System.out.println(readEmpInfo.getEmpaddress());
            System.out.println(readEmpInfo.getEmpid());
            System.out.println(readEmpInfo.getEmppassword());
            ooi.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
class testCreateInstance{
    void fun() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class<String> s = String.class;
        String instance = s.getDeclaredConstructor().newInstance();
    }
}

class testCallByValue{
    public static void main(String[] args) {
        A a = new A(1);
        A b = new A(2);
        run(a,b);
        System.out.println("a : "+a.val);
        System.out.println("b : "+b.val);
    }
    static void run(A arg1, A arg2){
        arg1.val=111;
        arg2=arg1;
        System.out.println("arg2 : "+arg2.val);

    }
    static class A{
        int val;
        A(int a) {
            val = a;
        }
    }
}

class testReflection{
    enum E { A, B }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        byte[] bytes = new byte[1024];
        int a=0;
        Class c = bytes.getClass();
        Class c2 = "foo".getClass();
        Class c3 =  boolean.class;
        Class c4 = int[][][].class;
        Class c6 = String[][].class;
        Class c5 = E.A.getClass();
        System.out.println(c2+" "+c+" "+c3+" "+c4+" "+c5);

        Class cStringArray = Class.forName("[[Ljava.lang.String;");
        System.out.println(c6);
        HashSet<Integer> hashSet = new HashSet<>();
        Class<?>[] c7 = Character.class.getClasses();
        System.out.println(c7);;
        Field f = System.class.getField("out"); // System
        Class c8 = f.getDeclaringClass(); // null
        System.out.println(c8);

    }

}